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
@Api(tags ={"4-1 设备管理"})
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
    public ResultDto<PageDto<EquipmentDto>> selectEquipmentAll(@RequestParam(value ="romId",required = false) Long romId,
                                                               @RequestParam(value ="romNumb",required = false) Integer romNumb,
                                                               @RequestParam(value ="romName",required = false) String romName,
                                                               @RequestParam(value ="equipmentSerNumb",required = false) String equipmentSerNumb,
                                                               @RequestParam(value ="eqClassId",required = false) Long eqClassId,
                                                               @RequestParam(value ="typeName",required = false) String typeName,
                                                               @RequestParam(value ="state",required = false) Integer state,
                                                               @RequestParam Integer pageNo,
                                                               @RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentAll(romId,romNumb,romName,equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize));
    }
    @ApiOperation("查询已分配所有设备信息")
    @GetMapping("selectEquipmentAllocated")
    public ResultDto<PageDto<EquipmentDto>> selectEquipmentAllocated(@RequestParam(value ="romNumb",required = false) Integer romNumb,
                                                               @RequestParam(value ="romName",required = false) String romName,
                                                               @RequestParam(value ="equipmentSerNumb",required = false) String equipmentSerNumb,
                                                               @RequestParam(value ="eqClassId",required = false) Long eqClassId,
                                                               @RequestParam(value ="typeName",required = false) String typeName,
                                                               @RequestParam(value ="state",required = false) Integer state,
                                                               @RequestParam Integer pageNo,
                                                               @RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentAllocated(romNumb,romName,equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize));
    }
    @ApiOperation("查询未分配所有设备信息")
    @GetMapping("selectEquipmentUnallocated")
    public ResultDto<PageDto<EquipmentDto>> selectEquipmentUnallocated(@RequestParam(value ="equipmentSerNumb",required = false) String equipmentSerNumb,
                                                               @RequestParam(value ="eqClassId",required = false) Long eqClassId,
                                                               @RequestParam(value ="typeName",required = false) String typeName,
                                                               @RequestParam(value ="state",required = false) Integer state,
                                                               @RequestParam Integer pageNo,
                                                               @RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentUnallocated(equipmentSerNumb,eqClassId,typeName,state,pageNo, pageSize));
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

    @ApiOperation("删除设备")
    @GetMapping("deleteEquipment")
    public ResultDto<Integer> deleteEquipment(@RequestParam Long equipmentId){
        return ResultDto.ok(equipmentService.deleteEquipment(equipmentId));
    }


}
