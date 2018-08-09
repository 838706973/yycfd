package com.hao.framework.web.domain;

/**
 * json形式返回
 * @author hzq
 *
 */
public class JsonResult {
	private int code;
	private Object data;
	private String msg = "success";
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static JsonResult success() {
		JsonResult jsonResult=new JsonResult();
		jsonResult.setCode(200);
		jsonResult.setMsg("success");
		return jsonResult;
	}
	public static JsonResult success(String msg) {
		JsonResult jsonResult=success();
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult success(int code) {
		JsonResult jsonResult=success();
		jsonResult.setCode(code);
		return jsonResult;
	}
	public static JsonResult success(int code,String msg) {
		JsonResult jsonResult=new JsonResult();
		jsonResult.setCode(code);
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult success(Object data) {
		JsonResult jsonResult=success();
		jsonResult.setData(data);
		return jsonResult;
	}
	public static JsonResult success(int code,Object data) {
		JsonResult jsonResult=success(data);
		jsonResult.setCode(code);
		return jsonResult;
	}
	public static JsonResult success(String msg,Object data) {
		JsonResult jsonResult=success(data);
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult success(int code,String msg,Object data) {
		JsonResult jsonResult=success(code,data);
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	
	public static JsonResult error() {
		JsonResult jsonResult=new JsonResult();
		jsonResult.setCode(500);
		jsonResult.setMsg("error");
		return jsonResult;
	}
	public static JsonResult error(String msg) {
		JsonResult jsonResult=error();
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult error(int code) {
		JsonResult jsonResult=error();
		jsonResult.setCode(code);
		return jsonResult;
	}
	public static JsonResult error(int code,String msg) {
		JsonResult jsonResult=new JsonResult();
		jsonResult.setCode(code);
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult error(Object data) {
		JsonResult jsonResult=error();
		jsonResult.setData(data);
		return jsonResult;
	}
	public static JsonResult error(int code,Object data) {
		JsonResult jsonResult=error(data);
		jsonResult.setCode(code);
		return jsonResult;
	}
	public static JsonResult error(String msg,Object data) {
		JsonResult jsonResult=error(data);
		jsonResult.setMsg(msg);
		return jsonResult;
	}
	public static JsonResult error(int code,String msg,Object data) {
		JsonResult jsonResult=error(code,data);
		jsonResult.setMsg(msg);
		return jsonResult;
	}

}
