package com.example.sendbroadcastintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText messageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageET = findViewById(R.id.messageET);

    }


    public void broadcastTheBroadcastIntent(View view) {

        if(messageET.getText().toString().length()<=0)
        {
            Toast.makeText(this, "Please, Enter Message First", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = messageET.getText().toString();
        messageET.setText("");

        Intent intent = new Intent();
        intent.setAction("com.example.MY_ACTION");
        intent.putExtra("myMessage", message);
        sendBroadcast(intent);
        Toast.makeText(this, "Intent Broadcast Successfully \n containing message: "+message, Toast.LENGTH_SHORT).show();
    }
}
