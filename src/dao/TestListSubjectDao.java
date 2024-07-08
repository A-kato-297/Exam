package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao {
	private String baseSql = "select * from test where subject_cd=?";

    // ResultSetからTestListSubjectオブジェクトのリストを作成するメソッド
	private List<TestListSubject> postFilter(ResultSet rSet) throws SQLException {
		List<TestListSubject> list = new ArrayList<>();
		try {
			// ResultSetの各行を処理
			while (rSet.next()) {
				TestListSubject testListSubject = new TestListSubject();
				// 各フィールドをResultSetから取得して設定
				testListSubject.setEntYear(rSet.getInt("ent_year"));
				testListSubject.setStudentNo(rSet.getString("student_no"));
				testListSubject.setStudentName(rSet.getString("student_name"));
				testListSubject.setClassNum(rSet.getString("class_num"));

				// ポイントの設定
				Map<Integer, Integer> points = new HashMap<>();
				points.put(rSet.getInt("subject_cd"), rSet.getInt("points"));
				testListSubject.setPoints(points);

				// リストに追加
				list.add(testListSubject);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return list;
	}

    // 指定されたフィルタ条件でTestListSubjectオブジェクトを取得するメソッド
	public List<TestListSubject> filter(int entYear, String classNum, Subject subject, School school)
			throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		String condition = "and ent_year=? and class_num=?";
		String order = "order by no asc";

		try {
			statement = connection.prepareStatement(baseSql + condition + order);
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
		}

	}
}
