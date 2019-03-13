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
@ApiModel("课程表")
public class CourseDto implements Serializable {

    private static final long serialVersionUID = -6071617456095654019L;

    private Long id;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("科任教师ID")
    private Long teacherUserId;

    @ApiModelProperty("科任教师")
    private String name;

    @ApiModelProperty("总学分")
    private Integer totalScore;

    @ApiModelProperty("开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Instant startDate;

    @ApiModelProperty("结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Instant endDate;

}