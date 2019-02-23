package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.UserDto;
import com.wzq.labsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags ={"1-账户管理"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public ResultDto<UserDto> longin(@RequestParam String userName,@RequestParam String pwd){
        ResultDto<UserDto> ok = ResultDto.ok(userService.login(userName, pwd));
        return ok;
    }
}
