package com.nexcloud.util.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nexcloud.util.Util;
import com.nexcloud.util.consts.HTTP;

@Component
public class Mysql{
	static final Logger logger = LoggerFactory.getLogger(Mysql.class);
	private Gson gson = new Gson();
	

	public String resultToResponse (Object o) {
		try{
			String resultStr = gson.toJson(o);
			logger.debug("[Mysql response]" + "\n" + resultStr);
			return gson.toJson(new Success(HTTP.CODE.OK, HTTP.MESSAGE.OK, "MySql", resultStr));
    	}catch(Exception e){
    		logger.error("[Mysql Request Error]");
    		return gson.toJson(new Error(HTTP.CODE.EXCEPTION, HTTP.MESSAGE.EXCEPTION, Util.makeStackTrace(e)));
    	}
	}
}
