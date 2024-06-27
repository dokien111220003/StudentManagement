    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;
import java.sql.Connection;
import database.DatabaseHelper;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Student;
/**
 *
 * @author admin
 */
public class StudentDAO {
    Connection conn = null;//phien giua java va db
    PreparedStatement sttm = null;//truy van tham so
    public int add(Student st) {
        try {
            String sSQL = "insert Students(MaSV,Hoten,Email,SoDT,DiaChi,GioiTinh) "
                    + "values(?,?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, st.getMaSv());
            sttm.setString(2, st.getHoTen());
            sttm.setString(3, st.getEmail());
            sttm.setString(4, st.getSoDT());
            sttm.setString(5, st.getDiaChi());
            sttm.setBoolean(6, st.isGioiTinh());
            if(sttm.executeUpdate()>0) {// neu so dong tac dong > 0 thi thoa man dk
                System.out.println("Insert thanh cong");
                return 1;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        return -1;
    }
    public int update(Student st) {
        try {
            String sSQL = "update Students set HoTen = ?, Email = ?, SoDT=?, DiaChi=?,GioiTinh=? "
                    + "where MaSv=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(6, st.getMaSv());
            sttm.setString(1, st.getHoTen());
            sttm.setString(2, st.getEmail());
            sttm.setString(3, st.getSoDT());
            sttm.setString(4, st.getDiaChi());
            sttm.setBoolean(5, st.isGioiTinh());
            if(sttm.executeUpdate()>0) {
                System.out.println("Update thanh cong");
                return 1;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return -1;
    }
    public int delete(String maSV) {
        try {
            String sSQL = "delete Students where MaSv =?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            if(sttm.executeUpdate()>0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return -1;
    }
    public List<Student> getAll() {
        List<Student> ls = new ArrayList<>();
        ResultSet rs = null;//bang data the hien ket qua tu DB thong qua sSQL
        Statement sttm = null;
        try {
            String sSQL = "select * from students";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()) {
                Student st = new Student();
                st.setMaSv(rs.getString(1));
                st.setHoTen(rs.getString(2));
                st.setEmail(rs.getString(3));
                st.setSoDT(rs.getString(4));
                st.setDiaChi(rs.getString(5));
                st.setGioiTinh(rs.getBoolean(6));
                ls.add(st);
            }
//            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        return ls;
    }
    public Student findStudentByID(String maSV) {
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "select * from stude  nts where MaSv ='" + maSV+ "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()) {
                Student st = new Student();
                st.setMaSv(rs.getString(1));
                st.setHoTen(rs.getString(2));
                st.setEmail(rs.getString(3));
                st.setSoDT(rs.getString(4));
                st.setDiaChi(rs.getString(5));
                st.setGioiTinh(rs.getBoolean(6));
//                conn.close();
                return st;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }
    
    public List<Student> findStudentByName(String name) {
        ResultSet rs = null;
        Statement sttm = null;
        List<Student> ls = new ArrayList<>();
        try {
            String sSQL = "select * from students where HoTen like '%" + name + "%'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while(rs.next()) {
                Student st = new Student();
                st.setMaSv(rs.getString(1));
                st.setHoTen(rs.getString(2));
                st.setEmail(rs.getString(3));
                st.setSoDT(rs.getString(4));
                st.setDiaChi(rs.getString(5));
                st.setGioiTinh(rs.getBoolean(6));
                ls.add(st);
//                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return ls;
    }
}
