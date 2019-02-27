package com.wzq.labsystem.dto;

import lombok.*;

import java.util.List;

/**
 * created by hj on 2018-04-08
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageDto<T> {

	private List<T> data;

	private Long total;

}
