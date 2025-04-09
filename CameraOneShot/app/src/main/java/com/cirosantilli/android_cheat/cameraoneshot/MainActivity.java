package com.cirosantilli.android_cheat.cameraoneshot;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceView;
import android.util.Log;
import android.widget.ImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends Activity {
    public static final String TAG = "com.cirosantilli";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final ImageView imageView = new ImageView(this);
        this.setContentView(imageView);
        final SurfaceView surface = new SurfaceView(this);
        Camera camera = Camera.open();
        try {
            camera.setPreviewDisplay(surface.getHolder());
        } catch (IOException e) {
            Log.e(MainActivity.TAG, e.toString());
        }
        camera.startPreview();
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        surface.startAnimation(animation);
        camera.takePicture(null, null, new Camera.PictureCallback(){
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                String encryptedData = encryptData(data);
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(data, 0, data.length));
            }
        });
    }

    private String encryptData(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data);
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
