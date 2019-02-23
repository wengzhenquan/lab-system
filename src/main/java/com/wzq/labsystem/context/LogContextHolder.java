package com.wzq.labsystem.context;

/**
 * 
 * @author zhuangyingqin
 *
 */
public class LogContextHolder {
	private static ThreadLocal<LogContext> local = new ThreadLocal<LogContext>();
	/**
	 * 设置当前线程日志上下文信息
	 * 
	 * @param context
	 */
	public static void setLogContext( LogContext context )
	{
		local.set( context );
	}

	/**
	 * 获取当前线程日志上下文信息
	 * 
	 * @return
	 */
	public static LogContext getLogContext()
	{
		return local.get();
	}
	
	/**
	 * 销毁日志上下文对象
	 */
	public void remove(){
		local.remove();
	} 
}
