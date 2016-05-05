package com.jly.garfieldprojects;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jly.garfieldprojects.ui.QqHeaderActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        ((Button)findViewById(R.id.QqHeaderActivityBtn)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.QqHeaderActivityBtn:
                startActivity(new Intent(MainActivity.this, QqHeaderActivity.class));
                break;
        }
    }
}
