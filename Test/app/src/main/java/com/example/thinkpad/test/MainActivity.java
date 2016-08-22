package com.example.thinkpad.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.utils.GarfieldTest;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){
        new GarfieldTest().test();
    }
}
