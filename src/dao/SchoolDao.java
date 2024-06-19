package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SchoolDao extends Dao {

    // getメソッド：指定された学校コードに対応する学校コードを取得する
    public String get(String schoolCd) throws Exception {
        // 取得する学校コードを初期化（初期値は引数の学校コード）
        String resultSchoolCd = null;

        // データベースへのコネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメントを初期化
        PreparedStatement st = null;
        // リザルトセットを初期化
        ResultSet rs = null;

        try {
            // SQL文の準備
            st = connection.prepareStatement("select school_cd from school where school_cd = ?");
            // プリペアードステートメントに学校コードをバインド
            st.setString(1, schoolCd);
            // プリペアードステートメントを実行
            rs = st.executeQuery();

            // 結果セットから学校コードを取得
            if (rs.next()) {
                // 結果が存在する場合、取得した学校コードを返す
                resultSchoolCd = rs.getString("school_cd");
            }
        } catch (Exception e) {
            // 例外が発生した場合は再スロー
            throw e;
        } finally {
            // リソースをクローズしてリソースリークを防ぐ
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (connection != null) connection.close();
        }

        // 取得した学校コードを返す
        return resultSchoolCd;
    }
}
