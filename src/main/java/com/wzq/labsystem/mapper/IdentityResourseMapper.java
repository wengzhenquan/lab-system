package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.IdentityResourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentityResourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IdentityResourse record);

    IdentityResourse selectByPrimaryKey(Long id);

    List<IdentityResourse> selectAll();

    int updateByPrimaryKey(IdentityResourse record);
}