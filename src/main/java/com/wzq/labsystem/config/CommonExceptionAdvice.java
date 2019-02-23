package com.wzq.labsystem.config;


import com.wzq.labsystem.context.LogContext;
import com.wzq.labsystem.context.LogContextHolder;
import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author wengzhenquan
 *
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResultDto<String>> handleException(HttpServletRequest req, Exception e) {
		ResultDto<String> ret = new ResultDto<>();
        String remoteIp = "unknown"; 
        String userId = "annon";
        String appKey = "unknown";
        String reqId = "unknown";
        String reqUri = "unknown";
		LogContext logContext = LogContextHolder.getLogContext();
		if(logContext!=null){
			reqId = logContext.getReqId();
			remoteIp = logContext.getRemoteIp();
			appKey = logContext.getAppKey();
			userId = logContext.getUserName();
			reqUri = logContext.getReqUri();
		}
		ResponseEntity<ResultDto<String>> httpResp = new ResponseEntity<>(ret, HttpStatus.OK);
		if(e instanceof ServiceException){
			ServiceException se = (ServiceException) e;
			ret.setRetCode(se.getCode());
			ret.setRetMsg(se.getMessage());
			log.error("接口调用业务异常:{},query params:{}", new Object[]{ExceptionUtils.getRootCauseMessage(e),req.getQueryString()});
		}else if(e instanceof DataAccessException){
			ret.setRetCode(-1);
			ret.setRetMsg("系统异常");
			log.error("接口调用异常:{},query params:{}", new Object[]{ExceptionUtils.getStackTrace(e),req.getQueryString()});
		}else {
			ret.setRetCode(-1);
			ret.setRetMsg(e.getMessage());
			log.error("接口调用异常:{},query params:{}", new Object[]{ExceptionUtils.getStackTrace(e),req.getQueryString()});
		}
		return httpResp;
	}

}
