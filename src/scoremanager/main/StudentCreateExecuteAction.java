package scoremanager.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import tool.Action;
import tool.Page;

public class StudentCreateExecuteAction extends Action {

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
            StudentDao studentDao = new StudentDao();
            studentDao.save(entYear, studentNo, studentName, classNum);

            // 追加に成功した時
            request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
        } catch (Exception e) {
            // 追加に失敗した時
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
