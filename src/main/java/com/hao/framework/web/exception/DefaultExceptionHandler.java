package com.hao.framework.web.exception;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hao.common.exception.DemoModeException;
import com.hao.common.utils.security.PermissionUtils;
import com.hao.framework.web.domain.JsonResult;

/**
 * 自定义异常处理器
 * 
 * @author hao
 */
@SuppressWarnings("all")
@RestControllerAdvice
public class DefaultExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    
    /**
     * 权限校验失败
     */
    @ExceptionHandler(AuthorizationException.class)
    public JsonResult handleAuthorizationException(AuthorizationException e)
    {
        log.error(e.getMessage(), e);
        return JsonResult.error(PermissionUtils.getMsg(e.getMessage()));
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public JsonResult handleException(HttpRequestMethodNotSupportedException e)
    {
        log.error(e.getMessage(), e);
        return JsonResult.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public JsonResult notFount(RuntimeException e)
    {
        log.error("运行时异常:", e);
        return JsonResult.error("运行时异常:" + e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return JsonResult.error("服务器错误，请联系管理员");
    }
    
    /**
     * 演示模式异常
     */
    @ExceptionHandler(DemoModeException.class)
    public JsonResult demoModeException(DemoModeException e)
    {
        return JsonResult.error("演示模式，不允许操作");
    }
    
    /**
     *  数据校验失败
     */
   
	@ExceptionHandler(BindException.class)
    public JsonResult bindExceptionException(BindException e)
    {
    	BindingResult result=e.getBindingResult();
		Map m=new HashMap();
    	if(result.hasErrors()) {
    		Iterator<ObjectError> iterator = result.getAllErrors().iterator(); // 获取全部错误信息
            while (iterator.hasNext()) {
                FieldError error = (FieldError) iterator.next() ;    // 取出每一个错误
                m.put(error.getField(), error.getDefaultMessage());
            }
    	}
        log.error(e.getMessage(), e);
        return JsonResult.error("数据验证错误",m);
    }
    
    /**
     *  数据校验失败2
     *  当 @Valid @RequestBody 同时使用时捕获到是下面的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult bindExceptionExceptionq(MethodArgumentNotValidException e)
    {
    	BindingResult result=e.getBindingResult();
    	Map m=new HashMap();
    	if(result.hasErrors()) {
    		Iterator<ObjectError> iterator = result.getAllErrors().iterator(); // 获取全部错误信息
            while (iterator.hasNext()) {
                FieldError error = (FieldError) iterator.next() ;    // 取出每一个错误
                m.put(error.getField(), error.getDefaultMessage());
            }
    	}
        log.error(e.getMessage(), e);
        return JsonResult.error("数据验证错误",m);
    }

}
