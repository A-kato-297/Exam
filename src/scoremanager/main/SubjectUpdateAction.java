package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String subjectCd = request.getParameter("cd");

        if (subjectCd == null || subjectCd.isEmpty()) {
            // パラメータが正しく渡されていない場合のエラーメッセージ
            request.setAttribute("error", "科目コードが指定されていません。");
            request.getRequestDispatcher("/subject_update.jsp").forward(request, response);
            return;
        }

        SubjectDao subjectDao = new SubjectDao();
        Subject subject = subjectDao.filter(subjectCd);

        if (subject == null) {
            // 科目が見つからない場合のエラーメッセージ
            request.setAttribute("error", "変更する科目が見つかりません。");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("subject", subject);
        }

        request.getRequestDispatcher("subject_update.jsp").forward(request, response);
    }
}
