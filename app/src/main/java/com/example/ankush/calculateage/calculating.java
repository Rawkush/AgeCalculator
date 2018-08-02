package com.example.ankush.calculateage;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ankush on 3/9/2018.
 */

public class calculating {


    private int d = 0, m = 0, y = 0, val = 0, cval = 0;
    private int cd = 0, cm = 0, cy = 0;
    private int ty = 0, tm = 0, td = 0;
    private int lp = 0;

    public calculating(int dd, int mm, int yy, int cdd, int cmm, int cyy) {

        d = dd;
        m = mm;
        y = yy;
        cd = cdd;
        cm = cmm;
        cy = cyy;

    }


    private boolean dob_validity() {

        if (y <= cy && cy > 0 && y > 0) {
            if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                if (d > 0 && d <= 31) {
                    // "date is valid\n";
                    val = 1;
                }
            } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                if (d > 0 && d <= 30) {
                    //<"date is valid\n";
                    val = 1;
                }
            }

            if (y % 4 == 0) {
                lp = 1;
                if (m == 2) {
                    if (d > 0 && d <= 29) {
                        //" date is valid\n";
                        val = 1;
                    }
                }
            }

            if (y % 4 != 0) {
                if (m == 2) {
                    if (d > 0 && d <= 28) {
                        //" date is valid \n";
                        val = 1;
                    }
                }
            }

        }


        if (val == 1) {
            return true;
        } else
            return false;


    }


    private boolean current_validity() {

        if (cy > 0) {
            if (cm == 1 || cm == 3 || cm == 5 || cm == 7 || cm == 8 || cm == 10 || cm == 12) {
                if (cd > 0 && cd <= 31) {
                    // cout<<"current date is  valid\n";
                    cval = 1;
                }
            }

            if (cm == 4 || cm == 6 || cm == 9 || cm == 11) {
                if (cd > 0 && cd <= 30) {
                    // cout<<"current date is  valid\n";
                    cval = 1;
                }
            }

            if (cy % 4 == 0) {
                if (cm == 2) {
                    if (cd > 0 && cd <= 29) {
                        // cout<<"current date is  valid \n";
                        cval = 1;
                    }
                }
            }

            if (cy % 4 != 0) {
                if (cm == 2) {
                    if (cd > 0 && cd <= 28) {
                        // cout<<"current date is valid\n";
                        cval = 1;
                    }
                }
            }

        }
        if (cval == 1) {
            return true;
        } else
            return false;

    }


    public String findAge() {


        if (current_validity() == false || dob_validity() == false) {
            return "INVALID DETAILS";
        } else {


            int in = 0, s = 0;


// calculating no. of days

            if (val == 1 && cval == 1) {
                if (cd > d) {
                    td = cd - d;
                }

                if (cd < d) {


                    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                        td = (cd + 31) - d;
                        in = 1;
                    }

                    if (m == 4 || m == 6 || m == 9 || m == 11) {
                        td = (cd + 30) - d;
                        in = 1;
                    }

                    if (m == 2) {
                        if (lp == 1) {
                            td = (cd + 29) - d;
                            in = 1;
                        }

                        if (lp == 0) {
                            td = (cd + 28) - d;
                            in = 1;
                        }

                    }


                }

                if (cm > m) {
                    if (in == 1) {
                        tm = (cm - 1) - m;
                    }
                    if (in == 0) {
                        tm = cm - m;
                    }
                }

                if (m > cm) {
                    s = 1;
                    if (in == 1) {
                        cm = cm - 1;
                        cm = cm + 12;
                        tm = cm - m;
                    }
                    if (in == 0) {
                        tm = (cm + 12) - m;
                    }
                }

                if (s == 1) {
                    cy = cy - 1;
                    ty = cy - y;
                }
                if (s == 0) ;
                {
                    ty = cy - y;
                }
                return String.format(" you are %d years %d months %d days old", ty, tm, td);

            }



        }

        return "some problem occured";
    }
}



