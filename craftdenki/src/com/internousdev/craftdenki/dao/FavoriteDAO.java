package com.internousdev.craftdenki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.craftdenki.dto.FavoriteDTO;
import com.internousdev.craftdenki.util.DBConnector;


public class FavoriteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<FavoriteDTO> getFavoriteInfo(String loginId) throws SQLException {
		ArrayList<FavoriteDTO> favoriteDTO = new ArrayList<FavoriteDTO>();
		// SQL文わからない
		String sql = "SELECT product_name, product_name_kana, image_file_path,image_file_name, price, release_company, release_date from favorite_info JOIN product_info ON favorite_info.product_id = product_info.product_id where user_id = ?";


		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();



			while (rs.next()) {
				FavoriteDTO dto = new FavoriteDTO();
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setPrice(rs.getString("price"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				favoriteDTO.add(dto);
				// FavoriteDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return favoriteDTO;
	}






	public int deleteFavoriteInfo(String product_id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int count=0;
		String sql="delete from favorite_info where product_id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,product_id);

			count = ps.executeUpdate();
			System.out.println(count);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}





	//カートテーブルにInsertメソッド
		public void insertFavorite(String user_id,int product_id) throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			String insert = "INSERT INTO favorite_info (user_id,product_id,regist_date) VALUES(?,?,NOW())";

			try{
				PreparedStatement ps = connection.prepareStatement(insert);
				ps.setString(1,user_id);
				ps.setInt(2,product_id);


				ps.execute();

			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
		}












}
