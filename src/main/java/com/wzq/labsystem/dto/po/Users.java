package com.wzq.labsystem.dto.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户")
public class Users implements Serializable {

    private static final long serialVersionUID = 5358930054426950490L;

    private Long id;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职务")
    private String job;


}