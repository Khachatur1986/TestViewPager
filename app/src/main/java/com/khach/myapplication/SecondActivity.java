package com.khach.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goTo(View view) {
        Random random = new Random();
        int pagerIndex = random.nextInt(Constants.values().length);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", pagerIndex);
        startActivity(intent);
        finish();
    }
}
