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

public class PreStudentListAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        List<Student> student_list = new ArrayList<>();
        List<Integer> entYears = new ArrayList<>();
        List<String> classNums = new ArrayList<>();

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            Connection con = ds.getConnection();

            // IDから学校コードを取得
            TeacherDao teacherDao = new TeacherDao();
            String schoolCd = teacherDao.getSchoolCdById(userId);

            // 学校コードに基づいて入学年度とクラス番号の一覧を取得
            PreparedStatement yearSt = con.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT WHERE SCHOOL_CD = ?");
            yearSt.setString(1, schoolCd);
            ResultSet yearRs = yearSt.executeQuery();
            while (yearRs.next()) {
                entYears.add(yearRs.getInt("ENT_YEAR"));
            }
            yearSt.close();

            PreparedStatement classSt = con.prepareStatement("SELECT DISTINCT CLASS_NUM FROM STUDENT WHERE SCHOOL_CD = ?");
            classSt.setString(1, schoolCd);
            ResultSet classRs = classSt.executeQuery();
            while (classRs.next()) {
                classNums.add(classRs.getString("CLASS_NUM"));
            }
            classSt.close();

            // 絞り込み条件
            String entYear = request.getParameter("ent_year");
            String classNum = request.getParameter("class_num");
            String isAttend = request.getParameter("is_attend");
            boolean filterByEntYear = entYear != null && !entYear.isEmpty();
            boolean filterByClassNum = classNum != null && !classNum.isEmpty();
            boolean filterByIsAttend = isAttend != null && isAttend.equals("on");

            StringBuilder query = new StringBuilder("SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND FROM STUDENT WHERE SCHOOL_CD = ?");
            if (filterByEntYear) {
                query.append(" AND ENT_YEAR = ?");
            }
            if (filterByClassNum) {
                query.append(" AND CLASS_NUM = ?");
            }
            if (filterByIsAttend) {
                query.append(" AND IS_ATTEND = TRUE");
            }

            PreparedStatement st = con.prepareStatement(query.toString());
            st.setString(1, schoolCd);
            int index = 2;
            if (filterByEntYear) {
                st.setInt(index++, Integer.parseInt(entYear));
            }
            if (filterByClassNum) {
                st.setString(index++, classNum);
            }

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setClassNum(rs.getString("class_num"));
                student.setEntYear(rs.getInt("ent_year"));
                student.setIsAttend(rs.getBoolean("is_attend"));
                student_list.add(student);
            }

            st.close();
            con.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("student_list", student_list);
        request.setAttribute("entYears", entYears);
        request.setAttribute("classNums", classNums);
        request.setAttribute("result_count", student_list.size());
        request.getRequestDispatcher("pre_student_list.jsp")
            .forward(request, response);
    }
}
