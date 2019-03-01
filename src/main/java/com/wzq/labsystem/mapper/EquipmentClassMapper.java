package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.EquipmentClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EquipmentClass record);

    EquipmentClass selectByPrimaryKey(Long id);

    List<EquipmentClass> selectAll(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(EquipmentClass record);

    Long selectCount();
}