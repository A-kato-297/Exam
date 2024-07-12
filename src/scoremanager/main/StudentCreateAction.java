package scoremanager.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClassNum;
import dao.StudentDao;
import tool.Action;

public class StudentCreateAction extends Action {

    public void execute(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        try {
            StudentDao studentDao = new StudentDao();
            // 教師の学校コードを取得
            String schoolCd = studentDao.getSchoolCdByUserId(userId);

            // 学校コードに対応するクラス番号の一覧を取得
            List<ClassNum> classNumList = studentDao.getClassNumsBySchoolCd(schoolCd);

            // クラス番号の一覧をリクエストに設定
            request.setAttribute("classNumList", classNumList);

            request.getRequestDispatcher("student_create.jsp")
                .forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
