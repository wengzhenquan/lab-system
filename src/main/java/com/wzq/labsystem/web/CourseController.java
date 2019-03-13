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

@RestController
@Api(tags ={"2-1 课程管理"})
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation("获取课程列表")
    @GetMapping("selectCourseAll")
    public ResultDto<PageDto<CourseDto>> selectCourseAll(@RequestParam(value ="teacherUserId",required = false) Long teacherUserId,
                                                         @RequestParam Integer pageNo,
                                                         @RequestParam Integer pageSize){
        return ResultDto.ok(courseService.selectCourseAll(teacherUserId, pageNo, pageSize));
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

}
