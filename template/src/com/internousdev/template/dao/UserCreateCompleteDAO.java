package com.internousdev.template.dao;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class UserCreateCompleteDAO {
			private DBConnector dbconnector = new DBConnector();
			private Connection connection = dbConnector.getConnection();
			private DateUtil dateUtil = new DateUtil();
			private String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";

			public void cerateUser(String loginUserId,String loginUserPassword,String userName)
				throws SQLException{
				try{
						PreparedStatement preparedStatement=connection.prepareStatement(sql);
						preparedStatement.setString(1, loginUserId);
/*///////////////////////////////////*/
				}
			}

}
