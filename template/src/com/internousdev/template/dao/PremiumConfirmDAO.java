package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.action.LoginAction;
import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class PremiumConfirmDAO implements SessionAware{

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();

	private LoginAction loginaction=new LoginAction();

	public Map<String, Object> session;


	public void changePremium (){

		/*① データベースのある行を特定してそのカラムを書き換え
		 *
		 * どの行を更新するか決めるために、セッションから「login_id」と「login_pass」をひっぱりだして、MySQLでそれと同じ値を持ったIDを特定
		 * 	「premium_number」を「1」に更新
		 *　String sql="update login_user_transaction set premium_number='1' where セッションからひっぱってきたid AND pass"
		 *
		 *whereの部分をどう表現するか
		 *
		 * ②セッションの書き換え
		 *
		 * セッション 鍵名「loginUser」の値「loginDTOクラス boolean型 premiumMember」を「true」に更新
		 *
		 */

		String id=((LoginDTO) session.get("loginUser")).getLoginId();
		String pass=((LoginDTO) session.get("loginUser")).getLoginPassword();

		//これを変数ではなく、ただの文字列にできたら SQL文のWHEREとして書ける

		String sql="update login_user_transaction set premium_number='1' where login_id=? and login_pass=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);

			ps.executeUpdate();

			//↑までで、①は実行できた。

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//ここからは②
		/* LoginActionにゲッター作って、セッションをこのクラスで使えるようにしたけどうまくいかない
		 *setSessionメソッド使って、LoginActionからセッションもらってきて、このクラスのセッションに代入？
		 */
		//loginaction.getSession();
		loginaction.setSession(session);
		session.put("loginUser",loginDTO.setPremiumMember(true));



	}



	public Map<String, Object> getSession() {
        return session;
    }

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

}