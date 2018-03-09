package com.example.ankush.calculateage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textView;
private Button button;
private EditText cdate;
private EditText dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView) findViewById(R.id.result);
        button =(Button) findViewById(R.id.button);
        cdate =(EditText) findViewById(R.id.cdate);
        dob = (EditText) findViewById(R.id.dob);

    }


    public void calculateAge(View view) {

        
    }



}
