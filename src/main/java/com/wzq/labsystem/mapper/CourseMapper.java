package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.CourseDto;
import com.wzq.labsystem.dto.po.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    CourseDto selectByPrimaryKey(Long id);

    List<CourseDto> selectAll(@Param("teacherUserId") Long teacherUserId,
                              @Param("teacherName") String teacherName,
                              @Param("courseName") String courseName,
                              @Param("pageNo") Integer pageNo,
                              @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("teacherUserId") Long teacherUserId,
                     @Param("teacherName") String teacherName,
                     @Param("courseName") String courseName);

    int updateByPrimaryKey(Course record);

    int deleteStudent(Long courseId);

    int deleteExpReport(Long courseId);

    int deleteExpTesk(Long courseId);
}