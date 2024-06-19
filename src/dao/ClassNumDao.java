package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassNumDao extends Dao {

	public List<String> filter(String school) throws Exception {
		// リストを初期化
		List<String> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// SQL文の条件
		PreparedStatement st;
		st=connection.prepareStatement(
			"select class_num from teacher where school_cd=?");
		st.setString(1, school);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			String classNum = rs.getString("class_num");
            list.add(classNum);
		}

		st.close();
		connection.close();

		return list;
	}
}
