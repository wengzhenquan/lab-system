package com.wzq.labsystem.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("设备申请日志")
public class EquipmentLogDto implements Serializable {

    private static final long serialVersionUID = 3003332075218226479L;
    private Long id;

    @ApiModelProperty("申请人ID")
    private Long applyId;

    @ApiModelProperty("申请人姓名")
    private String userName;

    @ApiModelProperty("处理人ID")
    private Long handleUserId;

    @ApiModelProperty("处理人姓名")
    private String handleUserName;

    @ApiModelProperty("设备类别ID")
    private Long eqClassId;

    @ApiModelProperty("设备类别名称")
    private String typeName;

    @ApiModelProperty("类型(0报修,1采购)")
    private Integer type;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("需求描述")
    private String need;

    @ApiModelProperty("处理结果描述")
    private String result;

    @ApiModelProperty("状态(0申请中,1已审批,2已处理)")
    private Integer state;

    @ApiModelProperty("申请时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant creatTime;

    @ApiModelProperty("处理时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant handleTime;
}
