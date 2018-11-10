package com.appswedevelop.ankush.calculateage;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appswedevelop.ankush.calculateage.exception.DobExceptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

private Button button;
private EditText edCurrentDate,edDate,edYear,edCurrentYear,edMonth,edCurrentMonth;
private  TextView ageDate,ageMonth,ageYear,daydob;
private ImageButton ibCurrent,ibDob;
LinearLayout linearLayout1;
int day=0,month=0,year=0;
int currDate=0,currMonth=0,currYear=0;
int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main_activity);

        initialiseViews();
        setDefaultTime(); // setting default date
        ibCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker("current");

            }
        });
        ibDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker("dob");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>0){
                    ageDate.setText("00");
                    ageMonth.setText("00");
                    ageYear.setText("00");
                    linearLayout1.setVisibility(View.GONE);
                    count=0;

                }
                readUserInput();
                count+=1;
                findAge();
                upcomingBirthday(day,month,year);
                linearLayout1.setVisibility(View.VISIBLE);


            }
        });

    }



    private void openDatePicker(final String id){



        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                if(id.equals("dob")){
                    setEdDOB(dayOfMonth,monthOfYear,year);

                }else{
                    setEdCurrentDates(dayOfMonth,monthOfYear,year);

                }



            }

        };

        new DatePickerDialog(this, date,currYear,currMonth,currDate ).show();



    }

    private void setEdCurrentDates(int day,int month, int year){

        edCurrentDate.setText(String.valueOf(day));
        edCurrentMonth.setText(String.valueOf(month+1));
        edCurrentYear.setText(String.valueOf(year));
        currDate=day;
        currMonth=month;
        currYear=year;
    }

    private void setEdDOB(int day,int month, int year){

        edDate.setText(String.valueOf(day));
        edMonth.setText(String.valueOf(month +1));
        edYear.setText(String.valueOf(year));

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
       // nextBDDaysLeft=findViewById(R.id.nextBDDaysLeft);
        //nextBDMonthLeft=findViewById(R.id.nextBDMonthsLeft);
        daydob=findViewById(R.id.dobday);
        linearLayout1=findViewById(R.id.linearlayout1);


    }

    private void setDefaultTime(){
        final Calendar c = Calendar.getInstance();
        setEdCurrentDates(c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
      /*  String s=getTodaysDefaultDate();

        if(s!=null){

            String[] a=s.split("/");
            edCurrentDate.setText(a[0]);
            edCurrentMonth.setText(a[1]);
            edCurrentYear.setText(a[2]);
        }
*/
    }

    /*private String getTodaysDefaultDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }*/


    private void readUserInput(){

        String s;
        s=edDate.getText().toString();
        if(s.equals("")){
            edDate.setError("This field can not be blank");
        }else
        day= Integer.parseInt(s);


        s=edMonth.getText().toString();
        if(s.equals("")){
            edMonth.setError("This field can not be blank");
        }else
        month= Integer.parseInt(s);

        s=edYear.getText().toString();
        if(s.equals("")){
            edYear.setError("This field can not be blank");
        }else
        year= Integer.parseInt(s);

        s=edCurrentDate.getText().toString();
        if(s.equals("")){
            edCurrentDate.setError("This field can not be blank");
        }else
        currDate= Integer.parseInt(s);

        s=edCurrentMonth.getText().toString();
        if(s.equals("")){
            edCurrentMonth.setError("This field can not be blank");
        }else
        currMonth= Integer.parseInt(s);

        s=edCurrentYear.getText().toString();
        if(s.equals("")){
            edCurrentYear.setError("This field can not be blank");
        }else
        currYear= Integer.parseInt(s);

        /*
        if(error.length()>0)
            throw new DobExceptions(error);
        */
    }



    @SuppressLint("SetTextI18n")
    private void findAge(){

        calculating cal=new calculating(day,month,year,currDate,currMonth,currYear);
        // if Dates are Valid
        try {
            if(cal.AgeStatus()){
                ageYear.setText(String.valueOf(cal.getTotalYear()));
                ageMonth.setText(String.valueOf(cal.getTotalMonth()));
                ageDate.setText(String.valueOf(cal.getTotalDay()));

                //Avnish
                if(count>0){
                   Log.v("year",String.valueOf(year));
                    Log.v("month",String.valueOf(month));
                    Log.v("day",String.valueOf(day));
                    daydob.setText(weekday(year,month,day));

                }

            }
        } catch (DobExceptions dobExceptions) {

            dobExceptions.printStackTrace();
            //TODO: Use something better than toast
            // using this--> dobExceptions.getMessage();
            Toast.makeText(this,dobExceptions.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }


   /* private void nextBirthday(int nextYear){

        calculating cal;
        if((currMonth>month)||(currMonth==month&&currDate>=day))
             cal=new calculating(currDate,currMonth,currYear,day,month,nextYear);
        else
            cal=new calculating(currDate,currMonth,currYear,day,month,currYear);


      /* try {
            if(cal.AgeStatus()){
                if(cal.getTotalYear()>0)
                    nextBDMonthLeft.setText("12");
                else
                    nextBDMonthLeft.setText(""+cal.getTotalMonth());

                nextBDDaysLeft.setText(""+cal.getTotalDay());

            }
        } catch (DobExceptions dobExceptions) {
            dobExceptions.printStackTrace();
        }


    } */

      public String weekday(int year,int month,int day){

          int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
          year-= (month < 3) ? 1 : 0;
          int x=( year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
          String arr[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
          return arr[x];
    }

    public void upcomingBirthday(int currDate,int currMonth,int currYear){
        LinearLayout linearLayout=findViewById(R.id.llayout);

            String montharr[]={"JAN","FEB","MARCH","APRIL","MAY","JUNE","JULY","AUG","SEPT","OCT","NOV","DEC"};
            String monthname=null;
            switch(currMonth){
                case 1:monthname= montharr[0]; break;
                case 2:monthname= montharr[1]; break;
                case 3:monthname= montharr[2]; break;
                case 4:monthname= montharr[3]; break;
                case 5:monthname= montharr[4]; break;
                case 6:monthname= montharr[5]; break;
                case 7:monthname= montharr[6]; break;
                case 8:monthname= montharr[7]; break;
                case 9:monthname= montharr[8]; break;
                case 10:monthname= montharr[9]; break;
                case 11:monthname= montharr[10]; break;
                case 12:monthname= montharr[11]; break;




            }
            for(int i=0;i<linearLayout.getChildCount();i++){
                currYear+=1;
                ((TextView)(linearLayout.getChildAt(i))).setText(""+currDate+"-"+monthname+"-"+currYear+"  "+weekday(currYear,currMonth,currDate));


        }
    }
}


