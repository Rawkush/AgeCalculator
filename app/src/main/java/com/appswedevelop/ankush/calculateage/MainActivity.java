package com.appswedevelop.ankush.calculateage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

private Button button;
private EditText cdate,date,year,cyear,month,cmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);
        cdate =(EditText) findViewById(R.id.cdate);
        date = (EditText) findViewById(R.id.date);
        year =(EditText) findViewById(R.id.year);
        cyear =(EditText) findViewById(R.id.cyear);
        month =(EditText) findViewById(R.id.month);
        cmonth =(EditText) findViewById(R.id.cmonth);

        initDefaults(); // setting default date

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readUserInput();
            }
        });

    }

    private void initDefaults(){

        String s=getTodaysDefaultDate();

        if(s!=null){

            String[] a=s.split("/");
            cdate.setText(a[0]);
            cmonth.setText(a[1]);
            cyear.setText(a[2]);
        }

    }

    private String getTodaysDefaultDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }

    public void readUserInput() {


        int d=0,m=0,y=0;
        int cd=0,cm=0,cy=0;

        String s=null;
        s=date.getText().toString();
        if(s.equals("")){
            return;
        }

        d= Integer.parseInt(s);


        s=month.getText().toString();

        if(s.equals("")){
            return;
        }
        m= Integer.parseInt(s);

        s=year.getText().toString();
        if(s.equals("")){
            return;
        }
        y= Integer.parseInt(s);

        s=cdate.getText().toString();
        if(s.equals("")){
            return;
        }
        cd= Integer.parseInt(s);

        s=cmonth.getText().toString();
        if(s.equals("")){
            return;
        }
        cm= Integer.parseInt(s);

        s=cyear.getText().toString();
        if(s.equals("")){
            return;
        }

        cy= Integer.parseInt(s);
        calculating cal=new calculating(d,m,y,cd,cm,cy);

        // if Dates are Valid
        if(cal.AgeStatus()){

        }

    }



}
