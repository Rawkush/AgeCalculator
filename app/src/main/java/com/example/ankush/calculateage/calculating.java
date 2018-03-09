package com.example.ankush.calculateage;

/**
 * Created by Ankush on 3/9/2018.
 */

public class calculating {


private    int d=0,m=0,y=0,val=0,cval=0;
private     int cd=0,cm=0,cy=0;
private     int ty=0,tm=0,td=0;
private     int lp=0;

public  calculating(int dd,int mm,int yy,int cdd,int cmm,int cyy){

    d=dd;
    m=mm;
    y=yy;
    cd=cdd;
    cm=cmm;
    cy=cyy;

}


public  String find(){

    if(y<=cy&&cy>0&&y>0)
    {
        if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
        {
            if(d>0&&d<=31)
            {
               // "date is valid\n";
                val=1;
            }
        }else
        if(m==4||m==6||m==9||m==11)
        {
            if(d>0&&d<=30)
            {
                //<"date is valid\n";
                val=1;
            }
        }

        if(y%4==0)
        {
            lp=1;	if(m==2)
        {
            if(d>0&&d<=29)
            {
                //" date is valid\n";
                val=1;
            }
        }
        }

        if(y%4!=0)
        {
            if(m==2)
            {	if(d>0&&d<=28)
            {
                //" date is valid \n";
                val=1;
            }
            }
        }

    }





    }



}
