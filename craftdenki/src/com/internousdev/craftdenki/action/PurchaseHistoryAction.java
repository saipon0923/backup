package com.internousdev.craftdenki.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.craftdenki.dao.PurchaseHistoryDAO;
import com.internousdev.craftdenki.dto.PurchaseHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private PurchaseHistoryDAO dao = new PurchaseHistoryDAO();
	private ArrayList<PurchaseHistoryDTO> purchaseHistoryList = new ArrayList<PurchaseHistoryDTO>();
	private String deleteFlg;
	private String userId;
	private String result;
	private Collection<String> checkList;
	private String product_id;
	private String reviewFlg;

	public String execute() throws SQLException {

//		int count = 0;
		if (deleteFlg == null) {
			String userId = session.get("trueID").toString();
			purchaseHistoryList = dao.getPurchaseHistory(userId);
			System.out.println("aaa");
			return SUCCESS;
		}

		for (String deleteId:checkList) {
			System.out.println("DELETEID : " + deleteId);
			dao.deleteHistoryInfo(deleteId);
				result = "delete";
		}

		if(reviewFlg == ("1")){
			result = "review";
			return result;
		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<PurchaseHistoryDTO> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}

	public void setPurchaseHistoryList(ArrayList<PurchaseHistoryDTO> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getReviewFlg() {
		return reviewFlg;
	}

	public void setReviewFlg(String reviewFlg) {
		this.reviewFlg = reviewFlg;
	}


}

