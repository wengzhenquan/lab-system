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
@ApiModel("课程表")
public class Course implements Serializable {

    private static final long serialVersionUID = -2769141020738174818L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("科任教师ID")
    private Long teacherUserId;

    @ApiModelProperty("总学分")
    private Integer totalScore;

    @ApiModelProperty("开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant startDate;

    @ApiModelProperty("结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant endDate;

}