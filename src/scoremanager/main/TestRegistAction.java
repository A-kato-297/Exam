package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/scoremanager.main/TestRegistAction"})
public class TestRegistAction extends HttpServlet {

    // doGetメソッドはHTTP GETリクエストを処理します
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    // executeメソッドは主要なサーブレットのロジックを実行します
    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストデータのセット
        setRequestData(request, response);

        // リクエストをtest_regist.jspにフォワード
        request.getRequestDispatcher("test_regist.jsp").forward(request, response);
    }

    // setRequestDataメソッドはリクエストパラメータを取得し、レスポンスとして設定します
    private void setRequestData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // リクエストパラメータの取得
        String year = request.getParameter("year");
        String className = request.getParameter("class");
        String subject = request.getParameter("subject");
        String times = request.getParameter("times");

        // レスポンスのコンテンツタイプを設定
        response.setContentType("text/html; charset=UTF-8");

        // レスポンスの内容を出力
        response.getWriter().write("<html><body>");
        response.getWriter().write("入学年度: " + year + "<br>");
        response.getWriter().write("クラス: " + className + "<br>");
        response.getWriter().write("科目: " + subject + "<br>");
        response.getWriter().write("回数: " + times + "<br>");
        response.getWriter().write("</body></html>");
    }
}
