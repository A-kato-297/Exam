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
//		School school = request.getParameter("school");
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.login(id, password);

		if (teacher != null) {
			session.setAttribute("Teacher", teacher);
			request.getRequestDispatcher("Menu.action").forward(request, response);
		} else {
			// ユーザーが見つからなかった場合、login.jspにフォワード
			request.setAttribute("error", "IDまたはパスワードが確認できませんでした");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}