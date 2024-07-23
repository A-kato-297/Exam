package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListStudent;

public class TestListStudentDao extends Dao {

    public List<TestListStudent> filter(String studentNo) throws Exception {
        List<TestListStudent> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(
            "SELECT STUDENT.NAME AS STUDENT_NAME, SUBJECT.NAME AS SUBJECT_NAME, TEST.SUBJECT_CD, TEST.NO, TEST.POINT " +
            "FROM TEST " +
            "JOIN SUBJECT ON TEST.SUBJECT_CD = SUBJECT.CD AND TEST.SCHOOL_CD = SUBJECT.SCHOOL_CD " +
            "JOIN STUDENT ON TEST.STUDENT_NO = STUDENT.NO " +
            "WHERE TEST.STUDENT_NO=?"
        );
        st.setString(1, studentNo);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	TestListStudent info = new TestListStudent();
            info.setStudentName(rs.getString("STUDENT_NAME"));
            info.setSubjectName(rs.getString("SUBJECT_NAME"));
            info.setSubjectCd(rs.getString("SUBJECT_CD"));
            info.setTestNo(rs.getInt("NO"));
            info.setPoint(rs.getInt("POINT"));
            list.add(info);
        }
        st.close();
        connection.close();
        return list;
    }
}
