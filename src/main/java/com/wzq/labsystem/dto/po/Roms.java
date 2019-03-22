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
@ApiModel("教室")
public class Roms implements Serializable {

    private static final long serialVersionUID = 6438034077771523927L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("教室编号")
    private Integer numb;

    @ApiModelProperty("名称")
    private String romName;

    @ApiModelProperty("负责人ID")
    private Long userId;

    @ApiModelProperty("教室描述")
    private String content;

    @ApiModelProperty("状态(0空闲,1使用中)")
    private Integer state;


}