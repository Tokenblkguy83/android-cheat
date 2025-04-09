package com.cirosantilli.android_cheat.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final int i = 0;
        final TextView textView = new TextView(this);
        textView.setText(String.format("%d", i));
        setContentView(textView);
        final Handler handler = new Handler();
        class MyRunnable implements Runnable {
            private Handler handler;
            private int i;
            private TextView textView;
            public MyRunnable(Handler handler, int i, TextView textView) {
                this.handler = handler;
                this.i = i;
                this.textView = textView;
            }
            @Override
            public void run() {
                this.handler.postDelayed(this, 500);
                this.i++;
                this.textView.setText(String.format("%d", i));
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                this.textView.startAnimation(animation);
            }
        }
        handler.post(new MyRunnable(handler, i, textView));
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
}
