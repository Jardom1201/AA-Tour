package com.example.aatour;

public class Users {
    private String Username,No_Telp,Password,Email;

    public Users() {
    }

    public Users(String username, String no_Telp, String password, String email) {
        Username = username;
        No_Telp = no_Telp;
        Password = password;
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNo_Telp() {
        return No_Telp;
    }

    public void setNo_Telp(String no_Telp) {
        No_Telp = no_Telp;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
