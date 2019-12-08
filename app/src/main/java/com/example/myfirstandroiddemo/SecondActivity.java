package com.example.myfirstandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button secondButton;
    Button sendDataToPreDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondButton = findViewById(R.id.second_button);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");

                if(null != data){
                    Log.i("extra_data", data);
                    Toast.makeText(SecondActivity.this, data,
                            Toast.LENGTH_SHORT).show();
                }else{
                    data = "上个页面传入数据为null";
                    Log.i("extra_data", data);
                    Toast.makeText(SecondActivity.this, data,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        sendDataToPreDataButton = findViewById(R.id.send_data_to_pre_intent);
        sendDataToPreDataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendDataToPreDataButton();
            }
        });
    }

    @Override
    public void onBackPressed(){
        sendDataToPreDataButton();
    }

    public void sendDataToPreDataButton(){
        Intent intent = new Intent();
        intent.putExtra("return_data", "Hello FirstActivity, this is SecondActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
