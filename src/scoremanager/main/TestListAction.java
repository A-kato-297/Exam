package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.TestDao;
import tool.Action;

public class TestListAction extends Action {
    public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        TestDao dao = new TestDao();

        // 学校コードを取得
        String schoolCd = dao.getSchoolCdByUserId(userId);

        // 学校コードに基づいて学生リストを取得
        List<Student> students = dao.getStudentsBySchoolCd(schoolCd);
        request.setAttribute("students", students);

        request.getRequestDispatcher("/scoremanager.main/test_list.jsp").forward(request, response);
    }
}
