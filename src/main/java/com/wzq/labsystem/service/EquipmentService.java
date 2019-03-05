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
        Assert.isNull(equipment.getEqClassId(),"设备分类不能为空");
        equipment.setSerNumb(UUID.randomUUID().toString().replace("-","").toUpperCase());
        Instant timeNow = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        equipment.setBuyTime(timeNow);
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
        Assert.isNull(equipment.getEqClassId(),"设备分类不能为空");
        int result = equipmentMapper.updateByPrimaryKey(equipment);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 查询所有设备信息
     * @param equipment
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<EquipmentDto> selectEquipmentAll(Equipment equipment, Integer pageNo, Integer pageSize) {
        List<EquipmentDto> equipmentlist = equipmentMapper.selectAll(equipment,pageNo, pageSize);
        Long count = equipmentMapper.selectCount(equipment);
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



    // TODO 设备分类

    /**
     * 添加设备分类
     * @param equipmentClass
     * @return
     */
    public Integer insertEquipmentClass(EquipmentClass equipmentClass){
        Assert.isNull(equipmentClass.getTypeName(),"分类名称不能为空");
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
        Assert.isNull(equipmentClass.getTypeName(),"分类名称不能为空");
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
        Assert.isNull(equipmentLog.getUserId(),"申请人不能为空");
        Assert.isNull(equipmentLog.getEqClassId(),"设备类型不能为空");
        Assert.isNull(equipmentLog.getType(),"申请类型不能为空");
        Assert.isNull(equipmentLog.getTitle(),"标题不能为空");
        Assert.isNull(equipmentLog.getNeed(),"需求描述不能为空");
        equipmentLog.setState(0);
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
        Assert.isNull(equipmentLog.getUserId(),"申请人不能为空");
        Assert.isNull(equipmentLog.getEqClassId(),"设备类型不能为空");
        Assert.isNull(equipmentLog.getType(),"申请类型不能为空");
        Assert.isNull(equipmentLog.getTitle(),"标题不能为空");
        Assert.isNull(equipmentLog.getNeed(),"需求描述不能为空");
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
    public PageDto<EquipmentLogDto> selectEquipmentLogAll(EquipmentLog equipmentLog,Integer pageNo, Integer pageSize) {
        List<EquipmentLogDto> equipmentLoglist = equipmentLogMapper.selectAll(equipmentLog,pageNo, pageSize);
        Long count = equipmentLogMapper.selectCount(equipmentLog);
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



}
