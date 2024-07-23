package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import tool.Action;

public class TestListAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TestDao dao = new TestDao();
        request.setAttribute("entYears", dao.getEntYears());
        request.setAttribute("classNumbers", dao.getClassNumbers());
        request.setAttribute("subjects", dao.getSubjects());
        request.getRequestDispatcher("test_list.jsp").forward(request, response);
    }
}
