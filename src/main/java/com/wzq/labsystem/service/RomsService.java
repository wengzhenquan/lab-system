package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.RomsDto;
import com.wzq.labsystem.dto.RomsLogDto;
import com.wzq.labsystem.dto.RomsStateUpdateDto;
import com.wzq.labsystem.dto.po.Roms;
import com.wzq.labsystem.dto.po.RomsLog;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.RomsLogMapper;
import com.wzq.labsystem.mapper.RomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Service
public class RomsService {
    @Autowired
    private RomsMapper romsMapper;

    @Autowired
    private RomsLogMapper romsLogMapper;

    // 需要被修改教室状态的房间列表（定时器使用）
    private static List<RomsStateUpdateDto> updaRomStateList = new ArrayList<>();

     {
         romsMapper.updateStateInitialize();

         List<RomsLogDto> romsLogDtos = romsLogMapper.selectAll(RomsLog.builder().state(1).build(), null, null);
         Instant timeNow = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
         List<RomsStateUpdateDto> list = romsLogDtos.stream()
                 .filter(romsLogDto -> timeNow.isBefore(romsLogDto.getEndTime()))
                 .map(romsLogDto -> RomsStateUpdateDto.builder()
                                        .romLogId(romsLogDto.getLogId())
                                        .romId(romsLogDto.getRomId())
                                        .startTime(romsLogDto.getStartTime())
                                        .endTime(romsLogDto.getEndTime()).build())
                 .collect(Collectors.toList());

         updaRomStateList.addAll(list);

     }

    /**
     * 添加房间
     * @param roms
     * @return
     */
    public Integer insertRoms(Roms roms){
        Assert.isNull(roms.getNumb(),"编号不能为空");
        Assert.isNull(roms.getType(),"类型不能为空");
        roms.setState(0);
        int result = romsMapper.insert(roms);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改房间信息
     * @param roms
     * @return
     */
    public Integer updateRoms(Roms roms){
        Assert.isNull(roms.getNumb(),"编号不能为空");
        Assert.isNull(roms.getType(),"类型不能为空");
        int result = romsMapper.updateByPrimaryKey(roms);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询所有教室列表
     * @param roms
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsDto> selectRomsAll(Roms roms,Integer pageNo, Integer pageSize) {
        List<RomsDto> romlist = romsMapper.selectAll(roms,pageNo, pageSize);
        Long count = romsMapper.selectCount(roms);
        PageDto<RomsDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(romlist);
        return pageDto;
    }

    /**
     * 查询教室信息
     * @param romsId
     * @return
     */
    public RomsDto selectById(Long romsId){
        return romsMapper.selectByPrimaryKey(romsId);
    }

    /**
     * 修改房间状态
     * @param state 状态(0空闲,1使用中)
     * @param romId 教室ID
     * @return
     */
    public Integer updateRomState(Integer state, Long romId){
        int result = romsMapper.updateStateByPrimaryKey(state, romId);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }



    /**
     * 提交申请
     * @param romsLog
     * @return
     */
    public Integer insertLog(RomsLog romsLog){
        Assert.isNull(romsLog.getUserId(),"申请人ID不能为空");
        Assert.isNull(romsLog.getStartTime(),"开始时间不能为空");
        Assert.isNull(romsLog.getEndTime(),"结束时间不能为空");
        romsLog.setCreatTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        romsLog.setState(0);
        int result = romsLogMapper.insert(romsLog);
        if(0 == result) throw new ServiceException(501, "申请提交失败");
        return result;
    }

    /**
     * 根据条件查询申请
     * @param romsLog 查询条件
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsLogDto> selectLogAll(RomsLog romsLog,Integer pageNo, Integer pageSize) {
        List<RomsLogDto> logDtos = romsLogMapper.selectAll(romsLog,pageNo, pageSize);
        Long count = romsLogMapper.selectCount(romsLog);
        PageDto<RomsLogDto> pageDto = new PageDto<>();
        pageDto.setData(logDtos);
        pageDto.setTotal(count);
        return pageDto;
    }



    /**
     * 修改申请状态
     * @param romRomLogId 申请记录ID
     * @param romId 分配的教室ID  若状态为2  可以为null
     * @param state 状态(0申请中,1已审批,2未通过审批)
     * @param handleUserId 处理人ID
     * @return
     */
    public Integer updateRomLogState(Long romRomLogId,Long romId, Integer state,Long handleUserId){
        RomsLog romsLog = romsLogMapper.selectByPrimaryKey(romRomLogId);
        Integer stateOld = romsLog.getState();
        if(0 == state) throw new ServiceException(502, "不能将状态改为审批中");
        Integer result = 0;
        if (state > stateOld){
            switch (state){
                case 1:{
                    Assert.isNull(romId,"通过审批，请指定教室ID");
                    result = romsLogMapper.updateState(RomsLog.builder()
                            .id(romRomLogId)
                            .handleUserId(handleUserId)
                            .handleTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)))
                            .romId(romId)
                            .state(state).build());
                    updaRomStateList.add(RomsStateUpdateDto.builder()
                            .romLogId(romsLog.getId())
                            .romId(romId)
                            .startTime(romsLog.getStartTime())
                            .endTime(romsLog.getEndTime()).build());
                    break;
                }
                case 2:{
                    result = romsLogMapper.updateState(RomsLog.builder()
                            .id(romRomLogId)
                            .handleUserId(handleUserId)
                            .handleTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)))
                            .state(state).build());
                    break;
                }
            }
        }
        if(0 == result) throw new ServiceException(501, "操作失败");
        return result;
    }

    /**
     * 每30秒检查一次需要修改状态的房间
     */
    @Scheduled(cron = "0/30 * * * * *")
    public void checkAndUpdateRomsState(){
        if(0 == updaRomStateList.size()) return;
        Iterator<RomsStateUpdateDto> iterator = updaRomStateList.iterator();
        while (iterator.hasNext()){
            RomsStateUpdateDto next = iterator.next();
            Instant nowTime = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
            if (nowTime.isAfter(next.getStartTime()) && nowTime.isBefore(next.getEndTime())) {
                romsMapper.updateStateByPrimaryKey(1, next.getRomId());
            }
            if (nowTime.isAfter(next.getEndTime())) {
                romsMapper.updateStateByPrimaryKey(0, next.getRomId());
                iterator.remove();
            }

        }

    }

}
