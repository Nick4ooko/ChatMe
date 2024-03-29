package com.e.chatme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btsignup;
    private Button btlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btsignup =(Button)findViewById(R.id.bt_sign_up_id);
        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign();
            }
        });


        Button btlogin =(Button)findViewById(R.id.bt_login_id);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat();
            }
        });


    }

    private void chat() {

        Intent chatIntent =new Intent(MainActivity.this,ChatActivity.class);
        startActivity(chatIntent);
    }

    private void sign() {

        Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}
