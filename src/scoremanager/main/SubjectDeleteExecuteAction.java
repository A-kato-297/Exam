package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String subjectCd = request.getParameter("cd");

        SubjectDao subjectDao = new SubjectDao();
        subjectDao.delete(subjectCd);

        request.getRequestDispatcher("subject_delete_done.jsp").forward(request, response);
    }
}
