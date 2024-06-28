package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;

public class SubjectDao extends Dao {

	// 科目の一覧を取得するメソッド
	public Subject get(String cd, String school) throws Exception {
		Subject subject = null;

		Connection connection = getConnection();

		PreparedStatement st;
		st = connection.prepareStatement(
			"SELECT * FROM SUBJECT"
		);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			subject = new Subject();
			subject.setCd(rs.getString("cd"));
			subject.setName(rs.getString("name"));
			subject.setSchoolCd(rs.getString("schoolCd"));
		}

		st.close();
		connection.close();

		return subject;
	}

	// 科目を登録するメソッド
	public void save(Subject subject) throws Exception {
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"INSERT INTO SUBJECT VALUES('oom', ?, ?)");
		st.setString(1, subject.getCd());
		st.setString(2, subject.getName());
		st.executeUpdate();

		st.close();
		con.close();
	}

	// 科目を削除するメソッド
    public void delete(String cd) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("DELETE FROM SUBJECT WHERE CD = ?")) {
            st.setString(1, cd);
            st.executeUpdate();
        }
    }
}