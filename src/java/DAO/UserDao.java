/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aver
 */
public class UserDao extends DBContext {

    MD5 md5 = new MD5();

    public int updateUser(int role, int userId) {
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [roleID] = ?\n"
                    + "WHERE [Users].userId =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, role);
            stm.setInt(2, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int deleteUser(int proId) {
        try {
            String sql = "DELETE FROM [dbo].[Users] \n"
                    + "      WHERE userid = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, proId);
            stm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public User getUserByID(int Id) {
        try {
            String sql = "select * from Users \n"
                    + "where userId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, Id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User fl = new User();
                fl.setId(rs.getInt("userId"));
                fl.setFullname(rs.getString("fullName"));
                fl.setPhone(rs.getString("phone"));
                fl.setAddress(rs.getString("addresss"));
                fl.setGender(rs.getBoolean("gender"));
                fl.setRole(rs.getInt("roleID"));
                return fl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    public User findUser(String email, String password) {
        try {
            String sql = "select * from [Users] where [email] = ? and [userPass] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            String pass = md5.getMd5(password);
            stm.setString(1, email);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("userId"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("userPass"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("addresss"));
                s.setRole(rs.getInt("roleID"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int userId, String password) {
        try {
            String sql = "select * from [Users] where [userId] = ? and [userPass] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            String pass = md5.getMd5(password);
            stm.setInt(1, userId);
            stm.setString(2, md5.getMd5(pass));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("userId"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("Email"));
                s.setPassword(rs.getString("userPass"));
                s.setGender(rs.getBoolean("Gender"));
                s.setPhone(rs.getString("Phone"));
                s.setAddress(rs.getString("Address"));
                s.setRole(rs.getInt("roleID"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    public User findUser(int userId) {
        try {
            String sql = "select * from [Users] where [userId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("userId"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("userPass"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("addresss"));
                s.setRole(rs.getInt("roleID"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int register(String fullname, String email, String password,
            boolean gender, String phone, String address, int role) {
        String pass = md5.getMd5(password);
        try {
            String sql = "INSERT INTO [dbo].[Users] VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, fullname);
            stm.setString(2, email);
            stm.setString(3, pass);
            stm.setBoolean(4, gender);
            stm.setString(5, phone);
            stm.setString(6, address);
            stm.setInt(7, 1);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
    public int updateUser(String password, String email) {
        String pass = md5.getMd5(password);
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [userPass] = ?\n"
                    + "WHERE [Users].email =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, pass);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int updateUser(String password, int uid) {
        String pass = md5.getMd5(password);
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [userPass] = ?\n"
                    + "WHERE [Users].userId =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, pass);
            stm.setInt(2, uid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int updateUser(String name, int gender, String phone, String address, int userId) {
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [fullName] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[phone] = ?\n"
                    + "      ,[addresss] = ?\n"
                    + "WHERE [Users].userId =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, name);
            stm.setInt(2, gender);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.setInt(5, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int totalUser() {
        try {
            String sql = "select count([userId]) as count from [users] ";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<User> getUserByCondition() {
        List<User> user = new ArrayList<>();
        try {
            String sql = "select * from Users\n";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User fl = new User();
                fl.setId(rs.getInt("userId"));
                fl.setFullname(rs.getString("fullName"));
                fl.setGender(rs.getBoolean("gender"));
                fl.setPhone(rs.getString("phone"));
                fl.setAddress(rs.getString("addresss"));
                fl.setRole(rs.getInt("roleID"));
                user.add(fl);
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(productDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        UserDao us = new UserDao();
//        us.register("test", "admin@gmail.com", "123", true, "123", "ĐÀ NẴng", 2) ;
        System.out.println(us.getUserByID(8));
    }
    public User findUser(String email) {
        try {
            String sql = "select * from [Users] where [email] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("userId"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("userPass"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("addresss"));
                s.setRole(rs.getInt("roleID"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User checkUserExistByFullNameAndEmail(String fullname, String email) {
        try {
            String sql = "select * from Users where [fullName]=? and [email]=?";
            PreparedStatement stm = connection.prepareCall(sql);      
            stm.setString(1, fullname);
            stm.setString(2, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("userId"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("userPass"));
                s.setGender(rs.getBoolean("gender"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("addresss"));
                s.setRole(rs.getInt("roleID"));
                return s;    
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
