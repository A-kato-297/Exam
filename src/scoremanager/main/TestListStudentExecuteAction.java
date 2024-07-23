package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String studentNo = request.getParameter("studentNo");

        TestDao testListDao = new TestDao();
        TestListStudentDao testListStudentDao = new TestListStudentDao();

        request.setAttribute("entYears", testListDao.getEntYears());
        request.setAttribute("classNumbers", testListDao.getClassNumbers());
        request.setAttribute("subjects", testListDao.getSubjects());
        request.setAttribute("studentInfo", testListStudentDao.filter(studentNo));

        request.getRequestDispatcher("test_list_student.jsp").forward(request, response);
    }
}
