package bean;

import java.io.Serializable;

public class Subject implements Serializable {

	private String cd;
	private String name;
	private String schoolCd;

	// 科目コード
    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    // 科目名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 学校コード
    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}