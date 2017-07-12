package com.chimu.utils;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class BaseAction {
    public void configResponse(HttpServletResponse response) {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

	public Map<String, Object> configResponseMap(Map<String, Object> map, Integer status) {
		if (status == 1) {
			map.put("status", status);
			map.put("infoMsg", "获取成功");
		} else {
			map.put("status", status);
			map.put("infoMsg", "获取失败");
		}
		return map;
	}
}