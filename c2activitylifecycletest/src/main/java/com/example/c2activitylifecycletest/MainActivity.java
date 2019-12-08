package com.example.c2activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private static final String BUNDLE_TAG = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            String tempData = savedInstanceState.getString("data_key");
            if(tempData != null){
                Log.i(BUNDLE_TAG, tempData);
            }
        }

        Button normalButton = findViewById(R.id.start_normal_activity);
        normalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        Button dialogButton = findViewById(R.id.start_dialog_activity);
        dialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        // 通过 Intent 向下个页面传输 Bundle 数据
        Button sendBundleDataToNextIntentButton = findViewById(R.id.send_bundle_data_to_next_intent);
        sendBundleDataToNextIntentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("data", "这是一个向下传输的Bundle数据");
                intent.putExtra("bundle_data", bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        logAndToast("onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        logAndToast("onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        logAndToast("onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        logAndToast("onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        logAndToast("onDestroy");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        logAndToast("onRestart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String tempData = "Data You Need Save";
        outState.putString("data_key", tempData);
    }

    public void logAndToast(String data){
        Log.i(TAG, data);
        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
    }


}
