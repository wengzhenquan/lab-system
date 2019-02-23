package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.UserDto;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UsersMapper userMapper;

    /**
     * 登录
     * @param userName
     * @param pwd
     * @return
     */
   public UserDto login(String userName, String pwd){
       Assert.isNull(userName, "用户名不能为空");
       Assert.isNull(pwd, "密码不能为空");
       UserDto userDto = userMapper.selectByUserNameAndPwd(userName, pwd);
       if(null == userDto) throw new ServiceException(501, "账号或密码错误");
       return userDto;
   }

    /**
     * 修改密码
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    public String updatePwd(String userName, String oldPwd, String newPwd) {
        Assert.isNull(userName, "用户名不能为空");
        Assert.isTrue("admin".equals(userName), "admin账号不允许修改密码");
        Assert.isNull(oldPwd,"旧密码不能为空");
        Assert.isNull(newPwd,"新密码不能为空");
        int result = userMapper.updatePwd(userName, oldPwd, newPwd);
        if (1 != result) throw new ServiceException(501, "账号或密码错误");
        return "修改成功";
    }
}
