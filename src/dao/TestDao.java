package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class TestDao extends Dao {

    public String getSchoolCdByUserId(String userId) throws Exception {
        String schoolCd = null;
        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT SCHOOL_CD FROM TEACHER WHERE ID = ?");
        st.setString(1, userId);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            schoolCd = rs.getString("SCHOOL_CD");
        }

        st.close();
        connection.close();

        return schoolCd;
    }

    public List<Student> getStudentsBySchoolCd(String schoolCd) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT DISTINCT NO, NAME, ENT_YEAR, CLASS_NUM FROM STUDENT WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Student student = new Student();
            student.setNo(rs.getString("NO"));
            student.setName(rs.getString("NAME"));
            student.setEntYear(rs.getInt("ENT_YEAR"));
            student.setClassNum(rs.getString("CLASS_NUM"));
            students.add(student);
        }

        st.close();
        connection.close();

        return students;
    }
}
