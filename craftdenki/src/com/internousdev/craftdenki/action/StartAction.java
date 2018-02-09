package com.internousdev.craftdenki.action;

import java.util.Map;
import java.util.Random;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class StartAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){


		if(!(session.containsKey("trueId") || (session.containsKey("tempLoginFlg")))){

		Random rnd = new Random();
		boolean tempLoginFlg = false;

		System.out.println(rnd);
		System.out.println(tempLoginFlg);
		session.put("temp_user_id", rnd);
		session.put("tempLoginFlg",tempLoginFlg);
		System.out.println("仮ユーザーID発行");

		}



		return SUCCESS;
	}


	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
