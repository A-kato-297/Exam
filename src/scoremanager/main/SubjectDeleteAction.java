package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String subjectCd = request.getParameter("cd");

        SubjectDao subjectDao = new SubjectDao();
        Subject subject = subjectDao.find(subjectCd);

        HttpSession session = request.getSession();
        session.setAttribute("subject", subject);

        request.getRequestDispatcher("subject_delete.jsp").forward(request, response);
    }
}