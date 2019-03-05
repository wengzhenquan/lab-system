package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.EquipmentLogDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.po.EquipmentLog;
import com.wzq.labsystem.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"3-2 设备申请管理"})
public class EquipmentLogController {
    @Autowired
    private EquipmentService equipmentService;

    @ApiOperation("添加申请")
    @PostMapping("insertEquipmentLog")
    public ResultDto<Integer> insertEquipmentLog(@RequestBody EquipmentLog equipmentLog){
        return ResultDto.ok(equipmentService.insertEquipmentLog(equipmentLog));
    }

    @ApiOperation("修改申请")
    @PostMapping("updateEquipmentLog")
    public ResultDto<Integer> updateEquipment(@RequestBody EquipmentLog equipmentLog){
        return ResultDto.ok(equipmentService.updateEquipmentLog(equipmentLog));
    }

    @ApiOperation("查询所有申请")
    @GetMapping("selectEquipmentLogAll")
    public ResultDto<PageDto<EquipmentLogDto>> selectEquipmentLogAll(@RequestBody EquipmentLog equipmentLog, @RequestParam Integer pageNo,@RequestParam Integer pageSize){
        return ResultDto.ok(equipmentService.selectEquipmentLogAll(equipmentLog,pageNo, pageSize));
    }

    @ApiOperation("查询申请")
    @GetMapping("selectEquipmentLoById")
    public ResultDto<EquipmentLogDto> selectEquipmentLoById(@RequestParam Long equipmentLogId){
        return ResultDto.ok(equipmentService.selectLogById(equipmentLogId));
    }



}
