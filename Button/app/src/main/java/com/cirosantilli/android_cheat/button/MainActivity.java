package com.cirosantilli.android_cheat.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends Activity {
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        this.i = 0;

        final TextView tv = new TextView(this);
        tv.setText(String.format("%d", this.i));

        final Button button = new Button(this);
        button.setText("click me");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.i++;
                tv.setText(String.format("%d", MainActivity.this.i));
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                view.startAnimation(animation);
            }
        });

        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(button);
        linearLayout.addView(tv);
        this.setContentView(linearLayout);
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
