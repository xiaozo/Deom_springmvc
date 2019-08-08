package model;

import validator.Sex;

import javax.validation.constraints.Size;

public class User {


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String userName;


    String password;

    @Sex(message="{user.sex.size}",min = 1)
    String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
