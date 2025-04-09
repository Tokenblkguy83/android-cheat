package com.cirosantilli.android_cheat.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
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
        final TextView tv = new TextView(this);
        tv.setText("before");
        setContentView(tv);
        new MyAsyncTask(tv).execute(1);
    }

    private class MyAsyncTask extends AsyncTask<Integer, Void, String> {
        TextView tv;
        MyAsyncTask(TextView tv) {
            super();
            this.tv = tv;
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
        protected String doInBackground(Integer... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            return encryptMessage(params[0].toString());
        }

        @Override
        protected void onPostExecute(String result) {
            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(500);
            this.tv.startAnimation(animation);
            this.tv.setText(result);
        }
    }
}
