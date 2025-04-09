package com.cirosantilli.android_cheat.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
        textView.setText("before");
        this.setContentView(textView);
        new AlertDialog.Builder(this)
            .setTitle("Title of alert")
            .setMessage("Message of the alert. Yes or no?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Animation animation = new AlphaAnimation(0.0f, 1.0f);
                    animation.setDuration(500);
                    textView.startAnimation(animation);
                    textView.setText("yes");
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Animation animation = new AlphaAnimation(0.0f, 1.0f);
                    animation.setDuration(500);
                    textView.startAnimation(animation);
                    textView.setText("no");
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
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
