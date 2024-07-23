package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDao extends Dao {

    public List<Integer> getEntYears() throws Exception {
        List<Integer> entYears = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT");
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
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT CLASS_NUM FROM STUDENT");
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
}
