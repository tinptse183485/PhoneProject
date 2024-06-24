/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author hd
 */
public class UserDTO {
    private String userID;
    private String userName;
    private String role;
    private String password;
    private String mail;
    private String phone;
    private String address;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String role, String password, String mail, String phone, String address) {
        this.userID = userID;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }

   
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
}
