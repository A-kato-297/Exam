package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDao extends Dao {

	// SCHOOL_CDをセッションで取得出来なかったため、ID経由で取得
    public String getSchoolCdById(String id) throws Exception {
        String schoolCd = null;

        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT SCHOOL_CD FROM TEACHER WHERE ID = ?");
        st.setString(1, id);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            schoolCd = rs.getString("SCHOOL_CD");
        } else {
        }

        st.close();
        connection.close();

        return schoolCd;
    }

	public Teacher login(String id, String password) throws Exception {
		Teacher Teacher = null;

		Connection connection = getConnection();

		PreparedStatement st;
		st = connection.prepareStatement(
			"SELECT * FROM TEACHER WHERE ID = ? AND PASSWORD = ?"
		);
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			Teacher = new Teacher();
			Teacher.setId(rs.getString("id"));
			Teacher.setPassword(rs.getString("password"));
			Teacher.setName(rs.getString("name"));
			Teacher.setSchoolCd(rs.getString("school_cd"));
		}

		st.close();
		connection.close();

		return Teacher;
	}
}