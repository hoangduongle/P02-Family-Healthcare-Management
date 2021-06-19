/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RegistrationDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class FileDAO {

    // RegistrationData.txt
    public static Vector<RegistrationDTO> readFile() {
        Vector<RegistrationDTO> Rlist = new Vector<>();
        String filename = "RegistrationData.txt";
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] a = s.split(";");
                if (a.length > 0) {
                    RegistrationDTO obj = new RegistrationDTO(a[0], a[1], Integer.parseInt(a[2]), Boolean.parseBoolean(a[3]), a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]));
                    Rlist.add(obj);
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Rlist;

    }

    public static void writeFile(Vector<RegistrationDTO> Rlist) {
        String filename = "RegistrationData.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(filename);
            for (RegistrationDTO r : Rlist) {
                pw.print(r.getRegistrationID() + ";");
                pw.print(r.getFullName() + ";");
                pw.print(r.getAge() + ";");
                pw.print(r.isGender() + ";");
                pw.print(r.getEmail() + ";");
                pw.print(r.getPhone() + ";");
                pw.print(r.getAddress() + ";");
                pw.print(r.getNumberOfMember() + ";");
                pw.print(r.getNumberOfChildren() + ";");
                pw.println(r.getNumberOfAdults());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
