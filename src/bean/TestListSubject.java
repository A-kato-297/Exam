package bean;

import java.io.Serializable;
import java.util.List;

public class TestListSubject implements Serializable {
    private String subjectCd;    // 科目コード
    private String subjectName;  // 科目名
    private List<Test> testResults;  // テスト結果のリスト

    // 科目コード
    public String getSubjectCd() {
        return subjectCd;
    }

    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    // 科目名
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // テスト結果のリスト
    public List<Test> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<Test> testResults) {
        this.testResults = testResults;
    }
}