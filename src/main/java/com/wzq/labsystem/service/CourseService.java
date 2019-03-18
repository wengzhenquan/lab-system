package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.CourseDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.po.Course;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.CourseMapper;
import com.wzq.labsystem.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;

    /**
     * 获取课程列表
     * @return
     */
    public PageDto<CourseDto> selectCourseAll(Long teacherUserId,Integer pageNo,Integer pageSize){
        List<CourseDto> courseDtoList = courseMapper.selectAll(teacherUserId, pageNo, pageSize);
        Long count = courseMapper.selectCount(teacherUserId);
        PageDto<CourseDto> page = new PageDto<>();
        page.setData(courseDtoList);
        page.setTotal(count);
        return page;
    }

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Transactional
    public Integer insertCourse(Course course){
        Assert.notNull(course.getCourseName(), "课程名称不能为空！");
        Assert.notNull(course.getTeacherUserId(), "老师不能为空！");
        Assert.notNull(course.getTotalScore(), "课程学分不能为空！");
        int result = courseMapper.insert(course);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改身份信息
     * @param course
     * @return
     */
    public Integer updateCourse(Course course){
        int result = courseMapper.updateByPrimaryKey(course);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 通过ID查询
     * @param courseId
     * @return
     */
    public CourseDto selectCourseById(Long courseId){
        return courseMapper.selectByPrimaryKey(courseId);
    }

}
