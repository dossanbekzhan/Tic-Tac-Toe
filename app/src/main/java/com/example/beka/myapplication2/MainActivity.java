package com.example.beka.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartGame;
    Button btnHowToPlay;
    Button btnInstructions;
    Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStartGame = findViewById(R.id.btn_NewGame);
        btnHowToPlay = findViewById(R.id.btn_How_to_Play);
        btnInstructions = findViewById(R.id.btn_instuctions);
        btnExit = findViewById(R.id.btn_exit);


        initControl();


    }

    private void initControl(){
        btnHowToPlay.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnInstructions.setOnClickListener(this);
        btnStartGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_NewGame:
                Intent intentMain = new Intent(this,GameActivity.class);
                startActivity(intentMain);

                break;

            case R.id.btn_How_to_Play:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;

            case R.id.btn_instuctions:
                Intent intent2 = new Intent(this,Main3Activity.class);
                startActivity(intent2);
                break;

            case R.id.btn_exit:
                finish();
                break;


        }

    }


}
