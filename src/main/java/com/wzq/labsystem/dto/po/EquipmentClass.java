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
@ApiModel("设备分类")
public class EquipmentClass implements Serializable {

    private static final long serialVersionUID = 7358552260515632914L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("类别名")
    private String typeName;

}