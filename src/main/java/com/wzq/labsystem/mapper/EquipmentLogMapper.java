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

    int updateByPrimaryKey(EquipmentLog record);

    List<EquipmentLogDto> selectAll(@Param("userId") Long userId,
                                    @Param("applyName") String applyName,
                                    @Param("handleUserId") Long handleUserId,
                                    @Param("handleUserName") String handleUserName,
                                    @Param("eqClassId") Long eqClassId,
                                    @Param("typeName") String typeName,
                                    @Param("state") Integer state,
                                    @Param("pageNo") Integer pageNo,
                                    @Param("pageSize") Integer pageSize);

    Long selectCount(@Param("userId") Long userId,
                     @Param("applyName") String applyName,
                     @Param("handleUserId") Long handleUserId,
                     @Param("handleUserName") String handleUserName,
                     @Param("eqClassId") Long eqClassId,
                     @Param("typeName") String typeName,
                     @Param("state") Integer state);
}