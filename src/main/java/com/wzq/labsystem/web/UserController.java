package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.PageDto;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.dto.UserDto;
import com.wzq.labsystem.dto.po.Users;
import com.wzq.labsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ={"1-1 账户管理"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public ResultDto<UserDto> longin(@RequestParam String userName,@RequestParam String pwd,@RequestParam Integer level){
        return ResultDto.ok(userService.login(userName, pwd,level));
    }

    @ApiOperation("修改密码")
    @PostMapping("updatePwd")
    public ResultDto<Integer> updatePwd(@RequestParam String userName,@RequestParam String oldPwd,@RequestParam String newPwd){
        return ResultDto.ok(userService.updatePwd(userName, oldPwd, newPwd));
    }

    @ApiOperation("添加新账户")
    @PostMapping("insertUser")
    public ResultDto<Integer> insertUser(@RequestBody Users users){
        return ResultDto.ok(userService.insertUser(users));
    }

    @ApiOperation("修改账户信息(不能改密码)")
    @PostMapping("updateUser")
    public ResultDto<Integer> updateUser(@RequestBody Users users){
        return ResultDto.ok(userService.updateUser(users));
    }

    @ApiOperation("查询所有用户列表")
    @GetMapping("selectUsersAll")
    public ResultDto<PageDto<UserDto>> selectUsersAll(@RequestParam(value ="identityId",required = false) Long identityId,
                                                      @RequestParam(value ="identityName",required = false) String identityName,
                                                      @RequestParam(value ="userName",required = false) String userName,
                                                      @RequestParam(value ="name",required = false) String name,
                                                      @RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize){
        return ResultDto.ok(userService.selectUsersAll(identityId,identityName,userName,name,pageNo, pageSize));
    }

    @ApiOperation("查询用户信息")
    @GetMapping("selectByUserId")
    public ResultDto<UserDto> selectByUserId(@RequestParam Long UserId){
        return ResultDto.ok(userService.selectByUserId(UserId));
    }

    @ApiOperation("删除账户")
    @GetMapping("deleteUser")
    public ResultDto<Integer> deleteUser(@RequestParam Long UserId){
        return ResultDto.ok(userService.deleteUser(UserId));
    }

}
