package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.ExpReportDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.po.ExpReport;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.ExpReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ExpReportService {

    @Autowired
    private ExpReportMapper expReportMapper;

    /**
     * 获取实验报告列表
     * @return
     */
    public PageDto<ExpReportDto> selectExpReportAll(Long teskId, String title, Long studentUserId, String name,Long courseId, String courseName, Integer pageNo, Integer pageSize){
        List<ExpReportDto> expReportDtoList = expReportMapper.selectAll(teskId,title,studentUserId,name,courseId,courseName, pageNo, pageSize);
        Long count = expReportMapper.selectCount(teskId,title,studentUserId,name,courseId,courseName);
        PageDto<ExpReportDto> page = new PageDto<>();
        page.setData(expReportDtoList);
        page.setTotal(count);
        return page;
    }

    /**
     * 添加实验报告
     * @param expReport
     * @return
     */
    public Integer insertExpReport(ExpReport expReport){
        Assert.notNull(expReport.getTeskId(), "所属实验任务不能为空！");
        Assert.notNull(expReport.getStudentUserId(), "提交报告的学生不能为空！");
        expReport.setUpdateTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = expReportMapper.insert(expReport);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改实验任务
     * @param expReport
     * @return
     */
    public Integer updateExpReport(ExpReport expReport){
        Assert.notNull(expReport.getTeskId(), "所属实验任务不能为空！");
        Assert.notNull(expReport.getStudentUserId(), "提交报告的学生不能为空！");
        expReport.setUpdateTime(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
        int result = expReportMapper.updateByPrimaryKey(expReport);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 通过ID查询
     * @param expReportId
     * @return
     */
    public ExpReportDto selectExpReportById(Long expReportId){
        return expReportMapper.selectByPrimaryKey(expReportId);
    }

}
