package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentRegistration extends AppCompatActivity {
    Button regbtn;
    public static String query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        regbtn = (Button)findViewById(R.id.regtoIns);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseInspg();
            }
        });


    }

    public void chooseInspg() {
        Intent intent = new Intent(this,ChooseInstitue.class);
        startActivity(intent);
    }

}
