package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
        Button b1,b2;
        EditText ed1,ed2;

        TextView tx1;
        int counter = 3;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1 = (Button)findViewById(R.id.buttn);
            ed1 = (EditText)findViewById(R.id.username_edit_text);
            ed2 = (EditText)findViewById(R.id.password_edit_text);

            b2 = (Button)findViewById(R.id.button2);
            tx1 = (TextView)findViewById(R.id.textView4);
            tx1.setVisibility(View.GONE);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ed1.getText().toString().equals("user@flogo.in") &&
                            ed2.getText().toString().equals("Flogo123")) {
                        Toast.makeText(getApplicationContext(),
                                "Redirecting...",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, LogActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.BLACK);
                        counter--;
                        tx1.setText(Integer.toString(counter));

                        if (counter == 0) {
                            b1.setEnabled(false);
                        }
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
