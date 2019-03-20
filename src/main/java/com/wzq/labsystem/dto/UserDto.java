package com.wzq.labsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ApiModel("用户实体")
public class UserDto implements Serializable {

    private static final long serialVersionUID = -3398677515477414502L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("身份")
    private String identityName;

    @ApiModelProperty("身份等级level")
    private Integer level;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    @JsonIgnore // 结果不显示该字段
    private String pwd;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("职务")
    private String job;
}
