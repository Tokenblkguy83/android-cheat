package com.cirosantilli.android_cheat.intentservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startService(new Intent(this, MyService.class));
    }
    public static class MyService extends IntentService {
        private Handler handler;
        public MyService() {
            super("MyService");
        }
        @Override
        public void onCreate() {
            super.onCreate();
            /* This handler is associated to the main thread because it is obtained on onCreate(). */
            this.handler = new Handler();
        }
        @Override
        protected void onHandleIntent(Intent intent) {
            /* We need to use the handler here to create the Toast: http://stackoverflow.com/a/5420929/895245 */
            this.handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            MyService.this,
                            "from service",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
