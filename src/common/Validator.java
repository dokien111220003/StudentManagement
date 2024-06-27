/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Validator {

    public static boolean isEmpty(JTextField txtField, StringBuilder str, String msg) {
        String strField = txtField.getText().trim();
        //cach khoang trang 2 dau
        if (strField.equals("")) {
            str.append(msg).append("\n");
            txtField.setBackground(Color.red);
            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }


}
