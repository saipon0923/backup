package com.internousdev.craftdenki.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.craftdenki.dao.CategoryDAO;
import com.internousdev.craftdenki.dao.ProductListDAO;
import com.internousdev.craftdenki.dto.CategoryDTO;
import com.internousdev.craftdenki.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CheckProductChangeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	private ArrayList<String> errorMessageList = new ArrayList<>();
	private String errorMessage;
	private List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();

	private String id; //PK
	private String productId; //新商品ID
	private String productName; //商品名
	private String productNameKana; //商品名かな
	private String productDescription; //商品詳細
	private String categoryId; //カテゴリID
	private String price; //販売価格
	private String imageFileName; //画像ファイル名
	private String releaseDate; //発売年月
	private String releaseCompany; //発売会社

	public String execute() throws SQLException{
		String result=ERROR;

		System.out.println("id: "+id);

		if(true){      //管理者判定
			result = SUCCESS;

			//カテゴリテーブルよりカテゴリリストを取得
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryList = categoryDAO.getCategoryInfo();



			ProductListDAO dao = new ProductListDAO();

			InputChecker i = new InputChecker();

			if(!(session.get("productId").toString().equals(productId)) && dao.existsProductId(productId)){
				errorMessageList.add("入力された商品IDは既に存在します");
				result = "error1";
			}else if (!i.newProductIdChk(productId).equals("OK")) {
				errorMessageList.add(i.newProductIdChk(productId));
				result = "error1";
			}

			if (!i.newProductNameChk(productName).equals("OK")) {
				errorMessageList.add(i.newProductNameChk(productName));
				result = "error1";
			}

			if (!i.newProductNameKanaChk(productNameKana).equals("OK")) {
				errorMessageList.add(i.newProductNameKanaChk(productNameKana));
				result = "error1";
			}

			if (!i.newProductDescriptionChk(productDescription).equals("OK")) {
				errorMessageList.add(i.newProductDescriptionChk(productDescription));
				result = "error1";
			}

			if (!i.newCategoryIdChk(categoryId).equals("OK")) {
				errorMessageList.add(i.newCategoryIdChk(categoryId));
				result = "error1";
			}

			if (!i.newBuyPriceChk(price).equals("OK")) {
				errorMessageList.add(i.newBuyPriceChk(price));
				result = "error1";
			}

			if (!i.newReleaseDateChk(releaseDate).equals("OK")) {
				errorMessageList.add(i.newReleaseDateChk(releaseDate));
				result = "error1";
			}

			if (!i.newReleaseCompanyChk(releaseCompany).equals("OK")) {
				errorMessageList.add(i.newReleaseCompanyChk(releaseCompany));
				result = "error1";
			}

			if (!i.newProductImageChk(imageFileName).equals("OK")) {
				errorMessageList.add(i.newProductImageChk(imageFileName));
				result = "error1";
			}

		}else errorMessage = "不正なアクセスです。もう一度ログインをお願いいたします。";
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}


}
