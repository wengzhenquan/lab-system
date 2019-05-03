package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.UserActivityDto;
import com.wzq.labsystem.service.UserActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags ={"2-4 成员管理"})
public class UserActivitityController {
    @Autowired
    private UserActivityService userActivityService;

    @ApiOperation("通过学生查询老师列表")
    @GetMapping("selectTeacherByStudentId")
    public ResultDto<PageDto<UserActivityDto>> selectTeacherByStudentId(@RequestParam(value ="studentId",required = false) Long studentId,
                                                                        @RequestParam(value ="studentName",required = false) String studentName,
                                                                        @RequestParam Integer pageNo,
                                                                        @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectTeacherByStudentId(studentId,studentName, pageNo, pageSize));
    }

    @ApiOperation("通过老师查询学生列表")
    @GetMapping("selectStudentByTeacherId")
    public ResultDto<PageDto<UserActivityDto>> selectStudentByTeacherId(@RequestParam(value ="teacherUserId",required = false) Long teacherUserId,
                                                                        @RequestParam(value ="teacherName",required = false) String teacherName,
                                                                        @RequestParam Integer pageNo,
                                                                        @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectStudentByTeacherId(teacherUserId,teacherName, pageNo, pageSize));
    }

    @ApiOperation("将学生加入到某位老师的学生列表")
    @GetMapping("insertStudentToTeacher")
    public ResultDto<Integer> insertStudentToTeacher(@RequestParam Long studentId,@RequestParam Long teacherId){
        return ResultDto.ok(userActivityService.insertStudentToTeacher(studentId,teacherId));
    }

    @ApiOperation("将学生加入到某位老师的学生列表")
    @GetMapping("insertStudentToCourse")
    public ResultDto<Integer> insertStudentToCourse(@RequestParam Long studentId,
                                                    @RequestParam Long teacherId,
                                                    @RequestParam Long courseId){
        return ResultDto.ok(userActivityService.insertStudentToCourse(studentId,teacherId,courseId));
    }

    @ApiOperation("查询某课程的学生列表")
    @GetMapping("selectStudentByCourseId")
    public ResultDto<PageDto<UserActivityDto>> selectStudentByCourseId(@RequestParam(value ="courseId",required = false) Long courseId,
                                                                      @RequestParam(value ="courseName",required = false) String courseName,
                                                                      @RequestParam Integer pageNo,
                                                                      @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectStudentByCourseId(courseId,courseName,pageNo,pageSize));
    }


    @ApiOperation("根据条件获取课程列表")
    @GetMapping("selectCourseAllBy")
    public ResultDto<PageDto<UserActivityDto>> selectCourseAllBy(@RequestParam(value ="studentId",required = false) Long studentId,
                                                                 @RequestParam(value ="studentName",required = false) String studentName,
                                                                 @RequestParam(value ="teacherUserId",required = false) Long teacherUserId,
                                                                 @RequestParam(value ="teacherName",required = false) String teacherName,
                                                                 @RequestParam Integer pageNo,
                                                                 @RequestParam Integer pageSize){
        return ResultDto.ok(userActivityService.selectCourseAllBy(studentId, studentName,teacherUserId,teacherName,pageNo,pageSize));
    }


}
