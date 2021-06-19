/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validata;

import DTO.RegistrationDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Valid {

    public static boolean checkID(String RegistrationID) {
        if (!RegistrationID.matches("[a-zA-Z0-9 ]+") && RegistrationID.length() <= 10) {
            JOptionPane.showMessageDialog(null, "ID invalid");
            return false;
        }
        return true;
    }

    public static boolean checkFullName(String Fullname) {
        if (!Fullname.matches("[a-zA-Z ]+{2,50}")) {
            JOptionPane.showMessageDialog(null, "Name must be Character and length <=50");
            return false;
        }
        return true;
    }

    public static boolean checkString(String Fullname) {
        if (!Fullname.matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(null, "Address Error!!");
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String Email) {
        if (!Email.matches("[a-zA-Z0-9]{5,20}[\\@]{1}[a-zA-Z\\.]{2,15}")) {
            JOptionPane.showMessageDialog(null, "Email invalid");
            return false;
        }
        return true;
    }

    public static boolean checkPhone(String Phone) {
        if (!Phone.matches("[0-9]+{10,15}")) {
            JOptionPane.showMessageDialog(null, "Phone must be a Number and length from 10 to 15");
            return false;
        }
        return true;
    }

    public static boolean checkNO(String NO) {
        if (!NO.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Number must >=0");
            return false;
        }
        return true;
    }

    public static boolean checkage(String age) {
        if (Integer.parseInt(age) <= 100) {
            JOptionPane.showMessageDialog(null, "Number must >=0");
            return false;
        }
        return true;
    }
}
