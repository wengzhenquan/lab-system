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
@ApiModel("实验任务表")
public class ExpTesk implements Serializable {

    private static final long serialVersionUID = -8351265412813221375L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("课程ID")
    private Long courseId;

    @ApiModelProperty("实验教室ID")
    private Long romId;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant startTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonSerialize(using = InstantJacksonSerializer.class)
    @JsonDeserialize(using = InstantJacksonDeserialize.class)
    private Instant endTime;

    @ApiModelProperty("课件")
    private String fileUrl;


}