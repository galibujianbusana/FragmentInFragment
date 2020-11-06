package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends Activity implements View.OnClickListener{

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                intent=new Intent(MainActivity.this, TabLessActivity.class);
                break;
            case R.id.button2:
                intent=new Intent(MainActivity.this, TabManyActivity.class);
                break;
        }
        startActivity(intent);
    }
}
