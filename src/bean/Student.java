package bean;

import java.io.Serializable;

public class Student implements Serializable {

    private String no;		// 学籍番号
    private String name;	// 名前
    private int entYear;	// 入学年度
    private String classNum;	// クラス番号
    private Boolean isAttend;	// 在学中フラグ
    private String schoolCd;	// 学校コード

    // 学籍番号
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // 名前
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // 在学中フラグ
    public boolean getAttend() {
        return isAttend;
    }

    public void setAttend(Boolean isAttend) {
        this.isAttend = isAttend;
    }

    // 学校コード
    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchool(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}
