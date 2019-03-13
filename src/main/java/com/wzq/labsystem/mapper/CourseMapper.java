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

    List<CourseDto> selectAll(@Param("teacherUserId") Long teacherUserId,@Param("pageNo") Integer pageNo, @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("teacherUserId") Long teacherUserId);

    int updateByPrimaryKey(Course record);
}