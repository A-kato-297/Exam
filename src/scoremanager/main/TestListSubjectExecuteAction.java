package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int entYear = Integer.parseInt(request.getParameter("entYear"));
        String classNum = request.getParameter("classNum");
        String subjectName = request.getParameter("subjectName");

        TestDao testListDao = new TestDao();
        TestListSubjectDao testListSubjectDao = new TestListSubjectDao();

        request.setAttribute("entYears", testListDao.getEntYears());
        request.setAttribute("classNumbers", testListDao.getClassNumbers());
        request.setAttribute("subjects", testListDao.getSubjects());
        request.setAttribute("subjectName", subjectName);
        request.setAttribute("testSubjects", testListSubjectDao.filter(entYear, classNum, subjectName));

        request.getRequestDispatcher("test_list_subject.jsp").forward(request, response);
    }
}
