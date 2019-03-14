package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.UserActivityDto;
import com.wzq.labsystem.dto.po.UserActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserActivity record);

    UserActivityDto selectByPrimaryKey(Long id);

    List<UserActivityDto> selectAll(@Param("studentId") Long studentId,
                                    @Param("studentName") String studentName,
                                    @Param("teacherUserId") Long teacherUserId,
                                    @Param("teacherName") String teacherName,
                                    @Param("courseId") Long courseId,
                                    @Param("courseName") String courseName,
                                    @Param("pageNo") Integer pageNo,
                                    @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("studentId") Long studentId,
                     @Param("studentName") String studentName,
                     @Param("teacherUserId") Long teacherUserId,
                     @Param("teacherName") String teacherName,
                     @Param("courseId") Long courseId,
                     @Param("courseName") String courseName);

    int updateByPrimaryKey(UserActivity record);
}