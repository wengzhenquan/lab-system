package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.EquipmentClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EquipmentClass record);

    EquipmentClass selectByPrimaryKey(Long id);

    List<EquipmentClass> selectAll();

    int updateByPrimaryKey(EquipmentClass record);
}