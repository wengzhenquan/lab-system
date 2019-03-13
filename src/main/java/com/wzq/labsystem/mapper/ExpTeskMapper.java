package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.ExpTeskDto;
import com.wzq.labsystem.dto.po.ExpTesk;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpTeskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExpTesk record);

    ExpTeskDto selectByPrimaryKey(Long id);

    List<ExpTeskDto> selectAll(@Param("courseId") Long courseId,
                               @Param("courseName") String courseName,
                               @Param("romId") Long romId,
                               @Param("romName") String romName,
                               @Param("pageNo") Integer pageNo,
                               @Param("pageSize")Integer pageSize);

    Long selectCount(@Param("courseId") Long courseId,
                @Param("courseName") String courseName,
                @Param("romId") Long romId,
                @Param("romName") String romName);

    int updateByPrimaryKey(ExpTesk record);
}