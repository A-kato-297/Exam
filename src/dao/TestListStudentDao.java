package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestListStudentDao extends Dao {

    public String getStudentName(String studentNo) throws Exception {
        String studentName = null;
        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT NAME FROM STUDENT WHERE NO = ?");
        st.setString(1, studentNo);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            studentName = rs.getString("NAME");
        }

        st.close();
        connection.close();

        return studentName;
    }

    public List<Test> getTestResultsByStudentNo(String studentNo) throws Exception {
        List<Test> tests = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT SUBJECT_CD, NO, POINT FROM TEST WHERE STUDENT_NO = ?");
        st.setString(1, studentNo);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
            test.setSubjectCd(rs.getString("SUBJECT_CD"));
            test.setNo(rs.getInt("NO"));
            test.setPoint(rs.getInt("POINT"));
            tests.add(test);
        }

        st.close();
        connection.close();

        return tests;
    }
}