package com.wzq.labsystem.dto.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wzq.labsystem.config.InstantJacksonDeserialize;
import com.wzq.labsystem.config.InstantJacksonSerializer;
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
public class ExpReport implements Serializable {

    private static final long serialVersionUID = -7009521658700535260L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("任务ID")
    private Long teskId;

    @ApiModelProperty("学生ID")
    private Long studentUserId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("学生附件")
    private String studentFileUrl;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant updateTime;

    @ApiModelProperty("获得分数")
    private Integer score;

}