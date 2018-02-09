package com.internousdev.craftdenki.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.craftdenki.dao.ItemSearchDAO;
import com.internousdev.craftdenki.dto.ProductDTO;
import com.internousdev.craftdenki.util.ZenkakuKatakanaToZenkakuHiragana;
import com.opensymphony.xwork2.ActionSupport;

public class ItemSearchAction extends ActionSupport implements SessionAware{


	private String category; //jspで選択したカテゴリ1~4(String型)
	private String searchWord; //jspで記入した検索ワード　半角英数字ひらがな漢字 16文字以下
	private String searchMessage;  //～件hitしました or 検索結果がありません

	public Map<String,Object>session;

	//検索結果格納 jspに表示
	public ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();

	private ItemSearchDAO itemSearchDAO = new ItemSearchDAO();

	private ZenkakuKatakanaToZenkakuHiragana zenkakuKatakanaToZenkakuHiragana = new ZenkakuKatakanaToZenkakuHiragana();




	public String execute() throws SQLException{




		productList = itemSearchDAO.getItemInfo(searchWord,category);



		if(searchWord.matches("^[\\u30A0-\\u30FF]+$")){
			searchWord = zenkakuKatakanaToZenkakuHiragana.zenkakuHiraganaToZenkakuKatakana(searchWord);
			System.out.println(searchWord + "カタカナ→ひらがな");
		}




		Pattern p = Pattern.compile("^[0-9a-zA-Z_\\p{InHiragana}\\p{InCjkUnifiedIdeographs}]*$"); //半角英数字、ひらがな漢字の判定
		Matcher m = p.matcher(searchWord);

		boolean isFind = m.find(); //searchWordが半角英数字、ひらがな漢字の場合trueを返す   カタカナ\\p{InKatakana}



		if(isFind){


			if(productList.size() > 0){
				int searchItemCount = productList.size();
				String count = Integer.toString(searchItemCount);
				setSearchMessage(count + "件の商品が見つかりました。");

			}else{
				setSearchMessage("検索結果がありません。");
			}

		}else{

			setSearchMessage("入力された文字が不正です。");
		}







		Iterator<ProductDTO> iterator = productList.iterator();
		if(!(iterator.hasNext())){
			productList = null;
		}
		return SUCCESS;

	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getSearchWord() {
		return searchWord;
	}




	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}




	public String getSearchMessage() {
		return searchMessage;
	}




	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
	}




	public Map<String, Object> getSession() {
		return session;
	}




	public void setSession(Map<String, Object> session) {
		this.session = session;
	}









}
