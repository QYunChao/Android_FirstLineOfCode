package com.example.c2activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle_data");
        if(bundle != null){
            String data = bundle.getString("data");
            if(data != null){
                Toast.makeText(NormalActivity.this, data, Toast.LENGTH_LONG).show();
            }
        }
    }
}
