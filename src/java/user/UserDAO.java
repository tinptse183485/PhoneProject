/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


/**
 *
 * @author ASUS
 */
public class UserDAO {

    private static final String LOGIN = "SELECT userName,role,mail,phone FROM tblUser WHERE userId=? AND password=? ";
    private static final String SEARCH = "SELECT userId, userName, role,mail,phone FROM tblUser WHERE userName like ?";
    private static final String DELETE = "DELETE tblUser WHERE userId=?";
    private static final String UPDATE = "UPDATE tblUser SET userName=?, role=?, mail=?, phone=? WHERE userId=?";
    private static final String CHECK_DUPLICATE = "SELECT userId FROM tbl_User WHERE userId=?  ";
    private static final String INSERT = "INSERT INTO tblUser (userId, userName, role, password,mail,phone) "
            + "                         VALUES(?,?,?,?,?,?)";

    public UserDTO checkLogin(String userId, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
               
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userId);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    
                    String userName = rs.getString("userName");
                    String role = rs.getString("role");
                    String mail = rs.getString("mail");
                    String phone = rs.getString("phone");
                    user = new UserDTO(userId, userName, role, "***", mail, phone);            
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;

    }
     public boolean insertV2(UserDTO user) throws ClassNotFoundException, SQLException {
        boolean checkInsert= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getUserName());
                ptm.setString(3, user.getRole());
                ptm.setString(4, user.getPassword());
                ptm.setString(5, user.getMail());
                ptm.setString(6, user.getPhone());
                checkInsert= ptm.executeUpdate()>0?true:false;
            }
        } finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
         
        return checkInsert;
    }
     
     public boolean checkDuplicate(String userId) throws SQLException {
        boolean check= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                System.out.println("1");
                ptm= conn.prepareStatement(CHECK_DUPLICATE);
                
                ptm.setString(1, userId);
                rs= ptm.executeQuery();
                if(rs.next()){
                    check= true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        
        return check;
    }
     public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs= ptm.executeQuery();
                while(rs.next()){
                    String userId= rs.getString("userId");
                    String userName= rs.getString("userName");
                    String role= rs.getString("role");
                    String password= "***";
                    String mail= rs.getString("mail");
                    String phone= rs.getString("phone");
                    list.add(new UserDTO(userId, userName, role, password, mail, phone));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return list;
    }
      public boolean delete(String userId) throws SQLException {
        boolean checkDelete= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(DELETE);
                ptm.setString(1, userId);
                checkDelete= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return checkDelete;
    }
       public boolean update(UserDTO user) throws SQLException {
        boolean checkUpdate= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getUserName());
                ptm.setString(2, user.getRole());
                ptm.setString(3, user.getMail());
                ptm.setString(4, user.getPhone());
                ptm.setString(5, user.getUserID());
                
                checkUpdate= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return checkUpdate;
    }

}

   