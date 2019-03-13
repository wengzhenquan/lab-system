package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.ExpReportDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.po.ExpReport;
import com.wzq.labsystem.service.ExpReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"2-3 实验报告管理"})
public class ExpReportController {
    @Autowired
    private ExpReportService expReportService;

    @ApiOperation("获取实验报告列表")
    @GetMapping("selectExpReportAll")
    public ResultDto<PageDto<ExpReportDto>> selectExpReportAll(@RequestParam(value ="teskId",required = false) Long teskId,
                                                               @RequestParam(value ="title",required = false) String title,
                                                               @RequestParam(value ="studentUserId",required = false) Long studentUserId,
                                                               @RequestParam(value ="name",required = false) String name,
                                                               @RequestParam Integer pageNo,
                                                               @RequestParam Integer pageSize){
        return ResultDto.ok(expReportService.selectExpReportAll(teskId,title,studentUserId,name, pageNo, pageSize));
    }

    @ApiOperation("添加实验报告")
    @PostMapping("insertExpReport")
    public ResultDto<Integer> insertExpReport(@RequestBody ExpReport expReport){
        return ResultDto.ok(expReportService.insertExpReport(expReport));
    }

    @ApiOperation("修改实验任务")
    @PostMapping("updateExpReport")
    public ResultDto<Integer> updateExpReport(@RequestBody ExpReport expReport){
        return ResultDto.ok(expReportService.updateExpReport(expReport));
    }

    @ApiOperation("通过Id查询实验报告信息")
    @GetMapping("selectExpReportById")
    public ResultDto<ExpReportDto> selectExpReportById(@RequestParam Long expReportId){
        return ResultDto.ok(expReportService.selectExpReportById(expReportId));
    }

}
