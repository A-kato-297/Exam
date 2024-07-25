package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestDao extends Dao {

    public List<Integer> getEntYears() throws Exception {
        List<Integer> entYears = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT ORDER BY ENT_YEAR");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            entYears.add(rs.getInt("ENT_YEAR"));
        }
        st.close();
        connection.close();
        return entYears;
    }

    public List<String> getClassNumbers() throws Exception {
        List<String> classNumbers = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT CLASS_NUM FROM STUDENT ORDER BY CLASS_NUM");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            classNumbers.add(rs.getString("CLASS_NUM"));
        }
        st.close();
        connection.close();
        return classNumbers;
    }

    public List<String> getSubjects() throws Exception {
        List<String> subjects = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT NAME FROM SUBJECT");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            subjects.add(rs.getString("NAME"));
        }
        st.close();
        connection.close();
        return subjects;
    }

    public List<Integer> getTestNos() throws Exception {
        List<Integer> testNos = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT NO FROM TEST ORDER BY NO");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            testNos.add(rs.getInt("NO"));
        }
        st.close();
        connection.close();
        return testNos;
    }

    public List<Test> filter(int entYear, String classNum, String subjectName, int testNo) throws Exception {
        List<Test> tests = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(
            "SELECT STUDENT.ENT_YEAR, STUDENT.CLASS_NUM, STUDENT.NO, STUDENT.NAME, TEST.POINT, TEST.NO AS TEST_NO, SUBJECT.NAME AS SUBJECT_NAME " +
            "FROM STUDENT " +
            "JOIN TEST ON STUDENT.NO = TEST.STUDENT_NO " +
            "JOIN SUBJECT ON TEST.SUBJECT_CD = SUBJECT.CD AND TEST.SCHOOL_CD = SUBJECT.SCHOOL_CD " +
            "WHERE STUDENT.ENT_YEAR = ? AND STUDENT.CLASS_NUM = ? AND SUBJECT.NAME = ? AND TEST.NO = ? " +
            "AND TEST.SCHOOL_CD = STUDENT.SCHOOL_CD"
        );
        st.setInt(1, entYear);
        st.setString(2, classNum);
        st.setString(3, subjectName);
        st.setInt(4, testNo);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
            test.setEntYear(rs.getInt("ENT_YEAR"));
            test.setClassNum(rs.getString("CLASS_NUM"));
            test.setStudentNo(rs.getString("NO"));
            test.setName(rs.getString("NAME"));  // 名前を設定
            test.setPoint(rs.getInt("POINT"));
            test.setNo(rs.getInt("TEST_NO"));
            tests.add(test);
        }
        st.close();
        connection.close();
        return tests;
    }

    public void save(String studentNo, int point) throws Exception {
        Connection connection = getConnection();
        String sql = "UPDATE TEST SET POINT = ? WHERE STUDENT_NO = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, point);
        st.setString(2, studentNo);
        st.executeUpdate();
        st.close();
        connection.close();
    }
}
