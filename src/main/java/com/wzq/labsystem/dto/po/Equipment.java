package com.wzq.labsystem.dto.po;

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
@ApiModel("设备")
public class Equipment implements Serializable {

    private static final long serialVersionUID = -1494929659228491499L;

    private Long id;

    @ApiModelProperty("编号")
    private Long serNumb;

    @ApiModelProperty("教室ID")
    private Long romId;

    @ApiModelProperty("设备分类ID")
    private Long eqClassId;

    @ApiModelProperty("购买时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant buyTime;

    @ApiModelProperty("修理时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant repairTimes;

    @ApiModelProperty("信息最后更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant updateTime;

    @ApiModelProperty("状态(0正常,1报修,2报废)")
    private Integer state;


}