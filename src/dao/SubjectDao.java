package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;

public class SubjectDao extends Dao {

	// 科目をCDで検索するメソッド
    public Subject find(String cd) throws Exception {
        Subject subject = null;
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM SUBJECT WHERE CD = ?")) {
            st.setString(1, cd);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    subject = new Subject();
                    subject.setCd(rs.getString("CD"));
                    subject.setName(rs.getString("NAME"));
                    subject.setSchoolCd(rs.getString("SCHOOL_CD"));
                }
            }
        }
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