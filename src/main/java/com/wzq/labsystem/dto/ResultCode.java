package com.wzq.labsystem.dto;

public enum ResultCode {
	/** 未知错误 **/
	UNKNOWN_ERR_CODE(-1),
	/** 正确 **/
	SUCCESS_CODE(0),
	/** 失败 **/
	FAIL_CODE(1),
	/** 上传文件大小超出限制 **/
	FILE_SIZE_EXCEED(8),
	/** 调用时间戳不满足系统要求（默认与服务端间隔不能超过10min） **/
	SYS_TIME_INCORRECT(9),
	/** 系统繁忙 **/
	SYS_BUSY(10),
	/** 参数缺失 **/
	APP_PARAM_MISS(11),
	/** APP KEY不存在 **/
	APP_NO_EXISTS(12),
	/** 签名错误 **/
	APP_SIGN_INCORRECT(13),
	/** App方法/服务 不存在 **/
	APP_METHOD_NO_EXISTS(14),
	/** 方法/服务 未授权 **/
	APP_METHOD_UN_AUTHORIZE(16),
	/** 方法/服务 未授权 **/
	USER_NO_EXISTS(17),
	/** 参数错误 **/
	PARAM_ERROR_CODE(400),
	/** 限制调用 **/
	LIMIT_ERROR_CODE(401),
	/** token 过期 **/
	TOKEN_TIMEOUT_CODE(402),
	/** 禁止访问 **/
	NO_AUTH_CODE(403),
	/** 资源没找到 **/
	NOT_FOUND(404),
	/** 服务器错误 **/
	SERVER_ERROR_CODE(500),
	/** 服务降级中 **/
	DOWNGRADE(406);
	
	private int code;
	public void setCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	private ResultCode(int code) {
		this.code = code;
	}
}
