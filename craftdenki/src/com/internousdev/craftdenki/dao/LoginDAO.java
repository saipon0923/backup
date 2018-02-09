package com.internousdev.craftdenki.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.craftdenki.dto.LoginDTO;
import com.internousdev.craftdenki.util.DBConnector;

public class LoginDAO {

	private LoginDTO dto = new LoginDTO();
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public LoginDTO loginUserInfo(String loginId, String loginPassword) {

		String sql = "select*from user_info where user_id = ? and password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setLoginId(rs.getString("user_id"));
				dto.setLoginPass(rs.getString("password"));
			}else{
				dto.setLoginId("noID");
				dto.setLoginPass("noPASS");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void cartInfo(String ProvisionalLoginId, String loginId) {

		String sql = "update cart_transaction set login_id= ? where login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginId);
			ps.setString(2, ProvisionalLoginId);

			int rs = ps.executeUpdate();
			System.out.println(rs + "件更新しました");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
