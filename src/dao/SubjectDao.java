package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDao extends Dao {

	// 指定された学校コードに基づいて科目リストを取得するメソッド
    public List<Subject> get(String schoolCd) throws Exception {
        List<Subject> subjectList = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT CD, NAME FROM SUBJECT WHERE SCHOOL_CD = ?")) {
            st.setString(1, schoolCd);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setCd(rs.getString("CD"));
                    subject.setName(rs.getString("NAME"));
                    subjectList.add(subject);
                }
            }
        }
        return subjectList;
    }

	// 科目をCDで検索するメソッド
    public Subject filter(String cd) throws Exception {
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

	// 科目情報を更新するメソッド
    public void update(String cd, String newName) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("UPDATE SUBJECT SET NAME = ? WHERE CD = ?")) {
            st.setString(1, newName);
            st.setString(2, cd);
            st.executeUpdate();
        }
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