package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestListSubjectDao extends Dao {

    // 科目名を取得
    public String getSubjectName(String subjectCd) throws Exception {
        String subjectName = null;

        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT NAME FROM SUBJECT WHERE CD = ?");
        st.setString(1, subjectCd);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            subjectName = rs.getString("NAME");
        }

        st.close();
        connection.close();

        return subjectName;
    }

    // 科目のテスト結果を取得
    public List<Test> getTestResultsBySubjectCd(String entYear, String classNum, String subjectCd) throws Exception {
        List<Test> testResults = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement(
            "SELECT STUDENT_NO, ENT_YEAR, CLASS_NUM, NO, POINT " +
            "FROM TEST " +
            "WHERE ENT_YEAR = ? AND CLASS_NUM = ? AND SUBJECT_CD = ?"
        );
        st.setString(1, entYear);
        st.setString(2, classNum);
        st.setString(3, subjectCd);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
            test.setStudentNo(rs.getString("STUDENT_NO"));
            test.setEntYear(rs.getInt("ENT_YEAR"));
            test.setClassNum(rs.getString("CLASS_NUM"));
            test.setNo(rs.getInt("NO"));
            test.setPoint(rs.getInt("POINT"));
            testResults.add(test);
        }

        st.close();
        connection.close();

        return testResults;
    }
}