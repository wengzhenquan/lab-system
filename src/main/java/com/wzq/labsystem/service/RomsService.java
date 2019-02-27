package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.RomsDto;
import com.wzq.labsystem.dto.RomsLogDto;
import com.wzq.labsystem.dto.po.Roms;
import com.wzq.labsystem.dto.po.RomsLog;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.RomsLogMapper;
import com.wzq.labsystem.mapper.RomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;


@Service
public class RomsService {
    @Autowired
    private RomsMapper romsMapper;

    @Autowired
    private RomsLogMapper romsLogMapper;

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
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsDto> selectRomsAll(Integer pageNo, Integer pageSize) {
        List<RomsDto> roms = romsMapper.selectAll(pageNo, pageSize);
        Long count = romsMapper.selectCount();
        PageDto<RomsDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(roms);
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
     * 提交申请
     * @param romsLog
     * @return
     */
    public Integer insertLog(RomsLog romsLog){
        Assert.isNull(romsLog.getUserId(),"申请人ID不能为空");
        Assert.isNull(romsLog.getStartTime(),"开始时间不能为空");
        Assert.isNull(romsLog.getEndTime(),"结束时间不能为空");
        romsLog.setCreatTime(Instant.now());
        romsLog.setState(0);
        int result = romsLogMapper.insert(romsLog);
        if(0 == result) throw new ServiceException(501, "申请提交失败");
        return result;
    }

    /**
     * 查询全部申请，管理员
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsLogDto> selectAll(Integer pageNo, Integer pageSize) {
        List<RomsLogDto> logDtos = romsLogMapper.selectAll(pageNo, pageSize);
        Long count = romsLogMapper.selectCount();
        PageDto<RomsLogDto> pageDto = new PageDto<>();
        pageDto.setData(logDtos);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 查询某用户全部申请
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsLogDto> selectAllByUserId(Long userId,Integer pageNo, Integer pageSize) {
        List<RomsLogDto> logDtos = romsLogMapper.selectAllByUserId(userId,pageNo, pageSize);
        Long count = romsLogMapper.selectCountByUserId(userId);
        PageDto<RomsLogDto> pageDto = new PageDto<>();
        pageDto.setData(logDtos);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 查询某教室被申请的所有记录
     * @param romId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<RomsLogDto> selectAllByRomId(Long romId,Integer pageNo, Integer pageSize) {
        List<RomsLogDto> logDtos = romsLogMapper.selectAllByRomId(romId,pageNo, pageSize);
        Long count = romsLogMapper.selectCountByRomId(romId);
        PageDto<RomsLogDto> pageDto = new PageDto<>();
        pageDto.setData(logDtos);
        pageDto.setTotal(count);
        return pageDto;
    }



}
