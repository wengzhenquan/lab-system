package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.RomsDto;
import com.wzq.labsystem.dto.po.Roms;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RomsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Roms record);

    /**
     * 查询房间信息
     * @param romsId
     * @return
     */
    RomsDto selectByPrimaryKey(Long romsId);

    /**
     * 查询所有房间列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<RomsDto> selectAll(@Param("roms") Roms roms,@Param("pageNo") Integer pageNo , @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("roms") Roms roms);

    int updateByPrimaryKey(Roms record);

    /**
     * 修改教室状态
     * @param state
     * @param id
     * @return
     */
    int updateStateByPrimaryKey(@Param("state") Integer state, @Param("id") Long id);

    /**
     * 初始化教室状态
     * @return
     */
    int updateStateInitialize();
}