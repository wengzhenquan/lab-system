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

    private Long id;

    @ApiModelProperty("教室编号")
    private Integer numb;

    @ApiModelProperty("类型（0办公室，1教室，2其它）")
    private Integer type;

    @ApiModelProperty("负责人ID")
    private Long personLiableId;

    @ApiModelProperty("教室描述")
    private String content;

    @ApiModelProperty("状态(0空闲,1使用中)")
    private Integer state;


}