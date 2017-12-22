
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex1")////////////アノテーション ←URLパターンをここで設定
public class EX1 extends HttpServlet {/////////←サーブレットクラスの土台になるHttpServletを継承している
	private static final long serialVersionUID = 1L;/////////////////←現状はわからないので無視、合言葉みたいなもの
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{///doGetメソッドをオーバーライドして使用
		response.setContentType("text/html; charset=UTF-8");///コンテンツタイプヘッダでブラウザ側にレスポンスする書式？を教えている、これはHTMLでエンコはUTF-8
		PrintWriter out = response.getWriter();
		out.println("<html><body>Hello</body></html>");
	}

}
