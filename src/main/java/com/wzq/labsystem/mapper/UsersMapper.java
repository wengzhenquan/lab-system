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

    UserDto selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Users record);

    /**
     * 查询用户列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserDto> selectAll(@Param("identityId") Long identityId,
                            @Param("identityName") String identityName,
                            @Param("userName") String userName,
                            @Param("name") String name,
                            @Param("pageNo") Integer pageNo,
                            @Param("pageSize")Integer pageSize);

    /**
     * 查询总数
     * @return
     */
    Long selectCount(@Param("identityId") Long identityId,
                     @Param("identityName") String identityName,
                     @Param("userName") String userName,
                     @Param("name") String name);

    /**
     * 通过账号密码查询
     *
     * @param userName
     * @param pwd
     * @return
     */
    UserDto selectByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd,@Param("level") Integer level);

    /**
     * 修改密码
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int updatePwd(@Param("userName") String userName, @Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd);

}