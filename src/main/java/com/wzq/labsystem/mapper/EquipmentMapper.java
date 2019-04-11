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


    int updateByPrimaryKey(Equipment record);

    List<EquipmentDto> selectAll(@Param("romId") Long romId,
                                 @Param("romNumb") Integer romNumb,
                                 @Param("romName") String romName,
                                 @Param("serNumb") String equipmentSerNumb,
                                 @Param("eqClassId") Long eqClassId,
                                 @Param("typeName") String typeName,
                                 @Param("state") Integer state,
                                 @Param("pageNo") Integer pageNo,
                                 @Param("pageSize") Integer pageSize);


    Long selectCount(@Param("romId") Long romId,
                     @Param("romNumb") Integer romNumb,
                     @Param("romName") String romName,
                     @Param("serNumb") String EquipmentSerNumb,
                     @Param("eqClassId") Long eqClassId,
                     @Param("typeName") String typeName,
                     @Param("state") Integer state);

    /**
     * 查看已分配设备
     * @return
     */
    List<EquipmentDto> selectAllocated(@Param("romNumb") Integer romNumb,
                                 @Param("romName") String romName,
                                 @Param("serNumb") String EquipmentSerNumb,
                                 @Param("eqClassId") Long eqClassId,
                                 @Param("typeName") String typeName,
                                 @Param("state") Integer state,
                                 @Param("pageNo") Integer pageNo,
                                 @Param("pageSize") Integer pageSize);

    Long selectCountAllocated(@Param("romNumb") Integer romNumb,
                     @Param("romName") String romName,
                     @Param("serNumb") String EquipmentSerNumb,
                     @Param("eqClassId") Long eqClassId,
                     @Param("typeName") String typeName,
                     @Param("state") Integer state);


    /**
     * 查看未分配设备
     * @return
     */
    List<EquipmentDto> selectUnallocated(@Param("serNumb") String EquipmentSerNumb,
                                       @Param("eqClassId") Long eqClassId,
                                       @Param("typeName") String typeName,
                                       @Param("state") Integer state,
                                       @Param("pageNo") Integer pageNo,
                                       @Param("pageSize") Integer pageSize);

    Long selectCountUnallocated(@Param("serNumb") String EquipmentSerNumb,
                              @Param("eqClassId") Long eqClassId,
                              @Param("typeName") String typeName,
                              @Param("state") Integer state);
}