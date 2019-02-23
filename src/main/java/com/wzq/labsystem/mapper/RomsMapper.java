package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.po.Roms;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RomsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Roms record);

    Roms selectByPrimaryKey(Long id);

    List<Roms> selectAll();

    int updateByPrimaryKey(Roms record);
}