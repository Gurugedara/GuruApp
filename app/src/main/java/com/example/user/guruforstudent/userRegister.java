package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.User;
import com.example.user.guruforstudent.StudentRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRegister extends AppCompatActivity {
    String query = StudentRegistration.query;
    //static int pos = 0;
    EditText fname;
    EditText lname;
    EditText uname;
    EditText passwd;
    EditText conpasswd;
    EditText email;
    Button regteacher;
    Button regstudent;
    Connection con = null;
    static int pos = 0;
    static PreparedStatement newps;
   PreparedStatement ps = null;
    static List<Integer> lastid = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        con = MyConnection.getconnection();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_register);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);

        passwd = (EditText) findViewById(R.id.passwd);
        conpasswd = (EditText) findViewById(R.id.conpasswd);
        email = (EditText) findViewById(R.id.email);
        regteacher = (Button) findViewById(R.id.regTeacher);
        regstudent = (Button) findViewById(R.id.regStudent);
        regteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {
                    //String sid = uname.getText().toString();
                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    String passwrd = passwd.getText().toString();
                    ps = User.UserReg(finame, laname, emai, passwrd, 3);
                    newps = ps;

                    try {
                        if (ps.executeUpdate() > 0) {


                            Toast.makeText(getApplicationContext(), "Registration Sueccessfull " , Toast.LENGTH_LONG).show();

                            regteachpg();
                        } else {
                            Toast.makeText(getApplicationContext(), "Registration fail", Toast.LENGTH_LONG).show();
                        }
                    } catch (SQLException e) {
                        Toast.makeText(getApplicationContext(), "You have already added this email " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }


                    //Logger.getLogger(SignupUser.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

        });
        regstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {
                    //String sid = uname.getText().toString();
                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    String passwrd = passwd.getText().toString();
                    ps = User.UserReg(finame, laname, emai, passwrd, 4);
                    newps = ps;
                    regstpg();

                    //getAllStPos();
//                    try {
//                        if (ps.executeUpdate() > 0) {
//                            Toast.makeText(getApplicationContext(), "Registration Sueccessfull", Toast.LENGTH_LONG).show();
//                            getAllStPos();
//                            regstpg();
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Registration fail", Toast.LENGTH_LONG).show();
//                        }
//                    } catch (SQLException e) {
//                        Toast.makeText(getApplicationContext(), "You have already added this email " + e.getMessage(), Toast.LENGTH_LONG).show();
//                    }


                    //Logger.getLogger(SignupUser.class.getName()).log(Level.SEVERE, null, ex);

                }


            }
        });
    }

    public void regteachpg() {
        Intent intent = new Intent(this, teacherRegistration.class);
        startActivity(intent);


    }

    public void regstpg() {
        Intent intent = new Intent(this, StudentRegistration.class);
        startActivity(intent);
    }

    public void getAllStPos() {
        int posi =0;
        String finame = fname.getText().toString();
        String laname = lname.getText().toString();
        String emai = email.getText().toString();
        String passwrd = passwd.getText().toString();
        ps = User.UserReg(finame, laname, emai, passwrd, 3);


        try {
            if (ps.executeUpdate() > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    posi = rs.getInt(1);
                    //lastid.add(pos);
                }

            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        pos = posi;


    }
    public static int getint(){
        return pos;
    }

    public static PreparedStatement getps(){
        return newps;
    }
}

