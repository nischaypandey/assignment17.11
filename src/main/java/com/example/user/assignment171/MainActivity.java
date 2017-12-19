package com.example.user.assignment171;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Main Activity Class extends AppCompatActivity implements OnClick Listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   //making object of Button Pending And Context
    Button startBtn,stopBtn;
    Context context;

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);            //setting ContentView

      //setting Onjects by their Respective Id's
        startBtn = findViewById(R.id.start);
        stopBtn = findViewById(R.id.stop);
        context = this.getApplicationContext();

        //setting On Click Listener
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);

    }

    //OnClick method for Listening
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.start:
                //intent For starting Service
                Intent intent=new Intent(MainActivity.this, MediaServices.class);
                startService(intent);
                break;

            case R.id.stop:
                //intent to stop Service
                Intent intent1=new Intent(MainActivity.this,MediaServices.class);
                stopService(intent1);
                break;
        }
    }
}
