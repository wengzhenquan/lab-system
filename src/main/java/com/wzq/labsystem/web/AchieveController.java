package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.AchieveDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.service.AchieveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags ={"2-5 成绩管理"})
public class AchieveController {
    @Autowired
    private AchieveService achieveService;

    @ApiOperation("老师查看某课程学生成绩列表")
    @GetMapping("selectAchieveAllByTeacherId")
    public ResultDto<PageDto<AchieveDto>> selectAchieveAllByTeacherId(@RequestParam Long courseId,
                                                                      @RequestParam Long teacherUserId,
                                                                      @RequestParam Integer pageNo,
                                                                      @RequestParam Integer pageSize){
        return ResultDto.ok(achieveService.selectAchieveAllByTeacherId(courseId,teacherUserId, pageNo, pageSize));
    }

    @ApiOperation("学生查看课程成绩列表")
    @GetMapping("selectAchieveAllByStudentId")
    public ResultDto<PageDto<AchieveDto>> selectAchieveAllByStudentId(@RequestParam Long studentId,
                                                                      @RequestParam Integer pageNo,
                                                                      @RequestParam Integer pageSize){
        return ResultDto.ok(achieveService.selectAchieveAllByStudentId(studentId, pageNo, pageSize));
    }

    @ApiOperation("修改某个学生成绩")
    @GetMapping("updateAchieveBy")
    public ResultDto<Integer> updateAchieveBy(@RequestParam Double achieve,
                                              @RequestParam Long courseId,
                                              @RequestParam Long studentId,
                                              @RequestParam Long teacherId){
        return ResultDto.ok(achieveService.updateAchieveBy(achieve, courseId, studentId, teacherId));
    }

    @ApiOperation("自动计算并修改某位学生成绩(按照实验报告平均分/100*100% *总学分)")
    @GetMapping("autoAchieveOnStudent")
    public ResultDto<Integer> autoAchieveOnStudent(@RequestParam Long courseId,
                                                  @RequestParam Long studentId,
                                                  @RequestParam Long teacherId){
        return ResultDto.ok(achieveService.autoAchieveOnStudent(courseId, studentId, teacherId));
    }

    @ApiOperation("批量自动计算某课程所有学生的成绩")
    @GetMapping("autoAchieveOnCourse")
    public ResultDto<String> autoAchieveOnCourse(@RequestParam Long courseId,
                                                   @RequestParam Long teacherId){
        return ResultDto.ok(achieveService.autoAchieveOnCourse(courseId, teacherId));
    }



}
