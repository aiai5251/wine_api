package com.chimu.utils.tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cache {
	public static Map<String, String> phones = new HashMap<String, String>();
	
	public static Date date;
	public static Object objectToken = new Object();
	public static String token = null;	
}
