package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.ExpTeskDto;
import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.po.ExpTesk;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.ExpTeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ExpTeskService {

    @Autowired
    private ExpTeskMapper expTeskMapper;

    /**
     * 获取实验任务列表
     * @return
     */
    public PageDto<ExpTeskDto> selectExpTeskAll(Long courseId, String courseName, Long romId, String romName, Integer pageNo, Integer pageSize){
        pageNo = pageSize * (pageNo - 1);
        List<ExpTeskDto> expTeskDtoList = expTeskMapper.selectAll(courseId,courseName,romId,romName, pageNo, pageSize);
        Long count = expTeskMapper.selectCount(courseId,courseName,romId,romName);
        PageDto<ExpTeskDto> page = new PageDto<>();
        page.setData(expTeskDtoList);
        page.setTotal(count);
        return page;
    }

    /**
     * 添加实验任务
     * @param expTesk
     * @return
     */
    public Integer insertExpTesk(ExpTesk expTesk){
        Assert.notNull(expTesk.getCourseId(), "所属课程不能为空！");
        Assert.notNull(expTesk.getTitle(), "标题不能为空！");
        int result = expTeskMapper.insert(expTesk);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改实验任务
     * @param expTesk
     * @return
     */
    public Integer updateExpTesk(ExpTesk expTesk){
        int result = expTeskMapper.updateByPrimaryKey(expTesk);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 通过ID查询
     * @param expTeskId
     * @return
     */
    public ExpTeskDto selectExpTeskById(Long expTeskId){
        return expTeskMapper.selectByPrimaryKey(expTeskId);
    }
}
