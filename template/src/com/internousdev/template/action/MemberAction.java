package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{

	/**
	 * 「会員情報」ボタンを押すと、会員情報画面に遷移させる。
	 *
	 *
	 * @return SUCCSESS
	 */
	public String execute() {
		return SUCCESS;
	}
}
