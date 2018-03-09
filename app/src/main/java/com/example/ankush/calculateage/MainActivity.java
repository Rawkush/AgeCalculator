package com.example.ankush.calculateage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//private Button button;
private EditText cdate;
private EditText date;
private EditText year;
private EditText cyear;
private EditText month;
private EditText cmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button =(Button) findViewById(R.id.button);
        cdate =(EditText) findViewById(R.id.cdate);
        date = (EditText) findViewById(R.id.date);
        year =(EditText) findViewById(R.id.year);
        cyear =(EditText) findViewById(R.id.cyear);
        month =(EditText) findViewById(R.id.month);
        cmonth =(EditText) findViewById(R.id.cmonth);

    }


    public void calculateAge(View view) {


        int d=0,m=0,y=0;
        int cd=0,cm=0,cy=0;

        String s=null;
        s=date.getText().toString();
        d= Integer.parseInt(s);

        s=month.getText().toString();
        m= Integer.parseInt(s);

        s=year.getText().toString();
        y= Integer.parseInt(s);

        s=cdate.getText().toString();
        cd= Integer.parseInt(s);

        s=cmonth.getText().toString();
        cm= Integer.parseInt(s);

        s=cyear.getText().toString();
        cy= Integer.parseInt(s);





    }



}
