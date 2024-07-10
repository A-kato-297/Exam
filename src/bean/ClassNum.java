package bean;

import java.io.Serializable;

public class ClassNum implements Serializable {

    private String schoolCd;    // 学校コード
    private String classNum;    // クラス番号

    // 学校コード
    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }

    // クラス番号
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}