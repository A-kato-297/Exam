package scoremanager.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDao;
import dao.TeacherDao;
import tool.Action;

public class SubjectListAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subject_list;
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null || userId.isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            // セッションで取得したuserID経由でSchoolCDを取得
            TeacherDao teacherDao = new TeacherDao();
            String schoolCd = teacherDao.getSchoolCdById(userId);

            if (schoolCd == null || schoolCd.isEmpty()) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            // SchoolCDで科目をフィルタリング
            SubjectDao subjectDao = new SubjectDao();
            subject_list = subjectDao.get(schoolCd);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("subject_list", subject_list);
        request.getRequestDispatcher("subject_list.jsp")
            .forward(request, response);
    }
}
