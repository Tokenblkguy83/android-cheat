package com.cirosantilli.android_cheat.imageview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final ImageView imageView = new ImageView(this);
        /* Just put the name of the file here. */
        imageView.setImageResource(R.drawable.flower);
        setContentView(imageView);
    }
}
