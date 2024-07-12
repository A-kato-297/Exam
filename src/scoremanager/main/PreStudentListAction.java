package scoremanager.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDao;
import dao.TeacherDao;
import tool.Action;

public class PreStudentListAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        List<Student> student_list = new ArrayList<>();
        List<Integer> entYears = new ArrayList<>();
        List<String> classNums = new ArrayList<>();

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            TeacherDao teacherDao = new TeacherDao();
            String schoolCd = teacherDao.getSchoolCdById(userId);

            StudentDao studentDao = new StudentDao();
            entYears = studentDao.getEntYears(schoolCd);
            classNums = studentDao.getClassNums(schoolCd);

            String entYear = request.getParameter("ent_year");
            String classNum = request.getParameter("class_num");
            String isAttend = request.getParameter("is_attend");

            student_list = studentDao.get(schoolCd, entYear, classNum, isAttend);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("student_list", student_list);
        request.setAttribute("entYears", entYears);
        request.setAttribute("classNums", classNums);
        request.setAttribute("result_count", student_list.size());
        request.getRequestDispatcher("pre_student_list.jsp")
            .forward(request, response);
    }
}
