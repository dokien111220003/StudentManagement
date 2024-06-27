/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserDAO {
    List<User> ls = new ArrayList<>();
    
    public UserDAO() {
        ls.add(new User("admin", "123456", true));
        ls.add(new User("admin2", "123456", true));
        ls.add(new User("kiendeptrai", "123456", true));
        ls.add(new User("kiencubu", "123456", true));
        ls.add(new User("hoangtucubu", "123456", true));
        ls.add(new User("20cm", "123456", true));
    }
    public boolean checkLogin(String username, String pass) {
        for(User u : ls) {
            if(u.getUsername().equals(username) 
                    && u.getPassword().equals(pass)){
                return true;
            }
        }
        return false;   
    }
}
