package com.cirosantilli.android_cheat.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private void logActivityLifecycle(String s) {
        Log.d("ActivityLifecycle", s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logActivityLifecycle("onCreate");
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button_activity2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    MainActivity.Activity2.this.startActivity(new Intent(MainActivity.Activity2.this, MainActivity.class));
                }
            });
        }
    }
}
