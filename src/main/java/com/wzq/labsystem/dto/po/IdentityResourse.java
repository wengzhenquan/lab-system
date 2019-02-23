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
@ApiModel("身份资源关系")
public class IdentityResourse implements Serializable {

    private static final long serialVersionUID = -1238844393058986518L;

    private Long id;

    @ApiModelProperty("身份ID")
    private Long identityId;

    @ApiModelProperty("资源ID")
    private Long resourseId;


}