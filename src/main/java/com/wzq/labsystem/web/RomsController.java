package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.RomsDto;
import com.wzq.labsystem.dto.RomsLogDto;
import com.wzq.labsystem.dto.po.Roms;
import com.wzq.labsystem.dto.po.RomsLog;
import com.wzq.labsystem.service.RomsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-1 房间教室管理"})
public class RomsController {
    @Autowired
    private RomsService romsService;

    @ApiOperation("添加房间")
    @PostMapping("insertRoms")
    public ResultDto<Integer> insertRoms(@RequestBody Roms roms){
        return ResultDto.ok(romsService.insertRoms(roms));
    }

    @ApiOperation("修改房间信息")
    @PostMapping("updateRoms")
    public ResultDto<Integer> updateRoms(@RequestBody Roms roms){
        return ResultDto.ok(romsService.updateRoms(roms));
    }

    @ApiOperation("查询所有教室列表")
    @PostMapping("selectRomsAll")
    public ResultDto<PageDto<RomsDto>> selectRomsAll(@RequestBody Roms roms,@RequestParam Integer pageNo,@RequestParam   Integer pageSize){
        return ResultDto.ok(romsService.selectRomsAll(roms,pageNo, pageSize));
    }

    @ApiOperation("查询教室信息")
    @PostMapping("selectById")
    public ResultDto<RomsDto> selectById(@RequestParam Long romsId){
        return ResultDto.ok(romsService.selectById(romsId));
    }

    @ApiOperation("修改房间状态")
    @GetMapping("updateRomState")
    public ResultDto<Integer> updateRomState(@RequestParam Integer state,@RequestParam Long romId){
        return ResultDto.ok(romsService.updateRomState(state, romId));
    }

    @ApiOperation("提交申请")
    @GetMapping("insertLog")
    public ResultDto<Integer> insertLog(@RequestBody RomsLog romsLog){
        return ResultDto.ok(romsService.insertLog(romsLog));
    }

    @ApiOperation("根据条件查询申请")
    @GetMapping("selectLogAll")
    public ResultDto<PageDto<RomsLogDto>> selectLogAll(@RequestParam RomsLog romsLog,@RequestParam Integer pageNo,@RequestParam Integer pageSize){
        return ResultDto.ok(romsService.selectLogAll(romsLog,pageNo, pageSize));
    }

    @ApiOperation("修改申请状态")
    @GetMapping("updateRomLogState")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "romRomLogId", value = "申请记录ID"),
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "romId", value = "分配的教室ID  若状态为2  可以为null"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "state", value = "状态(0申请中,1已审批,2未通过审批)"),
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "handleUserId", value = "处理人ID")
    })
    public ResultDto<Integer> updateRomLogState(@RequestParam Long romRomLogId,
                                                @RequestParam Long romId,
                                                @RequestParam Integer state,
                                                @RequestParam Long handleUserId){
        return ResultDto.ok(romsService.updateRomLogState(romRomLogId, romId, state, handleUserId));
    }



}
