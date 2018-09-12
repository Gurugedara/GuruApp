package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.guruforstudent.Controls.FileRW;

public class MainActivity extends AppCompatActivity {
    Button nxtpg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nxtpg1=(Button)findViewById(R.id.btnIns);
        nxtpg1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Login lg = new Login();
              //String username= lg.load();
              /** if(username == "") {
                   openLoginpg();
               }
              else{
                   chooseInspg();

               } **/
            // openLoginpg();
                lg.openregpg();
            }
        });


    }
    public void openLoginpg() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
    public void chooseInspg() {
        Intent intent = new Intent(this,ChooseInstitue.class);
        startActivity(intent);
    }
}
