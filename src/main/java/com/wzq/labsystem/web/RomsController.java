package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.RomsDto;
import com.wzq.labsystem.dto.po.Roms;
import com.wzq.labsystem.service.RomsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"3-1 实验室管理"})
public class RomsController {
    @Autowired
    private RomsService romsService;

    @ApiOperation("添加实验室")
    @PostMapping("insertRoms")
    public ResultDto<Integer> insertRoms(@RequestBody Roms roms){
        return ResultDto.ok(romsService.insertRoms(roms));
    }

    @ApiOperation("修改实验室信息")
    @PostMapping("updateRoms")
    public ResultDto<Integer> updateRoms(@RequestBody Roms roms){
        return ResultDto.ok(romsService.updateRoms(roms));
    }

    @ApiOperation("查询所有实验室列表")
    @GetMapping("selectRomsAll")
    public ResultDto<PageDto<RomsDto>> selectRomsAll(@RequestParam(value ="numb",required = false) Integer numb,
                                                     @RequestParam(value ="userId",required = false) Long userId,
                                                     @RequestParam(value ="state",required = false) Integer state,
                                                     @RequestParam Integer pageNo,
                                                     @RequestParam Integer pageSize){
        return ResultDto.ok(romsService.selectRomsAll(numb,userId,state,pageNo, pageSize));
    }

    @ApiOperation("通过ID查询实验室信息")
    @PostMapping("selectRomById")
    public ResultDto<RomsDto> selectRomById(@RequestParam Long romsId){
        return ResultDto.ok(romsService.selectRomById(romsId));
    }

    @ApiOperation("修改实验室状态")
    @GetMapping("updateRomState")
    public ResultDto<Integer> updateRomState(@RequestParam Integer state,@RequestParam Long romId){
        return ResultDto.ok(romsService.updateRomState(state, romId));
    }





}
