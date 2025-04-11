package com.cirosantilli.android_cheat.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final EditText editText = new EditText(this);
        editText.setHint("Enter text here...");
        editText.setText("hello world");
        editText.setTextColor(getResources().getColor(android.R.color.black));
        editText.setBackgroundColor(getResources().getColor(android.R.color.white));
        setContentView(editText);
    }
}
