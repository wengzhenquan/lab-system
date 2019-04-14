package com.wzq.labsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("教室申请日志")
public class RomsLogDto {

    private Long id;

    @ApiModelProperty("申请人ID")
    private Long applyId;

    @ApiModelProperty("申请人")
    private String name;

    @ApiModelProperty("处理人ID")
    private Long handleUserId;

    @ApiModelProperty("处理人")
    private String handleUser;

    @ApiModelProperty("教室ID")
    private Long romId;

    @ApiModelProperty("教室编号")
    private Long romNumb;

    @ApiModelProperty("教室名称")
    private String romName;

    @ApiModelProperty("状态(0申请中,1已审批,2未通过审批)")
    private Integer state;

    @ApiModelProperty("申请时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant creatTime;

    @ApiModelProperty("处理时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant handleTime;

    @ApiModelProperty("申请开始使用时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant startTime;

    @ApiModelProperty("申请结束使用时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant endTime;
}
