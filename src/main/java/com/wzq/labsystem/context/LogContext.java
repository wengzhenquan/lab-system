package com.wzq.labsystem.context;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class LogContext {
	private String reqId;
	private String remoteIp;
	private String appKey;
	private Long userId;
	private String userName;
	private String reqUri;
}
