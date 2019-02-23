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
@ApiModel("资源")
public class Resourse implements Serializable {

    private static final long serialVersionUID = 6662181217335049386L;

    private Long id;

    @ApiModelProperty("资源名称")
    private String resourseName;

    @ApiModelProperty("父ID")
    private Long fatherId;

    @ApiModelProperty("URL")
    private String url;

    @ApiModelProperty("目录等级(0一级,1二级,2三级)")
    private Integer level;

    @ApiModelProperty("类型(0目录,1按钮)")
    private Integer type;


}