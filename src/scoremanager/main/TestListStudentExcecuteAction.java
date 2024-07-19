package scoremanager.main;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;

@WebServlet("/search")
public class TestListStudentExcecuteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNumber");

        if (studentNumber == null || studentNumber.isEmpty()) {
            request.setAttribute("errorMessage", "学生情報が存在しませんでした");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // 実際の検索ロジックをここに追加
            // 例えば、データベースから学生情報を検索するなど
        }
    }
}
