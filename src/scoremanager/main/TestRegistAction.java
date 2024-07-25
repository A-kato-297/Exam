package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TestDao dao = new TestDao();

        request.setAttribute("entYears", dao.getEntYears());
        request.setAttribute("classNumbers", dao.getClassNumbers());
        request.setAttribute("subjects", dao.getSubjects());
        request.setAttribute("testNos", dao.getTestNos());

        if (request.getParameter("search") != null) {
            setRequestData(request);
        }

        request.getRequestDispatcher("test_regist.jsp").forward(request, response);
    }

    private void setRequestData(HttpServletRequest request) throws Exception {
        int entYear = Integer.parseInt(request.getParameter("entYear"));
        String classNum = request.getParameter("classNum");
        String subjectName = request.getParameter("subjectName");
        int testNo = Integer.parseInt(request.getParameter("testNo"));

        TestDao dao = new TestDao();
        request.setAttribute("searchResults", dao.filter(entYear, classNum, subjectName, testNo));
    }
}
