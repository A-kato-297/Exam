package bean;

import java.io.Serializable;

public class ClassNum implements Serializable {

    private String schoolCd;		// 学校コード
    private String classNum;	// 学校名

    // 学校コード
    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }

    // 学校名
    public String getclassNum() {
        return classNum;
    }

    public void setclassNum(String classNum) {
        this.classNum = classNum;
    }
}