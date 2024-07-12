package scoremanager.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import tool.Action;

public class PreTestRegistAction extends Action {
	private static final Logger logger = Logger.getLogger(TestRegistAction.class.getName());

    // executeメソッド: 初回リクエストを処理し、ドロップダウンリスト用のデータを取得
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        Dao dao = new Dao();
        Connection connection = dao.getConnection();

        // ユーザーIDから学校コードを取得
        String schoolCd = getSchoolCdById(userId, connection);
        logger.info("School Code: " + schoolCd);

        // 入学年度、クラス、科目、テスト番号のリストを取得
        List<Integer> entYears = getEntYears(schoolCd, connection);
        List<String> classNums = getClassNums(schoolCd, connection);
        List<String> subjects = getSubjects(schoolCd, connection);
        List<Integer> testNos = getTestNos(schoolCd, connection);

        logger.info("Ent Years: " + entYears.toString());
        logger.info("Class Numbers: " + classNums.toString());
        logger.info("Subjects: " + subjects.toString());
        logger.info("Test Numbers: " + testNos.toString());

        // 取得したリストをリクエストにセット
        request.setAttribute("entYears", entYears);
        request.setAttribute("classNums", classNums);
        request.setAttribute("subjects", subjects);
        request.setAttribute("testNos", testNos);

        connection.close();
        request.getRequestDispatcher("test_regist2.jsp").forward(request, response);
    }

    // setRequestDataメソッド: 検索クエリを処理し、フィルタリングされた結果を取得
    public void setRequestData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        // フォームからの入力パラメータを取得
        String entYear = request.getParameter("entYear");
        String classNum = request.getParameter("classNum");
        String subject = request.getParameter("subject");
        String testNo = request.getParameter("testNo");

        System.out.println("Selected Ent Year: " + entYear);
        System.out.println("Selected Class Num: " + classNum);
        System.out.println("Selected Subject: " + subject);
        System.out.println("Selected Test No: " + testNo);

        Dao dao = new Dao();
        Connection connection = dao.getConnection();

        // ユーザーIDから学校コードを取得
        String schoolCd = getSchoolCdById(userId, connection);

        // 検索条件に基づいて成績データを取得
        List<Result> results = getTestResults(schoolCd, entYear, classNum, subject, testNo, connection);

        // 検索結果をリクエストにセット
        request.setAttribute("entYear", entYear);
        request.setAttribute("classNum", classNum);
        request.setAttribute("results", results);

        connection.close();
        request.getRequestDispatcher("test_regist2.jsp").forward(request, response);
    }

    // ユーザーIDから学校コードを取得
    private String getSchoolCdById(String userId, Connection connection) throws Exception {
        String schoolCd = null;
        PreparedStatement st = connection.prepareStatement("SELECT SCHOOL_CD FROM TEACHER WHERE ID = ?");
        st.setString(1, userId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            schoolCd = rs.getString("SCHOOL_CD");
        }
        rs.close();
        st.close();
        return schoolCd;
    }

    // 学校コードに基づいて入学年度のリストを取得
    private List<Integer> getEntYears(String schoolCd, Connection connection) throws Exception {
        List<Integer> entYears = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            entYears.add(rs.getInt("ENT_YEAR"));
        }
        rs.close();
        st.close();
        return entYears;
    }

    // 学校コードに基づいてクラス番号のリストを取得
    private List<String> getClassNums(String schoolCd, Connection connection) throws Exception {
        List<String> classNums = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            classNums.add(rs.getString("CLASS_NUM"));
        }
        rs.close();
        st.close();
        return classNums;
    }

    // 学校コードに基づいて科目のリストを取得
    private List<String> getSubjects(String schoolCd, Connection connection) throws Exception {
        List<String> subjects = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT NAME FROM SUBJECT WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            subjects.add(rs.getString("NAME"));
        }
        rs.close();
        st.close();
        return subjects;
    }

    // 学校コードに基づいてテスト番号のリストを取得
    private List<Integer> getTestNos(String schoolCd, Connection connection) throws Exception {
        List<Integer> testNos = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement("SELECT DISTINCT NO FROM TEST WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            testNos.add(rs.getInt("NO"));
        }
        rs.close();
        st.close();
        return testNos;
    }

    // 条件に一致する成績データを取得
    private List<Result> getTestResults(String schoolCd, String entYear, String classNum, String subject, String testNo, Connection connection) throws Exception {
        List<Result> results = new ArrayList<>();
        PreparedStatement st = connection.prepareStatement(
                "SELECT t.STUDENT_NO, s.NAME, t.POINT " +
                "FROM TEST t JOIN STUDENT s ON t.STUDENT_NO = s.NO " +
                "WHERE t.SCHOOL_CD = ? AND s.ENT_YEAR = ? AND t.CLASS_NUM = ? AND t.SUBJECT_CD = ? AND t.NO = ?");
        st.setString(1, schoolCd);
        st.setString(2, entYear);
        st.setString(3, classNum);
        st.setString(4, subject);
        st.setString(5, testNo);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Result result = new Result();
            result.setStudentNo(rs.getString("STUDENT_NO"));
            result.setName(rs.getString("NAME"));
            result.setPoint(rs.getInt("POINT"));
            results.add(result);
        }
        rs.close();
        st.close();
        return results;
    }

    // 結果クラス
    public class Result {
        private String studentNo;
        private String name;
        private int point;

        // ゲッターとセッター
        public String getStudentNo() {
            return studentNo;
        }

        public void setStudentNo(String studentNo) {
            this.studentNo = studentNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }
}