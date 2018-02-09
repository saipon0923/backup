package com.internousdev.craftdenki.dto;

public class PurchaseHistoryDTO {

	// 商品名
	private String productName;

	// ふりがな
	private String productNameKana;

	// 商品画像
	private String imageFileName;

	private String imageFilePath;

	// 値段
	private int price;

	// 個数
	private int count;

	// 発売会社名
	private String releaseCompany;

	private String productId;

	// 発売年月日
	private String releaseDate;

	private int id;

	private String registDate;








	// 商品名
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// ふりがな
	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	// 商品画像
	public String getimageFileName() {
		return imageFileName;
	}

	public void setimageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getimageFilePath() {
		return imageFilePath;
	}

	public void setimageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	// 値段
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 個数
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 発売会社名
	public String getreleaseCompany() {
		return releaseCompany;
	}

	public void setreleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	// 発売年月日
	public String getreleaseDate() {
		return releaseDate;
	}

	public void setreleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return 	productId;
		}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getRegistDate() {
		return 	registDate;
		}

}
