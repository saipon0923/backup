package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PremiumMemberRegistrationAction extends ActionSupport implements SessionAware{

	/** このアクションでは、まずログインしているユーザーがプレミアム会員かどうか判別するために、
	 * DAOからSQLにアクセスして、テーブル「login_user_transaction」のフィールド「premium_member」の値を取得する。
	 *値がpremiumなら、「●●(ユーザー名)はすでにプレミアム会員です。」というメッセージが書かれた画面を表示する、
	 *値がnormalなら「プレミアム会員登録するか？(Confirm画面)」の画面に遷移する。
	 *
	 *追記 1/30   クラス「LoginAction」で先にセッションをとっておき、そのセッションでif文を作れば今回データベースにアクセスする必要はないのでは？

	 *今２４行目でエラー起こってるのはif文の左辺と右辺のデータ型が違うから比較演算子に対応していない？(左辺がLoginDTO型で右辺がString型)
	 *①左辺をさらにString型にキャストするか（二重キャストはあかん気がする）
	 *②そもそもの右辺のデータをbooleanにすればよいのでは　→1/30 PM17時現在はエラーはいてる

	 */

	public Map<String, Object> session;

	public String execute(){
		/*
		 * 下のSystem.out.printlnはセッションがちゃんと入ってるか確認用。プログラムが完成したら消す。1/31 現在はコメント化
		 */
			//System.out.println(((LoginDTO)session.get("loginUser")).getPremiumMember());
//ここでユーザーが現在プレミアム会員かどうかを判別している

			if(!((LoginDTO)session.get("loginUser")).getPremiumMember()){
				return SUCCESS;
			}else{
				return ERROR;
				//↑の遷移先をstruts.xmlに書いてないし、まだファイルを用意してもいない
			}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}