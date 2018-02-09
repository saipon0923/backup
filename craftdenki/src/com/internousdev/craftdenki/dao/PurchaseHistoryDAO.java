package com.internousdev.craftdenki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.craftdenki.dto.PurchaseHistoryDTO;
import com.internousdev.craftdenki.util.DBConnector;

public class PurchaseHistoryDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<PurchaseHistoryDTO> getPurchaseHistory(String userId) throws SQLException {

		ArrayList<PurchaseHistoryDTO> purchaseHistoryList = new ArrayList<PurchaseHistoryDTO>();

		String sql = "SELECT pi.product_id as product_id,phi.regist_date as regist_date,phi.price as price,pi.image_file_name as image_file_name,pi.product_name as product_name,pi.product_name_kana as product_name_kana,pi.release_company as release_company,pi.release_date as release_date FROM purchase_history_info as phi LEFT JOIN product_info as pi ON phi.product_id = pi.product_id WHERE phi.user_id = ? and phi.status = 0";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();

				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setimageFileName(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setCount(rs.getInt("product_count"));
				dto.setreleaseCompany(rs.getString("release_company"));
				dto.setreleaseDate(rs.getString("release_date"));
				dto.setProductId(rs.getString("product_id"));
				dto.setRegistDate(rs.getString("regist_date"));

				purchaseHistoryList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return purchaseHistoryList;
	}

	public int deleteHistoryInfo(String product_id) {
		String sql = "update purchase_history_info set status = 1 where product_id = ?";
		PreparedStatement ps;
		int result = 0;

		System.out.println("ccc");
		System.out.println(product_id);
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product_id);

			result = ps.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
