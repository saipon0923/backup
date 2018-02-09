package com.internousdev.craftdenki.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.craftdenki.dao.FavoriteDAO;
import com.internousdev.craftdenki.dto.FavoriteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class FavoriteAction extends ActionSupport implements SessionAware {

	private List<FavoriteDTO> favoriteList = new ArrayList<FavoriteDTO>();
	private String deleteFlg;
	private String message;
	public Map<String, Object> session;

	private Collection<String> checkList;

	private String test = "test";



	private int product_id;
	private String userId;





	public String execute() throws SQLException {
		String result = ERROR;
		FavoriteDAO favoriteDAO = new FavoriteDAO();

		//ログイン/未ログインでカートにInsertするIDを変更
				if(session.containsKey("trueID")){
					userId = session.get("trueID").toString();
				}else{
					userId = session.get("temp_user_id").toString();
				}


				System.out.println(product_id);


		FavoriteDAO dao = new FavoriteDAO();

		int count = 0;

		if (deleteFlg == null) {
			favoriteDAO.insertFavorite(userId,product_id);

			favoriteList = dao.getFavoriteInfo(userId);

			System.out.println(favoriteList);

		} else if (deleteFlg == "1") {

			for (String product_id : checkList) {
				count += dao.deleteFavoriteInfo(product_id);
				System.out.println("aaa");
			}

			System.out.println("削除された件数 ：" + count);

			// for(型 変数名 :コレクション)でコレクションの値をひとつずつ取り出し{}内を実行
			// for(String deleteId:delete){
			// this.delete(Integer.parseInt(deleteId));
			// }



		}


		result = SUCCESS;
		return result;



	}




	public Collection<String> getCheckList() {
		return checkList;
	}

	public List<FavoriteDTO> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<FavoriteDTO> favoriteList) {
		this.favoriteList = favoriteList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}






	public String getMessage() {
		return message;
	}






	public void setMessage(String message) {
		this.message = message;
	}






	public String getTest() {
		return test;
	}






	public void setTest(String test) {
		this.test = test;
	}





	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getUserId() {
		return userId;
	}






	public void setUserId(String userId) {
		this.userId = userId;
	}






	public String getDeleteFlg() {
		return deleteFlg;
	}






	public Map<String, Object> getSession() {
		return session;
	}




}
