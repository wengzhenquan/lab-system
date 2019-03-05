package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.EquipmentLogDto;
import com.wzq.labsystem.dto.po.EquipmentLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EquipmentLog record);

    EquipmentLogDto selectByPrimaryKey(Long id);

    List<EquipmentLogDto> selectAll(@Param("equipmentLog") EquipmentLog equipmentLog,@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(EquipmentLog record);

    Long selectCount(@Param("equipmentLog") EquipmentLog equipmentLog);
}