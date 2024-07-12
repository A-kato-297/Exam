package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String classNum = request.getParameter("classNum");
        boolean isAttend = request.getParameter("isAttend") != null;
        int entYear = Integer.parseInt(request.getParameter("entYear"));

        try {
            StudentDao studentDao = new StudentDao();
            studentDao.update(no, name, classNum, isAttend, entYear);
            request.getRequestDispatcher("student_update_done.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
