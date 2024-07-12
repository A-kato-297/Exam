package scoremanager.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bean.Student;
import dao.TeacherDao;
import tool.Action;

public class StudentUpdateAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String studentNo = request.getParameter("no");
        List<String> classNums = new ArrayList<>();

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            Connection con = ds.getConnection();

            TeacherDao teacherDao = new TeacherDao();
            String schoolCd = teacherDao.getSchoolCdById(userId);

            // 学生の詳細を取得するSQLクエリ
            PreparedStatement st = con.prepareStatement(
                "SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND FROM STUDENT WHERE NO = ? AND SCHOOL_CD = ?"
            );
            st.setString(1, studentNo);
            st.setString(2, schoolCd);
            ResultSet rs = st.executeQuery();

            Student student = new Student();
            if (rs.next()) {
                student.setNo(rs.getString("NO"));
                student.setName(rs.getString("NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setIsAttend(rs.getBoolean("IS_ATTEND"));
            }

            PreparedStatement classSt = con.prepareStatement("SELECT CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = ?");
            classSt.setString(1, schoolCd);
            ResultSet classRs = classSt.executeQuery();
            while (classRs.next()) {
                classNums.add(classRs.getString("CLASS_NUM"));
            }
            classSt.close();
            con.close();

            request.setAttribute("student", student);
            request.setAttribute("classNums", classNums);
            request.getRequestDispatcher("student_update.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
