package com.chimu.wine.action;

import javax.servlet.http.HttpServletResponse;

public abstract class BaseAction {
    public void configResponse(HttpServletResponse response) {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
	}
}