package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListSubject;

public class TestListSubjectDao extends Dao {

    public List<TestListSubject> filter(int entYear, String classNum, String subjectName) throws Exception {
        List<TestListSubject> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(
            "SELECT STUDENT.ENT_YEAR, STUDENT.CLASS_NUM, SUBJECT.NAME AS SUBJECT_NAME, TEST.STUDENT_NO, STUDENT.NAME AS STUDENT_NAME, " +
            "COALESCE(CASE WHEN CAST(TEST.NO AS CHAR) = '1' THEN CAST(TEST.POINT AS CHAR) ELSE '-' END, '-' ) AS FIRST_TEST_NO, " +
            "COALESCE(CASE WHEN CAST(TEST.NO AS CHAR) = '2' THEN CAST(TEST.POINT AS CHAR) ELSE '-' END, '-' ) AS SECOND_TEST_NO " +
            "FROM STUDENT " +
            "JOIN TEST ON STUDENT.NO = TEST.STUDENT_NO " +
            "JOIN SUBJECT ON TEST.SUBJECT_CD = SUBJECT.CD " +
            "WHERE TEST.SCHOOL_CD = STUDENT.SCHOOL_CD AND TEST.SCHOOL_CD = SUBJECT.SCHOOL_CD " +
            "AND STUDENT.ENT_YEAR=? AND TEST.CLASS_NUM=? AND SUBJECT.NAME=? " +
            "GROUP BY STUDENT.ENT_YEAR, STUDENT.CLASS_NUM, TEST.STUDENT_NO, STUDENT.NAME, SUBJECT.NAME "
        );
        st.setInt(1, entYear);
        st.setString(2, classNum);
        st.setString(3, subjectName);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            TestListSubject info = new TestListSubject();
            info.setEntYear(rs.getInt("ENT_YEAR"));
            info.setClassNum(rs.getString("CLASS_NUM"));
            info.setStudentNo(rs.getString("STUDENT_NO"));
            info.setStudentName(rs.getString("STUDENT_NAME"));
            info.setSubjectName(rs.getString("SUBJECT_NAME"));
            info.setFirstTestNo(rs.getString("FIRST_TEST_NO"));
            info.setSecondTestNo(rs.getString("SECOND_TEST_NO"));
            list.add(info);
        }
        st.close();
        connection.close();
        return list;
    }
}