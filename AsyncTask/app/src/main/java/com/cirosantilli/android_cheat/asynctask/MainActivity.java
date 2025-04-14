package com.cirosantilli.android_cheat.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Animation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final TextView tv = new TextView(this);
        tv.setText("before");
        setContentView(tv);
        alphaAnimation = createAlphaAnimation();
        tv.setOnClickListener(view -> view.startAnimation(alphaAnimation));
        new MyAsyncTask(tv).execute(1);
    }

    private Animation createAlphaAnimation() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        return animation;
    }

    private class MyAsyncTask extends AsyncTask<Integer, Void, String> {
        TextView tv;
        MyAsyncTask(TextView tv) {
            super();
            this.tv = tv;
        }

        @Override
        protected String doInBackground(Integer... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            return params[0].toString();
        }

        @Override
        protected void onPostExecute(String result) {
            this.tv.setText(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (getStatus() == Status.RUNNING) {
                    cancel(true);
                }
            }, 5000); // Timeout after 5 seconds
        }
    }
}
