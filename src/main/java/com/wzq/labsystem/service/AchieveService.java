package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.AchieveDto;
import com.wzq.labsystem.dto.ExpReportDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.UserActivityDto;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.AchieveMapper;
import com.wzq.labsystem.mapper.CourseMapper;
import com.wzq.labsystem.mapper.ExpReportMapper;
import com.wzq.labsystem.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AchieveService {

    @Autowired
    private AchieveMapper achieveMapper;

    @Autowired
    private ExpReportMapper expReportMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserActivityMapper userActivityMapper;
    /**
     * 老师查看某课程学生成绩列表
     * @param courseId
     * @param teacherUserId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<AchieveDto> selectAchieveAllByTeacherId(Long courseId,Long teacherUserId,Integer pageNo,Integer pageSize){
        List<AchieveDto> achieveDtoList = achieveMapper.selectAchieveAllByTeacherId(courseId, teacherUserId, pageNo, pageSize);
        Long count = achieveMapper.selectAchieveCountByTeacherId(courseId, teacherUserId);
        PageDto<AchieveDto> pageDto = new PageDto<>();
        pageDto.setData(achieveDtoList);
        pageDto.setTotal(count);
        return pageDto;
    }

    /**
     * 学生查看课程成绩列表
     * @param studentId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageDto<AchieveDto> selectAchieveAllByStudentId(Long studentId,Integer pageNo,Integer pageSize){
        List<AchieveDto> achieveDtoList = achieveMapper.selectAchieveAllByStudentId(studentId, pageNo, pageSize);
        Long count = achieveMapper.selectAchieveCountByStudentId(studentId);
        PageDto<AchieveDto> pageDto = new PageDto<>();
        pageDto.setData(achieveDtoList);
        pageDto.setTotal(count);
        return pageDto;
    }


    /**
     * 修改成绩
     * @param achieve
     * @param courseId
     * @param studentId
     * @param teacherId
     * @return
     */
    @Transactional
    public Integer updateAchieveBy(Double achieve,Long courseId,Long studentId, Long teacherId){
        Assert.notNull(achieve,"成绩不能为空");
        Assert.notNull(courseId,"待修改的课程不能为空");
        Assert.notNull(studentId,"学生不能为空");
        Assert.notNull(teacherId,"老师不能为空");
        int result = achieveMapper.updateAchieveBy(achieve, courseId, studentId, teacherId);
        if(1 != result) throw new ServiceException(501, "成绩修改失败！");
        return result;
    }

    /**
     * 自动计算并修改某位学生成绩
     * @param courseId
     * @param studentId
     * @param teacherId
     * @return
     */
    public Integer autoAchieveOnStudent(Long courseId,Long studentId, Long teacherId){
        Assert.notNull(courseId,"待修改的课程不能为空");
        Assert.notNull(studentId,"学生不能为空");
        Assert.notNull(teacherId,"老师不能为空");
        List<ExpReportDto> expReportDtoList = expReportMapper.selectAll(null, null, studentId, null, courseId, null, null, null);

        Integer sum = expReportDtoList.stream().map(ExpReportDto::getScore).reduce(0, Integer::sum);
        Double rate = ((double) sum) / (expReportDtoList.size() * 100);
        Integer totalScore = courseMapper.selectByPrimaryKey(courseId).getTotalScore();
        Double achieve = new BigDecimal(rate * totalScore).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        int result = achieveMapper.updateAchieveBy(achieve, courseId, studentId, teacherId);
        if(1 != result) throw new ServiceException(501, "成绩修改失败！");
        return result;
    }

    /**
     * 批量自动计算某课程所有学生的成绩
     * @param courseId
     * @param teacherId
     * @return
     */
    public String autoAchieveOnCourse(Long courseId, Long teacherId){
        List<UserActivityDto> userActivityDtoList = userActivityMapper
                .selectAll(null, null, teacherId, null, courseId, null, null, null);
        Runnable run = () ->userActivityDtoList
                                .stream()
                                .parallel()
                                .forEach(UserActivityDto ->
                                        autoAchieveOnStudent(courseId, UserActivityDto.getStudentId(), teacherId)
                                );
        new Thread(run).start();
        return "正在后台计算成绩，请稍后刷新页面查看结果";
    }

}
