package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.ExpReportDto;
import com.wzq.labsystem.dto.po.ExpReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpReportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExpReport record);

    ExpReportDto selectByPrimaryKey(Long id);

    List<ExpReportDto> selectAll(@Param("teskId") Long teskId,
                                 @Param("title") String title,
                                 @Param("studentUserId") Long studentUserId,
                                 @Param("name") String name,
                                 @Param("pageNo") Integer pageNo,
                                 @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("teskId") Long teskId,
                     @Param("title") String title,
                     @Param("studentUserId") Long studentUserId,
                     @Param("name") String name);

    int updateByPrimaryKey(ExpReport record);
}