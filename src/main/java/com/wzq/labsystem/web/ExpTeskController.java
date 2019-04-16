package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.ExpTeskDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.po.ExpTesk;
import com.wzq.labsystem.service.ExpTeskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-2 实验任务管理"})
public class ExpTeskController {
    @Autowired
    private ExpTeskService expTeskService;

    @ApiOperation("获取实验任务列表")
    @GetMapping("selectExpTeskAll")
    public ResultDto<PageDto<ExpTeskDto>> selectExpTeskAll(@RequestParam(value ="courseId",required = false) Long courseId,
                                                           @RequestParam(value ="courseName",required = false) String courseName,
                                                           @RequestParam(value ="romId",required = false) Long romId,
                                                           @RequestParam(value ="romName",required = false) String romName,
                                                           @RequestParam Integer pageNo,
                                                           @RequestParam Integer pageSize){
        return ResultDto.ok(expTeskService.selectExpTeskAll(courseId,courseName,romId,romName, pageNo, pageSize));
    }

    @ApiOperation("添加实验任务")
    @PostMapping("insertExpTesk")
    public ResultDto<Integer> insertExpTesk(@RequestBody ExpTesk expTesk){
        return ResultDto.ok(expTeskService.insertExpTesk(expTesk));
    }

    @ApiOperation("修改实验任务")
    @PostMapping("updateExpTesk")
    public ResultDto<Integer> updateExpTesk(@RequestBody ExpTesk expTesk){
        return ResultDto.ok(expTeskService.updateExpTesk(expTesk));
    }

    @ApiOperation("通过Id查询实验任务")
    @GetMapping("selectExpTeskById")
    public ResultDto<ExpTeskDto> selectExpTeskById(@RequestParam Long expTeskId){
        return ResultDto.ok(expTeskService.selectExpTeskById(expTeskId));
    }

    @ApiOperation("获取实验任务下的实验报告数（删除前确认）")
    @GetMapping("getReportCount")
    public ResultDto<Long> getReportCount(@RequestParam Long expTeskId){
        return ResultDto.ok(expTeskService.getReportCount(expTeskId));
    }

    @ApiOperation("删除实验任务（确认删除）")
    @GetMapping("deleteExpTesk")
    public ResultDto<Integer> deleteExpTesk(@RequestParam Long expTeskId){
        return ResultDto.ok(expTeskService.deleteExpTesk(expTeskId));
    }
}
