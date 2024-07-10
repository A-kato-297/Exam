package scoremanager.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClassNum;
import dao.Dao;
import tool.Action;

public class StudentCreateAction extends Action {

    public void execute(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        // userIdが存在するか確認
        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 教師の学校コードを取得
        String schoolCd = getSchoolCdByUserId(userId);

        // 学校コードに対応するクラス番号の一覧を取得
        List<ClassNum> classNumList = getClassNumsBySchoolCd(schoolCd);

        // クラス番号の一覧をリクエストに設定
        request.setAttribute("classNumList", classNumList);

        request.getRequestDispatcher("student_create.jsp")
            .forward(request, response);
    }

    private String getSchoolCdByUserId(String userId) {
        String schoolCd = null;
        Dao dao = new Dao();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement st = connection.prepareStatement(
                "SELECT SCHOOL_CD FROM TEACHER WHERE ID = ?"
            );
            st.setString(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                schoolCd = rs.getString("SCHOOL_CD");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schoolCd;
    }

    private List<ClassNum> getClassNumsBySchoolCd(String schoolCd) {
        List<ClassNum> classNumList = new ArrayList<>();
        Dao dao = new Dao();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement st = connection.prepareStatement(
                "SELECT CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = ?"
            );
            st.setString(1, schoolCd);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassNum classNum = new ClassNum();
                classNum.setClassNum(rs.getString("CLASS_NUM"));
                classNumList.add(classNum);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classNumList;
    }
}
