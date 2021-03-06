package com.wzq.labsystem.web;


import com.wzq.labsystem.dto.CourseDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.po.Course;
import com.wzq.labsystem.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags ={"2-1 课程管理"})
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation("获取课程列表")
    @GetMapping("selectCourseAll")
    public ResultDto<PageDto<CourseDto>> selectCourseAll(@RequestParam(value ="teacherUserId",required = false) Long teacherUserId,
                                                         @RequestParam(value ="teacherName",required = false) String teacherName,
                                                         @RequestParam(value ="studentId",required = false) Long studentId,
                                                         @RequestParam(value ="studentName",required = false) String studentName,
                                                         @RequestParam(value ="courseName",required = false) String courseName,
                                                         @RequestParam Integer pageNo,
                                                         @RequestParam Integer pageSize){
        return ResultDto.ok(courseService.selectCourseAll(teacherUserId,teacherName,studentId,studentName,courseName, pageNo, pageSize));
    }

    @ApiOperation("添加课程")
    @PostMapping("insertCourse")
    public ResultDto<Integer> insertCourse(@RequestBody Course course){
        return ResultDto.ok(courseService.insertCourse(course));
    }

    @ApiOperation("修改课程信息")
    @PostMapping("updateCourse")
    public ResultDto<Integer> updateCourse(@RequestBody Course course){
        return ResultDto.ok(courseService.updateCourse(course));
    }

    @ApiOperation("通过Id查询课程信息")
    @GetMapping("selectCourseById")
    public ResultDto<CourseDto> selectCourseById(@RequestParam Long courseId){
        return ResultDto.ok(courseService.selectCourseById(courseId));
    }

    @ApiOperation("获取课程信息数量（用于删除前确认）")
    @GetMapping("getCourseInfoCount")
    public ResultDto<Map<String,Long>> getCourseInfoCount(@RequestParam Long courseId){
        return ResultDto.ok(courseService.getCourseInfoCount(courseId));
    }

    @ApiOperation("删除课程（确认删除）")
    @GetMapping("deleteCourse")
    public ResultDto<Integer> deleteCourse(@RequestParam Long courseId){
        return ResultDto.ok(courseService.deleteCourse(courseId));
    }

}
