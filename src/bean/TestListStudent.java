package bean;

import java.io.Serializable;
import java.util.List;

public class TestListStudent implements Serializable {
    private String studentName;  // 学生名
    private String studentNo;    // 学生番号
    private List<Test> testResults;  // テスト結果のリスト

    // 学生名
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // 学生番号
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    // テスト結果のリスト
    public List<Test> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<Test> testResults) {
        this.testResults = testResults;
    }
}