package com.project.coding101.my;


public class User {

    public String username;
    public String email;
    public String nickname;
    public String collagenum;
    public String tel;

    public User(){}

    public User(String username, String email,String nickname,
                String collagenum,String tel){
        this.username = username;
        this.nickname = nickname;
        this.email    = email;
        this.collagenum = collagenum;
        this.tel = tel;

    }

}
