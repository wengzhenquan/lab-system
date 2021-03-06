package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.EquipmentDto;
import com.wzq.labsystem.dto.EquipmentLogDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.po.Equipment;
import com.wzq.labsystem.dto.po.EquipmentClass;
import com.wzq.labsystem.dto.po.EquipmentLog;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.EquipmentClassMapper;
import com.wzq.labsystem.mapper.EquipmentLogMapper;
import com.wzq.labsystem.mapper.EquipmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private EquipmentClassMapper equipmentClassMapper;

    @Autowired
    private EquipmentLogMapper equipmentLogMapper;

    /**
     * 添加设备
     * @param equipment
     * @return
     */
    public Integer insertEquipment(Equipment equipment){
        Assert.notNull(equipment.getEqName(),"设备名称不能为空");
        Assert.notNull(equipment.getEqClassId(),"设备分类不能为空");
        equipment.setSerNumb(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if(null == equipment.getRomId()) equipment.setRomId(0L);
        Instant timeNow = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        equipment.setBuyTime(timeNow);
        if(null == equipment.getUpdateTime())
        equipment.setUpdateTime(timeNow);
        equipment.setState(0);
        int result = equipmentMapper.insert(equipment);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改设备信息
     * @param equipment
     * @return
     */
    public Integer updateEquipment(Equipment equipment){
        Assert.notNull(equipment.getEqClassId(),"设备分类不能为空");
        int result = equipmentMapper.updateByPrimaryKey(equipment);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询所有设备信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentDto> selectEquipmentAll(Long romId,
                                                    Integer romNumb,
                                                    String romName,
                                                    String eqName,
                                                    String equipmentSerNumb,
                                                    Long eqClassId,
                                                    String typeName,
                                                    Integer state,
                                                    Integer pageNo,
                                                    Integer pageSize) {
        pageNo = pageSize * (pageNo - 1);
        List<EquipmentDto> equipmentlist = equipmentMapper.selectAll(romId,romNumb,romName,eqName,equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize);
        Long count = equipmentMapper.selectCount(romId,romNumb,romName,eqName,equipmentSerNumb,eqClassId,typeName,state);
        PageDto<EquipmentDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(equipmentlist);
        return pageDto;
    }

    /**
     * 查询已分配所有设备信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentDto> selectEquipmentAllocated(Integer romNumb,
                                                    String romName,
                                                    String eqName,
                                                    String equipmentSerNumb,
                                                    Long eqClassId,
                                                    String typeName,
                                                    Integer state,
                                                    Integer pageNo,
                                                    Integer pageSize) {
        pageNo = pageSize * (pageNo - 1);
        List<EquipmentDto> equipmentlist = equipmentMapper.selectAllocated(romNumb,romName,eqName,equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize);
        Long count = equipmentMapper.selectCountAllocated(romNumb,romName,eqName,equipmentSerNumb,eqClassId,typeName,state);
        PageDto<EquipmentDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(equipmentlist);
        return pageDto;
    }
    /**
     * 查询未分配所有设备信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentDto> selectEquipmentUnallocated(String eqName,
                                                            String equipmentSerNumb,
                                                          Long eqClassId,
                                                          String typeName,
                                                          Integer state,
                                                          Integer pageNo,
                                                          Integer pageSize) {
        pageNo = pageSize * (pageNo - 1);
        List<EquipmentDto> equipmentlist = equipmentMapper.selectUnallocated(eqName,equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize);
        Long count = equipmentMapper.selectCountUnallocated(eqName,equipmentSerNumb,eqClassId,typeName,state);
        PageDto<EquipmentDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(equipmentlist);
        return pageDto;
    }
    /**
     * 查询设备信息
     * @param equipmentId
     * @return
     */
    public EquipmentDto selectById(Long equipmentId){
        return equipmentMapper.selectByPrimaryKey(equipmentId);
    }


    /**
     * 删除设备
     * @param equipmentId
     * @return
     */
    public Integer deleteEquipment(Long equipmentId){
        int result = equipmentMapper.deleteByPrimaryKey(equipmentId);
        if(0 == result) throw new ServiceException(501, "删除失败");
        return result;
    }


    // TODO 设备分类

    /**
     * 添加设备分类
     * @param equipmentClass
     * @return
     */
    public Integer insertEquipmentClass(EquipmentClass equipmentClass){
        Assert.notNull(equipmentClass.getTypeName(),"分类名称不能为空");
        int result = equipmentClassMapper.insert(equipmentClass);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改设备分类
     * @param equipmentClass
     * @return
     */
    public Integer updateEquipmentClass(EquipmentClass equipmentClass){
        Assert.notNull(equipmentClass.getTypeName(),"分类名称不能为空");
        int result = equipmentClassMapper.updateByPrimaryKey(equipmentClass);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询所有设备分类
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentClass> selectEquipmentClassAll(Integer pageNo, Integer pageSize) {
        pageNo = pageSize * (pageNo - 1);
        List<EquipmentClass> equipmentClasslist = equipmentClassMapper.selectAll(pageNo, pageSize);
        Long count = equipmentClassMapper.selectCount();
        PageDto<EquipmentClass> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(equipmentClasslist);
        return pageDto;
    }

    /**
     * 查询设备分类
     * @param equipmentClassId
     * @return
     */
    public EquipmentClass selectClassById(Long equipmentClassId){
        return equipmentClassMapper.selectByPrimaryKey(equipmentClassId);
    }




    // TODO 设备申请
    /**
     * 添加申请
     * @param equipmentLog
     * @return
     */
    public Integer insertEquipmentLog(EquipmentLog equipmentLog){
        Assert.notNull(equipmentLog.getUserId(),"申请人不能为空");
        Assert.notNull(equipmentLog.getEqClassId(),"设备类型不能为空");
        Assert.notNull(equipmentLog.getType(),"申请类型不能为空");
        Assert.notNull(equipmentLog.getTitle(),"标题不能为空");
        Assert.notNull(equipmentLog.getNeed(),"需求描述不能为空");
        equipmentLog.setState(0);
        if(null == equipmentLog.getCreatTime())
        equipmentLog.setCreatTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = equipmentLogMapper.insert(equipmentLog);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改申请
     * @param equipmentLog
     * @return
     */
    public Integer updateEquipmentLog(EquipmentLog equipmentLog){
        Assert.notNull(equipmentLog.getUserId(),"申请人不能为空");
        Assert.notNull(equipmentLog.getEqClassId(),"设备类型不能为空");
        Assert.notNull(equipmentLog.getType(),"申请类型不能为空");
        Assert.notNull(equipmentLog.getTitle(),"标题不能为空");
        Assert.notNull(equipmentLog.getNeed(),"需求描述不能为空");
        int result = equipmentLogMapper.updateByPrimaryKey(equipmentLog);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询所有申请
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentLogDto> selectEquipmentLogAll(Long userId,
                                                          String applyName,
                                                          Long handleUserId,
                                                          String handleUserName,
                                                          Long eqClassId,
                                                          String typeName,
                                                          Integer type,
                                                          Integer state,
                                                          Integer pageNo,
                                                          Integer pageSize) {
        Assert.notNull(type,"类型不能为空！");
        pageNo = pageSize * (pageNo - 1);
        List<EquipmentLogDto> equipmentLoglist = equipmentLogMapper.selectAll(userId,applyName,handleUserId,handleUserName,eqClassId,typeName,type,state,pageNo, pageSize);
        Long count = equipmentLogMapper.selectCount(userId,applyName,handleUserId,handleUserName,eqClassId,typeName,type,state);
        PageDto<EquipmentLogDto> pageDto = new PageDto<>();
        pageDto.setTotal(count);
        pageDto.setData(equipmentLoglist);
        return pageDto;
    }

    /**
     * 查询申请
     * @param equipmentLogId
     * @return
     */
    public EquipmentLogDto selectLogById(Long equipmentLogId){
        return equipmentLogMapper.selectByPrimaryKey(equipmentLogId);
    }

    /**
     * 删除申请记录
     * @param equipmentLogId
     * @return
     */
    public Integer deleteEquipmentLog(Long equipmentLogId){
        int result = equipmentLogMapper.deleteByPrimaryKey(equipmentLogId);
        if(0 == result) throw new ServiceException(501, "删除失败");
        return result;
    }





}
