package com.internousdev.craftdenki.dto;


public class LoginDTO {

	private String LoginId;
	private String LoginPass;

	public String getLoginId(){
		return LoginId;
	}

	public void setLoginId(String LoginId) {
		this.LoginId = LoginId;
	}

	public String getLoginPass(){
		return LoginPass;
	}

	public void setLoginPass(String LoginPass) {
		this.LoginPass = LoginPass;
	}

}
