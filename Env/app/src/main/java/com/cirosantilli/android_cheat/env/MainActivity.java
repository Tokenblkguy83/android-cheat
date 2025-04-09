package com.cirosantilli.android_cheat.env;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
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
        final TextView tv = new TextView(this);
        StringBuilder sb = new StringBuilder();
        sb.append("user.dir = " + encryptMessage(System.getProperty("user.dir")) + "\n");
        sb.append("user.name = " + encryptMessage(System.getProperty("user.name")) + "\n");
        tv.setText(sb.toString());
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        tv.startAnimation(animation);
        setContentView(tv);
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
