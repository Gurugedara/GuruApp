package com.example.user.guruforstudent;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.guruforstudent.Controls.FileRW;
import com.example.user.guruforstudent.Models.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Login extends AppCompatActivity {

    //Connection con = null;
    PreparedStatement ps = null;
    Button tomain;
    Button userregpg;
    EditText username;
    EditText passwd;
    TextView tv;
    private static final String FILE_NAME = "test.txt";
   // User u = new User();
    public Login(){}

    @Override





    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        //con = MyConnection.getconnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tomain=(Button)findViewById(R.id.login);
        userregpg = (Button)findViewById(R.id.regBtn);
        username =(EditText)findViewById(R.id.txtUname);
        passwd =(EditText)findViewById(R.id.txtPasswd);


        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
             /*   String uname = username.getText().toString();
                String paswd = passwd.getText().toString();
                User u = new User();
                int test = u.UserLogin(uname,paswd);
                if(test == 1){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    openslctclsspg();

                }
                else if(test == 0){
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();

                }

                else if(test == 2){
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_LONG).show();
                }  */

             /*   try {

                    ps = con.prepareStatement("SELECT * FROM `users` WHERE `email`=? AND `password`=?");
                    ps.setString(1, uname);
                    ps.setString(2, paswd);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        System.out.print("Login Sucess");
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        FileRW rw = new FileRW("Entered");
                        rw.write();
                        openslctclsspg();


                    }
                    else{
                        System.out.print("Login fail");
                        Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();

                    }

                } catch (Exception e) {
                    System.out.print(e);
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_LONG).show();

                } */
            }
        });
        userregpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
               // openregpg();
            }
        });


    }
    public void openslctclsspg() {
        Intent intent = new Intent(this,ChooseInstitue.class);
        startActivity(intent);
    }
    public void openregpg() {
        Intent intent = new Intent(this,userRegister.class);
        startActivity(intent);
    }
    public void  save(){
        String text = username.getText().toString();
        FileOutputStream fos = null;


        try {
           fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            username.getText().clear();
            Toast.makeText(getApplicationContext(),"Save to "+getFilesDir(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        finally{
            if(fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String load(){
        FileInputStream fis = null;
        String val = "";
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            val = sb.toString();
            Toast.makeText(getApplicationContext(),val, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
     return val;

    }

}


