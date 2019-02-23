package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.RomsLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RomsLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RomsLog record);

    RomsLog selectByPrimaryKey(Long id);

    List<RomsLog> selectAll();

    int updateByPrimaryKey(RomsLog record);
}