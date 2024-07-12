package scoremanager.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDao;
import dao.TeacherDao;
import tool.Action;

public class StudentUpdateAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String studentNo = request.getParameter("no");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            TeacherDao teacherDao = new TeacherDao();
            String schoolCd = teacherDao.getSchoolCdById(userId);

            StudentDao studentDao = new StudentDao();
            Student student = studentDao.filter(studentNo, schoolCd);
            List<String> classNums = studentDao.getClassNumbers(schoolCd);

            request.setAttribute("student", student);
            request.setAttribute("classNums", classNums);
            request.getRequestDispatcher("student_update.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
