package com.cirosantilli.android_cheat.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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

        final TextView textView = new TextView(this);
        final CheckBox checkBox0 = new CheckBox(this);
        final CheckBox checkBox1 = new CheckBox(this);

        textView.setText(this.getText(checkBox0, checkBox1));

        class OnClickListener implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                view.startAnimation(animation);
                textView.setText(MainActivity.this.getText(checkBox0, checkBox1));
            }
        }
        checkBox0.setOnClickListener(new OnClickListener());
        checkBox0.setText("0");
        checkBox1.setOnClickListener(new OnClickListener());
        checkBox1.setText("1");

        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(checkBox0);
        linearLayout.addView(checkBox1);
        linearLayout.addView(textView);
        setContentView(linearLayout);
    }

    private String getText(CheckBox checkBox0, CheckBox checkBox1) {
        StringBuilder sb = new StringBuilder("checked: ");
        if (checkBox0.isChecked())
            sb.append("0 ");
        if (checkBox1.isChecked())
            sb.append("1 ");
        return encryptMessage(sb.toString());
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
