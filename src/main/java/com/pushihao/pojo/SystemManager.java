package com.pushihao.pojo;

public class SystemManager {
    private int _id;
    private int _role;
    private String email;
    private String password;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_role() {
        return _role;
    }

    public void set_role(int _role) {
        this._role = _role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
