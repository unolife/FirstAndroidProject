package com.project.coding101.my;

public class User {

    public String username;
    public String email;
    public String nickname;
    public int collagenum;
    public int tel;

    public User(){}

    public User(String username, String email,String nickname,
                int collagenum,int tel){
        this.username = username;
        this.nickname = nickname;
        this.email    = email;
        this.collagenum = collagenum;
        this.tel = tel;

    }
}
