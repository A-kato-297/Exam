package bean;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String id;
    private String password;
    private String name;
    private String schoolCd;

    // ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // パスワード
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 名前
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

    public void setSchoolCd(String school) {
        this.schoolCd = schoolCd;
    }
}