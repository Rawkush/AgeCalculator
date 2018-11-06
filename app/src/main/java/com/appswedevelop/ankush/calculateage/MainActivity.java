package com.appswedevelop.ankush.calculateage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.appswedevelop.ankush.calculateage.exception.DobExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

private Button button;
private EditText edCurrentDate,edDate,edYear,edCurrentYear,edMonth,edCurrentMonth;
private  TextView ageDate,ageMonth,ageYear;
private ImageButton ibCurrent,ibDob;

    int day=0,month=0,year=0;
    int currdate=0,currMonth=0,currYear=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main_activity);
        initialiseViews();
        setDefaultTime(); // setting default date

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(readUserInput()){

                    findAge();


                }else{
                    //TODO: display enter all details
                }
            }
        });

    }

    private void initialiseViews(){
        button =(Button) findViewById(R.id.button);
        edCurrentDate =(EditText) findViewById(R.id.cdate);
        edDate = (EditText) findViewById(R.id.date);
        edYear =(EditText) findViewById(R.id.year);
        edCurrentYear =(EditText) findViewById(R.id.cyear);
        edMonth =(EditText) findViewById(R.id.month);
        edCurrentMonth =(EditText) findViewById(R.id.cmonth);
        ageDate=findViewById(R.id.ageDay);
        ageMonth=findViewById(R.id.ageMonth);
        ageYear=findViewById(R.id.ageYear);
        ibCurrent=findViewById(R.id.ibcurr);
        ibDob=findViewById(R.id.ibdob);
    }

    private void setDefaultTime(){

        String s=getTodaysDefaultDate();

        if(s!=null){

            String[] a=s.split("/");
            edCurrentDate.setText(a[0]);
            edCurrentMonth.setText(a[1]);
            edCurrentYear.setText(a[2]);
        }

    }

    private String getTodaysDefaultDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }


    private boolean readUserInput() {

        String s=null;
        s=edDate.getText().toString();
        if(s.equals("")){
            return false;
        }

        day= Integer.parseInt(s);


        s=edMonth.getText().toString();

        if(s.equals("")){
            return false;
        }
        month= Integer.parseInt(s);

        s=edYear.getText().toString();
        if(s.equals("")){
            return false;
        }
        year= Integer.parseInt(s);

        s=edCurrentDate.getText().toString();
        if(s.equals("")){
            return false;
        }
        currdate= Integer.parseInt(s);

        s=edCurrentMonth.getText().toString();
        if(s.equals("")){
            return false;
        }
        currMonth= Integer.parseInt(s);

        s=edCurrentYear.getText().toString();
        if(s.equals("")){
            return false;
        }

        currYear= Integer.parseInt(s);

        return true;
    }



    @SuppressLint("SetTextI18n")
    private void findAge(){

        calculating cal=new calculating(day,month,year,currdate,currMonth,currYear);
        // if Dates are Valid
        try {
            if(cal.AgeStatus()){

                ageYear.setText(String.valueOf(cal.getTotalYear())+" years");
                ageMonth.setText(String.valueOf(cal.getTotalMonth())+" months");
                ageDate.setText(String.valueOf(cal.getTotalDay())+" Days");
            }
        } catch (DobExceptions dobExceptions) {

            dobExceptions.printStackTrace();
            //TODO: Toast showing the exception

        }
    }



}
