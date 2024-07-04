package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;


public class TestListStudentDao extends Dao {
	private String baseSql = "select * from test where student_cd=?";

	private List<TestListStudent> postFilter(ResultSet rSet) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				TestListStudent testListStudent = new TestListStudent();

				testListStudent.setSubjectName(rSet.getString("subject_name"));
				testListStudent.setSubjectCd(rSet.getString("subject_cd"));
				testListStudent.setNum(rSet.getInt("num"));
				testListStudent.setPoint(rSet.getInt("point"));

				list.add(testListStudent);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}

		return list;

	}

	public List<TestListStudent> filter(Student student) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
	}
}