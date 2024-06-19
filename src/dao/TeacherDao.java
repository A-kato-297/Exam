package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDao extends Dao {

	public Teacher get(String id) throws Exception {
		Teacher Teacher = new Teacher();
		return Teacher;
	}

	public Teacher search(String id, String password) throws Exception {
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
		}

		st.close();
		connection.close();

		return Teacher;
	}
}
