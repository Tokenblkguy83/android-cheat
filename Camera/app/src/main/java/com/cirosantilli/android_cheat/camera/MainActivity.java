package com.cirosantilli.android_cheat.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final Button button = new Button(this);
        button.setText("click me to take picture");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(500);
                v.startAnimation(animation);
                MainActivity.this.startActivityForResult(
                        new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE),
                        CAMERA_REQUEST);
            }
        });
        this.imageView = new ImageView(this);
        this.imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(button);
        linearLayout.addView(this.imageView);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            this.imageView.setImageBitmap((Bitmap)data.getExtras().get("data"));
        }
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
