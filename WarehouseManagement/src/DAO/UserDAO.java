/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONFIG.JDBCUtil;
import MODEL.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robot
 */
public class UserDAO implements DAOinterface<User>{
    
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    @Override
    public int insert(User t) {
        int result = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO `user`(`email`, `hoten`, `matkhau`, `trangthai`, `makhohang`, `manhomquyen`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getEmail());
            pst.setString(2, t.getHoten());
            pst.setString(3, t.getMatkhau());
            pst.setInt(4, t.getTrangthai());
            pst.setString(5, t.getMakhohang());
            pst.setString(6, t.getManhomquyen());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(User t) {
          int result = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE `user` SET `email`='?',`hoten`='?',`matkhau`='?',`trangthai`='?',`makhohang`='?',`manhomquyen`='?' WHERE ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getMatkhau());
            pst.setInt(3, t.getTrangthai());
            pst.setString(4, t.getMakhohang());
            pst.setString(5, t.getManhomquyen());
            pst.setString(6, t.getEmail());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
         int result = 0 ;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "DELETE FROM user WHERE eamil = '?'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> result = new ArrayList<User>();
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "SELECT * FROM user";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String email = rs.getString("email");
                String hoten = rs.getString("hoten");
                String matkhau = rs.getString("matkhau");
                int trangthai = rs.getInt("trangthai");
                String makhohang = rs.getString("makhohang");
                String manhomquyen = rs.getString("manhomquyen");
                
                User us = new User(email, hoten, matkhau, trangthai, makhohang, manhomquyen);
                result.add(us);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public User selectById(String t) {
        User result = null;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "SELECT * FROM user WHERE email='?'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String email = rs.getString("email");
                String hoten = rs.getString("hoten");
                String matkhau = rs.getString("matkhau");
                int trangthai = rs.getInt("trangthai");
                String makhohang = rs.getString("makhohang");
                String manhomquyen = rs.getString("manhomquyen");
                
                result = new User(email, hoten, matkhau, trangthai, makhohang, manhomquyen);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
}
