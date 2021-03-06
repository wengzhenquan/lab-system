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
@ApiModel("实验任务表")
public class ExpTeskDto implements Serializable {

    private static final long serialVersionUID = 6839977456371886975L;

    private Long id;

    @ApiModelProperty("课程ID")
    private Long courseId;

    @ApiModelProperty("课程ID")
    private String courseName;

    @ApiModelProperty("实验教室ID")
    private Long romId;

    @ApiModelProperty("教室编号")
    private Integer numb;

    @ApiModelProperty("名称")
    private String romName;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant startTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Instant endTime;

    @ApiModelProperty("课件")
    private String fileUrl;


}