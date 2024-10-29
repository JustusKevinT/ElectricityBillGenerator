package com.example.tangedco;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button domesticButton;
    private Button commercialButton;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button press here
                showAlert();
            }
        };
        // Add the callback to the back button dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
        domesticButton = (Button) findViewById(R.id.button1);
        commercialButton = (Button) findViewById(R.id.button2);
        exit = (Button) findViewById(R.id.exitButton);
        domesticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        commercialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitConfirmation();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void exitConfirmation(){
        AlertDialog adm2 = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit Confirmation")
                .setMessage("Are you sure to exit ?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        adm2.show();
    }
    private void showAlert() {
        AlertDialog adm = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit Confirmation")
                .setMessage("Are you sure to exit ?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
        adm.show();
    }
}
