/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP VICTUS 16
 */
public class Koneksi {
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    public Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rental", dbuser, dbpasswd);
            stmt = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "JDBC Driver Error ", JOptionPane.WARNING_MESSAGE); 
        }
    }
    
    public ResultSet getData(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }

    public void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
