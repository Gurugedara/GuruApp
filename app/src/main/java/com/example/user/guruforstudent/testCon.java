package com.example.user.guruforstudent;

import com.example.user.guruforstudent.Controls.FileRW;

import java.io.IOException;

/**
 * Created by USER on 8/13/2018.
 */

public class testCon {
    public static void main(String [] args )  {
       MyConnection.getconnection();

       //String name = "Ravindu95";
       //String passwd = "12345";
       //User u = new User();
       //u.UserLogin(name,passwd);
        FileRW rw = new FileRW("Kushan Ravindu samaranayake");
        rw.write();
        rw.Read();
        //rw.clearTheFile();

    }
}
