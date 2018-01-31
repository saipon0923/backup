package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author internous
 *
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;

	private String loginPassword;

	private String userName;

	/*ここから自分でいじったところ*/

	private String userOld;

	private String userSex;


	private String userAddress;

	private String userPhoneNumber;

	private String userMailAddress;


	/*自分でいじったところはここまで*/

	public Map<String,Object> session;

	private String result;

	private String errorMessage;

	/**
	 * 入力情報格納処理
	 */
	public String execute() {

		result = SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))
				/*ここから下もいじってる*/
				&& !(userOld.equals(""))&& !(userSex.equals(""))
				&& !(userAddress.equals(""))&& !(userPhoneNumber.equals(""))&& !(userMailAddress.equals(""))) {
				/*いじりおわったところ*/
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
				/*いじりはじめ*/
			session.put("userOld", userOld);
			session.put("userSex", userSex);
			session.put("userAddress", userAddress);
			session.put("userPhoneNumber", userPhoneNumber);
			session.put("userMailAddress", userMailAddress);
				/*いじりおわり*/
		} else {

			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*いじりはじめ*/

	public String getUserOld() {
		return userOld;
	}

	public void setUserOld(String userOld) {
		this.userOld = userOld;
	}

	public String getUserSex() {
		return userSex;
	}

	public void serUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserMailAddress() {
		return userMailAddress;
	}

	public void setUserMailAddress(String userMailAddress) {
		this.userMailAddress = userMailAddress;
	}

	/*いじりおわり*/


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
