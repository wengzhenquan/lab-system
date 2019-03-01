package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.EquipmentDto;
import com.wzq.labsystem.dto.po.Equipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Equipment record);

    EquipmentDto selectByPrimaryKey(Long id);


    List<EquipmentDto> selectAll(@Param("equipment") Equipment equipment, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(Equipment record);


    Long selectCount(@Param("equipment") Equipment equipment);
}