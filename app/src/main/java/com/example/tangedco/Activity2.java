package com.example.tangedco;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private Button  calculateButton;
    public EditText unitsConsumed, dueDays;
    public TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        calculateButton = (Button) findViewById(R.id.calculatebutton_act2);
        unitsConsumed = (EditText) findViewById(R.id.unitsConsumed);
        dueDays = (EditText) findViewById(R.id.dueDays);
        resultView = (TextView) findViewById(R.id.result);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBill();
            }
        });
    }
    public void calculateBill() {
        double units,bill;
        String due;
        if (TextUtils.isEmpty(unitsConsumed.getText().toString())
                || TextUtils.isEmpty(dueDays.getText().toString())) {
            alert("Enter valid details");
        }
        else{
            units = Double.parseDouble(unitsConsumed.getText().toString());
            due = dueDays.getText().toString();
            if(units > 0 && (due.equals("no"))){
                if(units < 100){
                    bill = 100*0.00;
                }
                else if(units > 100 && units < 200){
                    bill = 100*0.00+(units-100)*1.50;
                }
                else if(units > 200 && units < 500){
                    bill = 100*0.00+200*2.00+(units-200)*3.00;
                }
                else if (units > 500){
                    bill = 100*1.00+200*3.50+500*4.60+(units-500)*6.60;
                }
                else{
                    bill = 0.00;
                }
                resultView.setText(" Your bill is \n " + " " + bill + " Rs ");
            }
            else if(units > 0 && (due.equals("yes"))) {
                if (units < 100) {
                    bill = 100 * 0.00 + 60.00 ;
                } else if (units > 100 && units < 200) {
                    bill = 100 * 0.00 + (units - 100) * 1.50 + 60.00 ;
                } else if (units > 200 && units < 500) {
                    bill = 100 * 0.00 + 200 * 2.00 + (units - 200) * 3.00 + 60.00;
                } else if (units > 500) {
                    bill = 100 * 0.00 + 200 * 3.50 + 500 * 4.60 + (units - 500) * 6.60 + 60.00 ;
                } else {
                    bill = 60.00 ;
                }
                resultView.setText(" Your bill is \n " + " " + bill + " Rs ");
            }
        }
    }
    public void alert(String message){
        AlertDialog ad = new AlertDialog.Builder(Activity2.this)
                .setTitle("Warning!")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        ad.show();
    }

}