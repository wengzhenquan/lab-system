package com.wzq.labsystem.mapper;

import com.wzq.labsystem.dto.UserDto;
import com.wzq.labsystem.dto.po.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);


    /**
     * 通过账号密码查询
     *
     * @param userName
     * @param pwd
     * @return
     */
    UserDto selectByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);

    /**
     * 修改密码
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int updatePwd(@Param("userName") String userName, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);

}