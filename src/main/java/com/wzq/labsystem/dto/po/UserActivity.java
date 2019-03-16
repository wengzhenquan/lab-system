package com.wzq.labsystem.dto.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户活动表")
public class UserActivity implements Serializable {

    private static final long serialVersionUID = 6799635154783554229L;


    private Long id;

    @ApiModelProperty("学生ID")
    private Long studentId;

    @ApiModelProperty("教师ID")
    private Long teacherUserId;

    @ApiModelProperty("课程ID")
    private Long courseId;



}