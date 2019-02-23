package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.EquipmentLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EquipmentLog record);

    EquipmentLog selectByPrimaryKey(Long id);

    List<EquipmentLog> selectAll();

    int updateByPrimaryKey(EquipmentLog record);
}