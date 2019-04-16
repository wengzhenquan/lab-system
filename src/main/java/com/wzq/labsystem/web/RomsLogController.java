package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.RomsLogDto;
import com.wzq.labsystem.dto.po.RomsLog;
import com.wzq.labsystem.service.RomsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"3-2 实验室申请"})
public class RomsLogController {
    @Autowired
    private RomsService romsService;



    @ApiOperation("提交申请")
    @PostMapping("insertRomLog")
    public ResultDto<Integer> insertRomLog(@RequestBody RomsLog romsLog){
        return ResultDto.ok(romsService.insertRomLog(romsLog));
    }

    @ApiOperation("根据条件查询申请")
    @GetMapping("selectRomLogAll")
    public ResultDto<PageDto<RomsLogDto>> selectRomLogAll(@RequestParam(value ="userId",required = false) Long userId,
                                                          @RequestParam(value ="handleUserId",required = false) Long handleUserId,
                                                          @RequestParam(value ="romId",required = false) Long romId,
                                                          @RequestParam(value ="state",required = false) Integer state,
                                                          @RequestParam Integer pageNo,
                                                          @RequestParam Integer pageSize){
        return ResultDto.ok(romsService.selectRomLogAll(userId,handleUserId,romId,state,pageNo, pageSize));
    }

    @ApiOperation("修改申请状态")
    @GetMapping("updateRomLogState")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "romLogId", value = "申请记录ID"),
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "romId", value = "分配的教室ID  若状态为2  可以为null"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "state", value = "状态(0申请中,1已审批,2未通过审批)"),
            @ApiImplicitParam(paramType = "query", dataType = "long", name = "handleUserId", value = "处理人ID")
    })
    public ResultDto<Integer> updateRomLogState(@RequestParam Long romLogId,
                                                @RequestParam Long romId,
                                                @RequestParam Integer state,
                                                @RequestParam Long handleUserId){
        return ResultDto.ok(romsService.updateRomLogState(romLogId, romId, state, handleUserId));
    }


    @ApiOperation("删除实验室申请记录")
    @GetMapping("deleteRomLog")
    public ResultDto<Integer> deleteRomLog(@RequestParam Long romLogId){
        return ResultDto.ok(romsService.deleteRomLog(romLogId));
    }

}
