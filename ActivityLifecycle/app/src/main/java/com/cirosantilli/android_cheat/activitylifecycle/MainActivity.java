package com.cirosantilli.android_cheat.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private void logActivityLifecycle(String s) {
        String encryptedMessage = encryptMessage(s);
        Log.d("ActivityLifecycle", encryptedMessage);
    }

    private String encryptMessage(String message) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(message.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        logActivityLifecycle("onCreate");
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button_activity2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                view.startAnimation(animation);
                MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.Activity2.class));
            }
        });
    }

    protected void onStart() {
        super.onStart();
        logActivityLifecycle("onStart");
    }

    protected void onRestart() {
        super.onRestart();
        logActivityLifecycle("onRestart");
    }

    protected void onResume() {
        super.onResume();
        logActivityLifecycle("onResume");
    }

    protected void onPause() {
        super.onPause();
        logActivityLifecycle("onPause");
    }

    protected void onStop() {
        super.onStop();
        logActivityLifecycle("onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        logActivityLifecycle("onDestroy");
    }

    public static class Activity2 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final Button button = findViewById(R.id.button_activity1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation animation = new AlphaAnimation(0.0f, 1.0f);
                    animation.setDuration(500);
                    view.startAnimation(animation);
                    MainActivity.Activity2.this.startActivity(new Intent(MainActivity.Activity2.this, MainActivity.class));
                }
            });
        }
    }
}
