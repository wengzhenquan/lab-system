package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.EquipmentDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.po.Equipment;
import com.wzq.labsystem.dto.po.EquipmentClass;
import com.wzq.labsystem.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"3-1 设备管理"})
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @ApiOperation("添加设备")
    @PostMapping("insertEquipment")
    public ResultDto<Integer> insertEquipment(@RequestBody Equipment equipment){
        return ResultDto.ok(equipmentService.insertEquipment(equipment));
    }

    @ApiOperation("修改设备信息")
    @PostMapping("updateEquipment")
    public ResultDto<Integer> updateEquipment(@RequestBody Equipment equipment){
        return ResultDto.ok(equipmentService.updateEquipment(equipment));
    }

    @ApiOperation("查询所有设备信息")
    @GetMapping("selectEquipmentAll")
    public ResultDto<PageDto<EquipmentDto>> selectEquipmentAll(@RequestBody Equipment equipment, @RequestParam Integer pageNo,@RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentAll(equipment,pageNo, pageSize));
    }

    @ApiOperation("查询设备信息")
    @GetMapping("selectEquipmentById")
    public ResultDto<EquipmentDto> selectEquipmentById(@RequestParam Long equipmentId){
        return ResultDto.ok(equipmentService.selectById(equipmentId));
    }

    @ApiOperation("添加设备分类")
    @PostMapping("insertEquipmentClass")
    public ResultDto<Integer> insertEquipmentClass(@RequestBody EquipmentClass equipmentClass){
        return ResultDto.ok(equipmentService.insertEquipmentClass(equipmentClass));
    }

    @ApiOperation("修改设备分类")
    @PostMapping("updateEquipmentClass")
    public ResultDto<Integer> updateEquipmentClass(@RequestBody EquipmentClass equipmentClass){
        return ResultDto.ok(equipmentService.updateEquipmentClass(equipmentClass));
    }

    @ApiOperation("查询所有设备分类")
    @GetMapping("selectEquipmentClassAll")
    public ResultDto<PageDto<EquipmentClass>> selectEquipmentClassAll(@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentClassAll(pageNo, pageSize));
    }

    @ApiOperation("查询设备分类")
    @GetMapping("selectClassById")
    public ResultDto<EquipmentClass> selectClassById(@RequestParam Long equipmentClassId){
        return ResultDto.ok(equipmentService.selectClassById(equipmentClassId));
    }

}
