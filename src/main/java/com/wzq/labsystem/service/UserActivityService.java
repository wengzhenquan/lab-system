package com.wzq.labsystem.service;


import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.UserActivityDto;
import com.wzq.labsystem.dto.po.UserActivity;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserActivityService {
    @Autowired
    private UserActivityMapper userActivityMapper;


    /**
     * 将学生加入到某位老师的学生列表
     * @param studentId
     * @param teacherId
     * @return
     */
    public Integer insertStudentToTeacher(Long studentId,Long teacherId){
        Assert.notNull(studentId, "学生不能为空");
        Assert.notNull(teacherId, "教师不能为空");
        List<UserActivityDto> userActivityDtoList = userActivityMapper.selectAll(studentId, null, teacherId, null, 0L, null, null, null);
        if(0 != userActivityDtoList.size())
            throw new ServiceException(501, "该学生已经是该老师的学生");
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .studentId(studentId)
                .teacherUserId(teacherId).build());
        if(0 == result)
            throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 将学生加入到某课程
     * @param studentId
     * @param teacherId
     * @return
     */
    public Integer insertStudentToCourse(Long studentId,Long teacherId,Long courseId){
        Assert.notNull(studentId, "学生不能为空");
        Assert.notNull(teacherId, "教师不能为空");
        Assert.notNull(courseId, "课程不能为空");
        List<UserActivityDto> userActivityDtoList = userActivityMapper.selectAll(studentId, null, teacherId, null, courseId, null, null, null);
        if(0 != userActivityDtoList.size())
            throw new ServiceException(501, "该学生已经加入该课程");
        Integer result = userActivityMapper.insert(UserActivity.builder()
                .studentId(studentId)
                .teacherUserId(teacherId)
                .courseId(courseId).build());
        if(0 == result)
            throw new ServiceException(501, "添加失败");
        return result;
    }




    /**
     * 获取某老师所有的学生列表
     * @return
     */
    public PageDto<UserActivityDto> selectStudentAllByteacherUserId(Long teacherUserId,String teacherName, Integer pageNo, Integer pageSize){
        List<UserActivityDto> courseDtoList = userActivityMapper.selectAll(null, null, teacherUserId, teacherName, 0L, null, pageNo, pageSize);
        Long count = userActivityMapper.selectCount(null, null, teacherUserId, teacherName, 0L, null);
        PageDto<UserActivityDto> page = new PageDto<>();
        page.setData(courseDtoList);
        page.setTotal(count);
        return page;
    }

    /**
     * 根据条件获取课程列表
     * @return
     */
    public PageDto<UserActivityDto> selectCourseAllBy(Long studentId,String studentName,Long teacherUserId,String teacherName, Integer pageNo, Integer pageSize){
        List<UserActivityDto> courseDtoList = userActivityMapper.selectCourseAllBy(studentId, studentName, teacherUserId, teacherName, pageNo, pageSize);
        Long count = userActivityMapper.selectCourseCount(studentId, studentName, teacherUserId, teacherName);
        PageDto<UserActivityDto> page = new PageDto<>();
        page.setData(courseDtoList);
        page.setTotal(count);
        return page;
    }





}
