package com.hao.project.wx.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hao.framework.web.domain.AjaxResult;
import com.hao.framework.web.domain.JsonResult;

@RestController
public class SysUserController {

	@GetMapping(value = "wx/api/openid")
	public JsonResult selectOpenId(@RequestParam Map m) {
		System.out.println(m.get("id"));
		System.out.println(m.get("id1"));
		System.out.println(m.keySet().size());
		Object obj="这是返回的data";
		return JsonResult.success(obj);
	}
}
