package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;
import com.example.user.guruforstudent.testUser;
import com.example.user.guruforstudent.userRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.example.user.guruforstudent.Models.User.ps;

/**
 * Created by USER on 8/29/2018.
 */

public class Student {
    String nic;
    String phone;
    String school;
    int age;
    String olidex;
    String alindex;
    int pos;
    static Connection con = null;
    public Student(){
        con = MyConnection.getconnection();
    }
    public static PreparedStatement StReg(String nic, String phone, String school, int age, String olindex,String alindex)  {
        con = MyConnection.getconnection();
        String query = "INSERT INTO `students`( `nic`, `phone`, `school`, `age`, `olindex`, `alindex`, `user_id`) VALUES (?,?,?,?,?,?,?)";
       // userRegister u = new userRegister();
       // List<Integer> lastId = u.getAllStPos();
        // int pos = lastId.get(lastId.size()-1);
        int pos = getAllStPos();
        System.out.println("----------------------------------------------------------------------------"+pos);

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nic);
            ps.setString(2, phone);
            ps.setString(3, school);
            ps.setInt(4, age);
            ps.setString(5, olindex);
            ps.setString(6, alindex);
            ps.setInt(7,pos);
            //con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return ps;
    }

   /* public int performKeys(String Query) {
        PreparedStatement pstmt;
        int key = 0;
        try {
            pstmt = con.prepareStatement(Query, Statement.RETURN_GENERATED_KEYS);

            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();

            keys.next();
            key = keys.getInt(1);
            keys.close();
            pstmt.close();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        return key;
    } */
   public static int getAllStPos() {
       int posi =0;
       PreparedStatement ps1 = userRegister.getps();
//       testUser.passValue();
//       PreparedStatement ps1 = testUser.getTestps();




       try {
           if (ps1.executeUpdate() > 0) {

               ResultSet rs = ps1.getGeneratedKeys();

               if (rs.next()) {
                   posi = rs.getInt(1);
                   //lastid.add(pos);
               }
               //con.close();

           }
       } catch (SQLException e) {
           System.out.print(e.getMessage());
       }

       return posi;

   }
    public static void conClose(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





