package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Equipment record);

    Equipment selectByPrimaryKey(Long id);

    List<Equipment> selectAll();

    int updateByPrimaryKey(Equipment record);
}