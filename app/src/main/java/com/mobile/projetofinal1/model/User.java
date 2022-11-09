package com.mobile.projetofinal1.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String userLogin;
    private String password;

    private static List<User> users;

    //construtor padrão
    public User(){

    }
    //construtor sobrecarregado
    public User(int id, String name, String userLogin, String password) {
        this.id = id;
        this.name = name;
        this.userLogin = userLogin;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
