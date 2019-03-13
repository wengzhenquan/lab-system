package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.RomsLogDto;
import com.wzq.labsystem.dto.po.RomsLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RomsLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RomsLog record);

    RomsLog selectByPrimaryKey(Long id);

    /**
     * 查询所有申请列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<RomsLogDto> selectAll(@Param("userId")Long userId,
                               @Param("handleUserId")Long handleUserId,
                               @Param("romId")Long romId,
                               @Param("state")Integer state,
                               @Param("pageNo") Integer pageNo,
                               @Param("pageSize") Integer pageSize);

    Long selectCount(@Param("userId")Long userId,
                     @Param("handleUserId")Long handleUserId,
                     @Param("romId")Long romId,
                     @Param("state")Integer state);

    int updateByPrimaryKey(RomsLog record);




    /**
     * 修改处理状态
     * @param romsLog
     * @return
     */
    int updateState(RomsLog romsLog);
}