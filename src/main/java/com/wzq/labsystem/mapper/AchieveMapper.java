package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.AchieveDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchieveMapper {

    /**
     * 修改成绩
     * @return
     */
    int updateAchieveBy(@Param("achieve")Double achieve,@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("teacherId") Long teacherId);


    /**
     * 老师查看某课程学生成绩列表
     * @param courseId
     * @param teacherUserId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<AchieveDto> selectAchieveAllByTeacherId(@Param("courseId") Long courseId,
                                                 @Param("teacherUserId") Long teacherUserId,
                                                 @Param("pageNo") Integer pageNo,
                                                 @Param("pageSize") Integer pageSize);

    /**
     * 查询老师查看某课程学生成绩列表总数
     * @param courseId
     * @param teacherUserId
     * @return
     */
    Long selectAchieveCountByTeacherId(@Param("courseId") Long courseId,@Param("teacherUserId") Long teacherUserId);


    /**
     * 学生查看课程成绩列表
     * @param studentId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<AchieveDto> selectAchieveAllByStudentId(@Param("studentId") Long studentId,
                                                 @Param("pageNo") Integer pageNo,
                                                 @Param("pageSize") Integer pageSize);

    /**
     * 查询学生查看课程成绩列表总数
     * @param studentId
     * @return
     */
    Long selectAchieveCountByStudentId(@Param("studentId") Long studentId);



}