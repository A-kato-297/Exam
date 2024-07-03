package scoremanager.main;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Action;
import tool.Page;

public class StudentCreateExecuteAction extends Action {

    // データベースに学生データを挿入するメソッド
    private void insertStudentData(int entYear, String studentNo, String studentName, String classNum) throws SQLException {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            try (Connection con = ds.getConnection();
                 PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT (ENT_YEAR, NO, NAME, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, TRUE, 'oom')")) {

                ps.setInt(1, entYear);
                ps.setString(2, studentNo);
                ps.setString(3, studentName);
                ps.setString(4, classNum);


                ps.executeUpdate();
            }
        } catch (NamingException | SQLException e) {
            throw new SQLException("データベースへの学生データ挿入中にエラーが発生しました", e);
        }
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        try {
            // フォームパラメータの取得
            int entYear = Integer.parseInt(request.getParameter("ent_year"));
            String studentNo = request.getParameter("no");
            String studentName = request.getParameter("name");
            String classNum = request.getParameter("class_num");

            // データベースにデータを挿入
            insertStudentData(entYear, studentNo, studentName, classNum);

         // 追加に成功した時
            request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
        } catch (Exception e) {
         //追加に失敗した時
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        Page.footer(out);

  }
}