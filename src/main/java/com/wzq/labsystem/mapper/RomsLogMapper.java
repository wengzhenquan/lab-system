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
    List<RomsLogDto> selectAll(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);

    Long selectCount();

    int updateByPrimaryKey(RomsLog record);

    /**
     * 查询某用户所有申请
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<RomsLogDto> selectAllByUserId(@Param("userId") Long userId, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    /**
     * 查询某用户的申请总数
     * @param userId
     * @return
     */
    Long selectCountByUserId(Long userId);


    /**
     * 查询某教室申请记录
     * @param romId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<RomsLogDto> selectAllByRomId(@Param("userId") Long romId,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);

    /**
     * 查询某教室的申请总数
     * @param romId
     * @return
     */
    Long selectCountByRomId(Long romId);
}