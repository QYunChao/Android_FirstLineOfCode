package com.example.myfirstandroiddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button firstButton = (Button)findViewById(R.id.first_button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "Click First Button",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button finishButton = (Button) findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        Button explicitIntentButton = (Button) findViewById(R.id.explicit_intent_button);
        explicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button implicitIntentButton = (Button) findViewById(R.id.implicit_intent_button);
        implicitIntentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("android.intent.category.MY_COTEGORY");
                startActivity(intent);
            }
        });

        Button viewButton = (Button) findViewById(R.id.view_button);
        viewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("http://www.baidu.com"));/*tel:10086*/
                startActivity(intent);
            }
        });

        Button sendDataToNextIntentButton = (Button) findViewById(R.id.send_data_to_next_intent);
        sendDataToNextIntentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = "Hello Second Activity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        Button sendDataToPreIntent = (Button) findViewById(R.id.send_data_to_pre_intent);
        sendDataToPreIntent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("http://www.baidu.com"));/*tel:10086*/
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.start_a_group_chat:
                Toast.makeText(FirstActivity.this, "start_a_group_chat",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_a_new_friend:
                Toast.makeText(FirstActivity.this, "add_a_new_friend",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan_qrcode:
                Toast.makeText(FirstActivity.this, "scan_qrcode",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.payment:
                Toast.makeText(FirstActivity.this, "payment",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(FirstActivity.this, "help",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
