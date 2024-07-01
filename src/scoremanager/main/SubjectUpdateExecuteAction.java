package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String subjectCd = request.getParameter("cd");
        String subjectName = request.getParameter("name");

        if (subjectCd == null || subjectCd.isEmpty() || subjectName == null || subjectName.isEmpty()) {
            // パラメータが正しく渡されていない場合のエラーメッセージ
            request.setAttribute("error", "科目コードまたは科目名が指定されていません。");
            request.getRequestDispatcher("subject_update.jsp").forward(request, response);
            return;
        }

        SubjectDao subjectDao = new SubjectDao();
        subjectDao.update(subjectCd, subjectName);

        request.getRequestDispatcher("subject_update_done.jsp").forward(request, response);
    }
}