package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.guruforstudent.Controls.FileRW;
import com.example.user.guruforstudent.Models.Institue;

import java.util.ArrayList;
import java.util.List;

public class ChooseInstitue extends AppCompatActivity {
    Spinner spin;
    EditText regid;
    Button nxt;
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_institue);
        spin = (Spinner) findViewById(R.id.insNameSpin);
        regid = (EditText)findViewById(R.id.reg);
        nxt = (Button)findViewById(R.id.toMainpg);
        logout = (Button)findViewById(R.id.LogOut);

        loadSpin();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileRW rw = new FileRW();
                rw.clearTheFile();
                tologinpg();
            }
        });
    }

    public void tologinpg() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);

    }

    private void loadSpin() {
        Institue ins = new Institue();
        List<String> insName = ins.getAllInstitutes();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, insName);


        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);


    }

}
