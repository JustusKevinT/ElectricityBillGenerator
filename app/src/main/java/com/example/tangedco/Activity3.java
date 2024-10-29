package com.example.tangedco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    private Button  calculateButton2;
    public EditText unitsConsumed2, dueDays2;
    public TextView resultView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        calculateButton2 = (Button) findViewById(R.id.calculatebutton_act3);
        unitsConsumed2 = (EditText) findViewById(R.id.unitsConsumed2);
        dueDays2 = (EditText) findViewById(R.id.dueDays2);
        resultView2 = (TextView) findViewById(R.id.result2);
        calculateButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBill2();
            }
        });
    }
    public void calculateBill2(){

        double units2,bill;
        String due2;
        if (TextUtils.isEmpty(unitsConsumed2.getText().toString())
                || TextUtils.isEmpty(dueDays2.getText().toString())) {
            alert("Enter valid details") ;
        }
        else{
            units2 = Double.parseDouble(unitsConsumed2.getText().toString());
            due2 = (dueDays2.getText().toString());
            if(units2 > 0 && (due2.equals("no"))){
                if(units2 < 100){
                    bill = 100*2.00;
                }
                else if(units2 > 100 && units2 < 200){
                    bill = 100*1.00+(units2-100)*4.50;
                }
                else if(units2 > 200 && units2 < 500){
                    bill = 100*1.00+200*2.50+(units2-200)*6.00;
                }
                else if (units2 > 500){
                    bill = 100*1.00+200*2.50+500*4.00+(units2-500)*7.00;
                }
                else{
                    bill = 0.00;
                }
                resultView2.setText(" Your bill is \n " + " " + bill + " Rs ");
            }
            else if(units2 > 0 && (due2.equals("yes"))){
                if (units2 < 100) {
                    bill = 100 * 2.00 + 60.00 ;
                } else if (units2 > 100 && units2 < 200) {
                    bill = 100 * 1.00 + (units2 - 100) * 4.50 + 60.00 ;
                } else if (units2 > 200 && units2 < 500) {
                    bill = 100 * 1.00 + 200 * 2.50 + (units2 - 200) * 6.00 + 60.00 ;
                } else if (units2 > 500) {
                    bill = 100 * 1.00 + 200 * 2.50 + 500 * 4.00 + (units2 - 500) * 7.00 + 60.00 ;
                } else {
                    bill = 60.00 ;
                }
                resultView2.setText(" Your bill is \n " + " " + bill + " Rs ");
            }
        }

    }
    public void alert(String message){
        AlertDialog ad2 = new AlertDialog.Builder(Activity3.this)
                .setTitle("Warning !")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        ad2.show();
    }
}