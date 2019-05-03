package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.CourseDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.po.Course;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.CourseMapper;
import com.wzq.labsystem.mapper.ExpReportMapper;
import com.wzq.labsystem.mapper.ExpTeskMapper;
import com.wzq.labsystem.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private ExpReportMapper expReportMapper;

    @Autowired
    private ExpTeskMapper expTeskMapper;


    /**
     * 获取课程列表
     * @return
     */
    public PageDto<CourseDto> selectCourseAll(Long teacherUserId,String teacherName,
                                              String courseName,Integer pageNo,Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<CourseDto> courseDtoList = courseMapper.selectAll(teacherUserId,teacherName,courseName, pageNo, pageSize);
        Long count = courseMapper.selectCount(teacherUserId,teacherName,courseName);
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
     * 修改课程信息
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

    /**
     * 获取课程信息数量（用于删除前确认）
     * @param courseId
     * @return
     */
    public Map<String,Long> getCourseInfoCount(Long courseId){
        Long studentCount = userActivityMapper.selectCount(null, null, null, null, courseId, null);
        Long expTeskCount = expTeskMapper.selectCount(courseId,null,null,null);
        Long expReportCount = expReportMapper.selectCount(null, null,null,null, courseId, null);
        Map<String, Long> map = new  HashMap<>();
        map.put("studentCount", studentCount);
        map.put("expTeskCount", expTeskCount);
        map.put("expReportCount", expReportCount);
        return map;
    }

    /**
     * 删除课程（确认删除）
     * @param courseId
     * @return
     */
    @Transactional
    public Integer deleteCourse(Long courseId){
        courseMapper.deleteStudent(courseId);
        courseMapper.deleteExpReport(courseId);
        courseMapper.deleteExpTesk(courseId);
        int result = courseMapper.deleteByPrimaryKey(courseId);
        if(0 == result) throw new ServiceException(501, "删除失败");
        return result;
    }
}
