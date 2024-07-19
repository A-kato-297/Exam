package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.Student;

public class StudentDao extends Dao {

    public List<Integer> getEntYears(String schoolCd) throws Exception {
        List<Integer> entYears = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement yearSt = con.prepareStatement("SELECT DISTINCT ENT_YEAR FROM STUDENT WHERE SCHOOL_CD = ?");
            yearSt.setString(1, schoolCd);
            ResultSet yearRs = yearSt.executeQuery();
            while (yearRs.next()) {
                entYears.add(yearRs.getInt("ENT_YEAR"));
            }
        } catch (SQLException e) {
            throw new Exception("学生入学年の取得中にエラーが発生しました", e);
        }
        return entYears;
    }

    public List<String> getClassNums(String schoolCd) throws Exception {
        List<String> classNums = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement classSt = con.prepareStatement("SELECT DISTINCT CLASS_NUM FROM STUDENT WHERE SCHOOL_CD = ?");
            classSt.setString(1, schoolCd);
            ResultSet classRs = classSt.executeQuery();
            while (classRs.next()) {
                classNums.add(classRs.getString("CLASS_NUM"));
            }
        } catch (SQLException e) {
            throw new Exception("クラス番号の取得中にエラーが発生しました", e);
        }
        return classNums;
    }

    public List<Student> get(String schoolCd, String entYear, String classNum, String isAttend) throws Exception {
        List<Student> student_list = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND FROM STUDENT WHERE SCHOOL_CD = ?");
        boolean filterByEntYear = entYear != null && !entYear.isEmpty();
        boolean filterByClassNum = classNum != null && !classNum.isEmpty();
        boolean filterByIsAttend = isAttend != null;

        if (filterByEntYear) {
            query.append(" AND ENT_YEAR = ?");
        }
        if (filterByClassNum) {
            query.append(" AND CLASS_NUM = ?");
        }
        if (filterByIsAttend) {
            query.append(" AND IS_ATTEND = TRUE");
        } else {
            query.append(" AND IS_ATTEND = FALSE");
        }

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(query.toString())) {
            st.setString(1, schoolCd);
            int index = 2;
            if (filterByEntYear) {
                st.setInt(index++, Integer.parseInt(entYear));
            }
            if (filterByClassNum) {
                st.setString(index++, classNum);
            }

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setClassNum(rs.getString("class_num"));
                student.setEntYear(rs.getInt("ent_year"));
                student.setIsAttend(rs.getBoolean("is_attend"));
                student_list.add(student);
            }
        } catch (SQLException e) {
            throw new Exception("学生リストの取得中にエラーが発生しました", e);
        }
        return student_list;
    }

    public String getSchoolCdByUserId(String userId) throws Exception {
        String schoolCd = null;
        try (Connection connection = getConnection()) {
            PreparedStatement st = connection.prepareStatement("SELECT SCHOOL_CD FROM TEACHER WHERE ID = ?");
            st.setString(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                schoolCd = rs.getString("SCHOOL_CD");
            }
        } catch (SQLException e) {
            throw new Exception("ユーザーIDによる学校コードの取得中にエラーが発生しました", e);
        }
        return schoolCd;
    }

    public List<ClassNum> getClassNumsBySchoolCd(String schoolCd) throws Exception {
        List<ClassNum> classNumList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement st = connection.prepareStatement("SELECT CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = ?");
            st.setString(1, schoolCd);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassNum classNum = new ClassNum();
                classNum.setClassNum(rs.getString("CLASS_NUM"));
                classNumList.add(classNum);
            }
        } catch (SQLException e) {
            throw new Exception("学校コードによるクラス番号の取得中にエラーが発生しました", e);
        }
        return classNumList;
    }

    public void save(int entYear, String studentNo, String studentName, String classNum) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT (ENT_YEAR, NO, NAME, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, TRUE, 'oom')")) {

            ps.setInt(1, entYear);
            ps.setString(2, studentNo);
            ps.setString(3, studentName);
            ps.setString(4, classNum);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("データベースへの学生データ挿入中にエラーが発生しました", e);
        }
    }

    public Student filter(String studentNo, String schoolCd) throws Exception {
        Student student = new Student();
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND FROM STUDENT WHERE NO = ? AND SCHOOL_CD = ?")) {
            st.setString(1, studentNo);
            st.setString(2, schoolCd);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                student.setNo(rs.getString("NO"));
                student.setName(rs.getString("NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setIsAttend(rs.getBoolean("IS_ATTEND"));
            }
        } catch (SQLException e) {
            throw new Exception("フィルタリング中にエラーが発生しました", e);
        }
        return student;
    }

    public List<String> getClassNumbers(String schoolCd) throws Exception {
        List<String> classNums = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement classSt = con.prepareStatement("SELECT CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = ?")) {
            classSt.setString(1, schoolCd);
            ResultSet classRs = classSt.executeQuery();
            while (classRs.next()) {
                classNums.add(classRs.getString("CLASS_NUM"));
            }
        } catch (SQLException e) {
            throw new Exception("クラス番号の取得中にエラーが発生しました", e);
        }
        return classNums;
    }

    // StudentUpdateExecuteAction.java
    public void update(String no, String name, String classNum, boolean isAttend, int entYear) throws Exception {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(
                "UPDATE STUDENT SET NAME = ?, CLASS_NUM = ?, IS_ATTEND = ? WHERE NO = ? AND ENT_YEAR = ?"
            );
            st.setString(1, name);
            st.setString(2, classNum);
            st.setBoolean(3, isAttend);
            st.setString(4, no);
            st.setInt(5, entYear);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("学生データの更新中にエラーが発生しました", e);
        }
    }

    public Student findByNo(String studentNo) throws Exception {
        Student student = null;

        Connection connection = getConnection();
        PreparedStatement st;
        st = connection.prepareStatement("SELECT NAME FROM STUDENT WHERE NO = ?");
        st.setString(1, studentNo);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            student = new Student();
            student.setNo(studentNo);
            student.setName(rs.getString("NAME"));
        }

        st.close();
        connection.close();

        return student;
    }
}
