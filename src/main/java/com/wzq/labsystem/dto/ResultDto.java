package com.wzq.labsystem.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDto<T> {
	public final static Integer RET_CODE_APP_PARAM_MISS = 11;
	public final static Integer RET_CODE_APP_NO_EXISTS = 12;
	public final static Integer RET_CODE_APP_SIGN_INCORRECT = 13;
	public final static Integer RET_CODE_APP_METHOD_NO_EXISTS = 14;
	public final static Integer RET_CODE_USER_EXISTS = 15;
	public final static Integer RET_CODE_APP_METHOD_UN_AUTHORIZE = 16;
	public final static Integer RET_CODE_USER_NO_EXISTS = 17;
	public final static Integer RET_CODE_USER_ITEM_EXISTS = 18;
	public final static Integer RET_CODE_ITEMSPEC_UNKNOWN = 19;
	public final static Integer RET_CODE_APP_GAME_UNAUTHORIZE = 20;
	public final static Integer RET_CODE_SYS_BUSY = 10;
	public final static Integer RET_CODE_SYS_TIME_INCORRECT = 9;
	public final static Integer RET_CODE_SYS_FILE_SIZE_EXCEED = 8;
	public final static Integer RET_CODE_SYS_FILE_MUST_NO_EMPTY = 7;

	public final static Integer RET_CODE_USER_RELATIONSHIP_NOT_EXITS= 21;
	public final static Integer RET_CODE_USER_RELATIONSHIP_EXITS= 22;
	public final static Integer RET_CODE_BUILD_RELATIONSHIP_WITHSELF= 23;

	private Integer retCode = 0;
	private String retMsg;
	private T data;
	private String reqId;
	
	public static <T> ResultDto<T> ok(T data){
		return new ResultDto<T>(ResultCode.SUCCESS_CODE.getCode(),null,data,null);
	}
	
	public static <T> ResultDto<T> fail(String message){
		return new ResultDto<T>(ResultCode.FAIL_CODE.getCode(),message,null,null);
	}
}
