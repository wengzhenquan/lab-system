package com.wzq.labsystem.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL) // 结果忽略未null的字段
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("成绩")
public class AchieveDto implements Serializable {
    private static final long serialVersionUID = 1948031143212988994L;

    @ApiModelProperty("课程ID")
    private Long courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("科任教师ID")
    private Long teacherUserId;

    @ApiModelProperty("科任教师")
    private String teacherName;

    @ApiModelProperty("学生ID")
    private Long studentId;

    @ApiModelProperty("学生姓名")
    private String studentName;

    @ApiModelProperty("总学分")
    private Integer totalScore;

    @ApiModelProperty("获得成绩（学分）")
    private Double achieve;


}
