package bean;

import java.io.Serializable;

public class Test implements Serializable {
    private String studentNo;
    private int entYear;
    private String classNum;
    private String subjectCd;
    private int no;
    private int point;
    private String name;  // 新しいフィールドを追加

    // 学籍番号
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    // 入学年度
    public int getEntYear() {
        return entYear;
    }

    public void setEntYear(int entYear) {
        this.entYear = entYear;
    }

    // クラス番号
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    // 科目コード
    public String getSubjectCd() {
        return subjectCd;
    }

    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    // 回数
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    // 点数
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // 名前
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}