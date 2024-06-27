/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

import database.DatabaseHelper;
import java.sql.Connection;
import models.Student;

/**
 *
 * @author admin
 */
public class TestDB {
    public static void main(String[] args) {
        Connection conn  = DatabaseHelper.getDBConnect();
        StudentDAO dao = new StudentDAO();
        if(conn != null) {
            System.out.println("Connect thanh cong");
//            Student st2 = new Student("SV106");
//            Student st1 = new Student("SV103", "Phan qn", "quan@gmail.com", "113", "HL", true);
//            dao.delete(st2);
            for(Student st : dao.getAll()) {
                System.out.println(st.toString());
            }
            Student find = dao.findStudentByID("SV111");
            if(find != null) {
                System.out.println("tim thay");
                System.out.println(find.toString());
            }
        } else {
            System.out.println("Connect that bai");
        }
    }
}
