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
            "SELECT STUDENT.ENT_YEAR, TEST.CLASS_NUM, TEST.STUDENT_NO, STUDENT.NAME AS STUDENT_NAME, " +
            "SUBJECT.NAME AS SUBJECT_NAME, TEST.NO, TEST.POINT " +
            "FROM TEST " +
            "JOIN STUDENT ON TEST.STUDENT_NO = STUDENT.NO " +
            "JOIN SUBJECT ON TEST.SUBJECT_CD = SUBJECT.CD AND TEST.SCHOOL_CD = SUBJECT.SCHOOL_CD " +
            "WHERE ENT_YEAR=? AND TEST.CLASS_NUM=? AND SUBJECT.NAME=?"
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
            info.setTestNo(rs.getInt("NO"));
            info.setPoint(rs.getInt("POINT"));
            list.add(info);
        }
        st.close();
        connection.close();
        return list;
    }
}
