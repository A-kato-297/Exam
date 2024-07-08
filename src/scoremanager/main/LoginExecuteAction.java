package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;
import tool.Action;

public class LoginExecuteAction extends Action {
    public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        TeacherDao dao = new TeacherDao();
        Teacher teacher = dao.login(id, password);

        if (teacher != null) {
            // セッションにユーザーの学校コードと名前を保存
            //session.setAttribute("schoolCd", teacher.getSchoolCd());
            session.setAttribute("userName", teacher.getName());
            session.setAttribute("userId", teacher.getId());

            // デバッグ用ログ: 保存される値を確認
            //System.out.println("userId=" + teacher.getId() + ", userName=" + teacher.getName());

            request.getRequestDispatcher("Menu.action").forward(request, response);
        } else {
            request.setAttribute("error", "IDまたはパスワードが確認できませんでした");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}