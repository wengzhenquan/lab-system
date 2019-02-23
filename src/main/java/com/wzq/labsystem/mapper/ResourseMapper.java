package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.Resourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resourse record);

    Resourse selectByPrimaryKey(Long id);

    List<Resourse> selectAll();

    int updateByPrimaryKey(Resourse record);
}