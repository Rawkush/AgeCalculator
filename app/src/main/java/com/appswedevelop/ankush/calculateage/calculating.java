package com.appswedevelop.ankush.calculateage;

import android.content.Context;
import android.widget.Toast;

import com.appswedevelop.ankush.calculateage.exception.DobExceptions;

/**
 * Created by Ankush on 3/9/2018.
 */

public class calculating  {


    private int day = 0, month = 0, year = 0;
    private boolean val=false, cval=false;
    private int currDay = 0, currMonth = 0, curryear = 0;
    private int totalYear = 0, totalMonth = 0, totalDay = 0;
    private int leapYear = 0;


    public calculating(int day, int month, int year, int currentDay, int currentMonth, int currentYear) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.currDay = currentDay;
        this.currMonth = currentMonth;
        this.curryear = currentYear;

    }



    private boolean dob_validity() throws DobExceptions {

        if((curryear==year&&currMonth==month&&day>currDay)||(year>curryear)||(year==curryear&&month>currMonth)){
            throw new DobExceptions("Wrong DOB or current Date");
        }

        if ( year <= curryear && curryear > 0 && year > 0) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 0 && day <= 31) {
                    // "date is valid\n";
                    val = true;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 0 && day <= 30) {
                    //<"date is valid\n";
                    val = true;
                }
            }

            if(year%100==0){
                if(year%400==0){
                    leapYear=1;
                    if (month == 2) {
                        if (day > 0 && day <= 29) {
                            //" date is valid\n";
                            val = true;
                        }
                    }
                }
            }else


            if (year % 4 == 0) {
                leapYear = 1;
                if (month == 2) {
                    if (day > 0 && day <= 29) {
                        //" date is valid\n";
                        val = true;
                    }
                }
            }




            if (year % 4 != 0) {
                if (month == 2) {
                    if (day > 0 && day <= 28) {
                        //" date is valid \n";
                        val = true;
                    }
                }
            }

        }


       return val;


    }


    private boolean current_validity() {

        if (curryear > 0) {
            if (currMonth == 1 || currMonth == 3 || currMonth == 5 || currMonth == 7 || currMonth == 8 || currMonth == 10 || currMonth == 12) {
                if (currDay > 0 && currDay <= 31) {
                    // cout<<"current date is  valid\n";
                    cval = true;
                }
            }

            if (currMonth == 4 || currMonth == 6 || currMonth == 9 || currMonth == 11) {
                if (currDay > 0 && currDay <= 30) {
                    // cout<<"current date is  valid\n";
                    cval = true;
                }
            }

            if (curryear % 4 == 0) {
                if (currMonth == 2) {
                    if (currDay > 0 && currDay <= 29) {
                        // cout<<"current date is  valid \n";
                        cval = true;
                    }
                }
            }

            if (curryear % 4 != 0) {
                if (currMonth == 2) {
                    if (currDay > 0 && currDay <= 28) {
                        // cout<<"current date is valid\n";
                        cval = true;
                    }
                }
            }

        }

        return cval;

    }


    public boolean AgeStatus() throws DobExceptions{

        if(!current_validity())
            throw new DobExceptions("Current date is not Valid");
        else
        if( !dob_validity())
            throw new DobExceptions("DOB is not Valid");

        else {

            int in = 0, s = 0;


// calculating no. of days

            if (val && cval) {
                if (currDay >= day) {

                    totalDay = currDay - day;

                }else

                if (currDay < day) {

        /////////////
                    in=1;




                    if(currMonth==3){

                        if (leapYear == 1) {
                            totalDay = (currDay + 29) - day;
                            in = 1;
                        }

                        if (leapYear == 0) {
                            totalDay = (currDay + 28) - day;
                            in = 1;
                        }

                    }else
////////

                    if (currMonth == 1 || currMonth == 2 || currMonth == 7 || currMonth == 8 || currMonth == 10 || currMonth == 12) {

                        if(currMonth==8||currMonth==2||currMonth==1) {
                            totalDay = (currDay + 31) - day;
                        }else
                            totalDay = (currDay + 30) - day;

                        in = 1;
                    }else

                    if (currMonth == 4 || currMonth == 6 || currMonth == 9 || currMonth == 11) {
                        totalDay = (currDay + 31) - day;
                        in = 1;
                    }

                  /*  if (month == 2) {
                        if (leapYear == 1) {
                            totalDay = (currDay + 29) - day;
                            in = 1;
                        }

                        if (leapYear == 0) {
                            totalDay = (currDay + 28) - day;
                            in = 1;
                        }

                    }
*/

                }

                if (currMonth > month) {
                   /* if (in == 1) {
                        totalMonth = (currMonth - 1) - month;

                    }else
                    if (in == 0) {
                   */     totalMonth = currMonth-in - month;
                  //  }
                }else

                if (month >= currMonth) {
                  /*  if (in == 1) {
                        currMonth = currMonth - 1;
                        currMonth = currMonth + 12;
                        s = 1;
                        totalMonth = currMonth - month;
                    }
                    if (in == 0) {
                        totalMonth = (currMonth ) - month;
                    }
*/
                    currMonth = currMonth - in;

                    currMonth = currMonth + 12;
                    s = 1;
                    totalMonth = currMonth - month;
                }
/*
                if (s == 0)
                {
                    totalYear = curryear - year;
                }else
                if (s == 1) {
                    curryear = curryear - 1;*/
                    totalYear = curryear -s - year;
  //              }
                    //return String.format(" you are %d years %d months %d days old", ty, tm, td);
                return true;
            }


        }
        return false;
    }


    public int getTotalYear() {
        return totalYear;
    }

    public int getTotalMonth() {
        return totalMonth;
    }

    public int getTotalDay() {
        return totalDay;
    }
}



