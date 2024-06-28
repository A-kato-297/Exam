package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // フォームデータを取得
            String cd = request.getParameter("cd");
            String name = request.getParameter("name");

            // 学生情報を設定
            Subject subject = new Subject();
            subject.setCd(cd);
            subject.setName(name);

            // データベースに学生情報を追加
            SubjectDao dao = new SubjectDao();
            dao.save(subject);

            // 成功時
            request.getRequestDispatcher("subject-create-done.jsp").forward(request, response);
        } catch (Exception e) {
            // 失敗時
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}