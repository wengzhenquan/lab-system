package com.wzq.labsystem.dto;

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
@ApiModel("实验报告表")
public class ExpReportDto implements Serializable {

    private static final long serialVersionUID = -7009521658700535260L;

    private Long id;

    @ApiModelProperty("任务ID")
    private Long teskId;

    @ApiModelProperty("任务标题")
    private String title;

    @ApiModelProperty("学生ID")
    private Long studentUserId;

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("学生附件")
    private String studentFileUrl;

    @ApiModelProperty("更新时间")
    private Instant updateTime;

    @ApiModelProperty("获得分数")
    private Integer score;


}