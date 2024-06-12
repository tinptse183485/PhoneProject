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
public class UserError {

    private String userID;
    private String fullName;
    private String roleId;
    private String password;
    private String confirm;
     private String mail;
      private String phone;

    public UserError() {
        this.userID = "";
        this.fullName = "";
        this.roleId= "";
        this.password = "";
        this.confirm = "";
        this.mail = "";
        this.phone = "";
    }

    public UserError(String userID, String fullName, String roleId, String password, String confirm, String mail, String phone) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
        this.confirm = confirm;
        this.mail = mail;
        this.phone = phone;
    }



    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
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

}
