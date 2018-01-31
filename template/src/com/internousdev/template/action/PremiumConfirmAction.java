package com.internousdev.template.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class PremiumConfirmAction extends ActionSupport{

	public Map<String, Object> session;

	public String execute(){

	/* DAOでデータベースの「premium_member」のStringを「1」に更新して、セッションも「真」に更新する必要がある
	 * このActionではDAOでその動きが終わった後はSUCCESSをレスポンスするだけ	 *
	 */


		return SUCCESS;
	}



}
