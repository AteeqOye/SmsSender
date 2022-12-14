package com.example.smssender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText inputPhoneNo;
    EditText inputMessage;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        sendBtn =  findViewById(R.id.sendMsgBtn);
        inputPhoneNo =  findViewById(R.id.inputPhoneNumber);
        inputMessage =  findViewById(R.id.inputMessage);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {
        phoneNo = inputPhoneNo.getText().toString();
        message = inputMessage.getText().toString();

        SmsManager smsManager = SmsManager.getDefault ();
        smsManager.sendTextMessage (phoneNo, null, message, null, null);
        Toast.makeText (getApplicationContext (), "SMS sending.", Toast.LENGTH_LONG).show ();

    }
}