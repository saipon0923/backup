package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();
/*いじりはじめ*/
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, user_old, user_sex, user_address, user_phonenumber, user_mailaddress, insert_date) VALUES(?, ? ,?, ?, ?, ?, ?, ?, ?)";

	public void createUser(String loginUserId, String loginUserPassword, String userName,String userOld,String userSex,String userAddress,String userPhoneNumber,String userMailAddress) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, userOld);
			preparedStatement.setString(5, userSex);
			preparedStatement.setString(6, userAddress);
			preparedStatement.setString(7, userPhoneNumber);
			preparedStatement.setString(8, userMailAddress);
			preparedStatement.setString(9, dateUtil.getDate());
/*いじりおわり*/
			preparedStatement.execute();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
