package com.chimu.wine.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import java.util.Map;

public abstract class BaseAction {
	protected abstract Map<String, Object> Action(HttpServletRequest request, HttpServletResponse response, ModelMap model)  throws Exception;
	
    public Map<String, Object> Init(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return Action(request, response, model);
	}
}