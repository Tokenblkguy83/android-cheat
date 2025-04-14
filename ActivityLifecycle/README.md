# ActivityLifecycle

This repository demonstrates the lifecycle of Android activities by toggling between two different activities when the user clicks on the screen.

## Purpose

The purpose of this repository is to provide a simple example of how to manage the lifecycle of Android activities. It shows how to handle activity transitions, animations, and avoid starting a new activity if it is already running.

## Features

- Toggle between two activities
- Reuse animation instances
- Check if an activity is already running before starting a new one

## Usage

1. Clone the repository:
    ```
    git clone https://github.com/yourusername/ActivityLifecycle.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.
4. Click the button to toggle between the two activities.

## Examples

### MainActivity

The `MainActivity` class demonstrates how to handle the lifecycle of an activity and manage transitions between activities.

```java
public class MainActivity extends AppCompatActivity {
    private void logActivityLifecycle(String s) {
        Log.d("ActivityLifecycle", s);
    }

    private Animation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        logActivityLifecycle("onCreate");
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button_activity2);
        alphaAnimation = createAlphaAnimation();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.startAnimation(alphaAnimation);
                if (!isActivityInForeground(MainActivity.Activity2.class)) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.Activity2.class));
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        logActivityLifecycle("onStart");
    }

    protected void onRestart() {
        super.onRestart();
        logActivityLifecycle("onRestart");
    }

    protected void onResume() {
        super.onResume();
        logActivityLifecycle("onResume");
    }

    protected void onPause() {
        super.onPause();
        logActivityLifecycle("onPause");
    }

    protected void onStop() {
        super.onStop();
        logActivityLifecycle("onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        logActivityLifecycle("onDestroy");
    }

    private Animation createAlphaAnimation() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        return animation;
    }

    private boolean isActivityInForeground(Class<?> activityClass) {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (topActivity.getClassName().equals(activityClass.getName())) {
                return true;
            }
        }
        return false;
    }

    public static class Activity2 extends AppCompatActivity {
        private Animation alphaAnimation;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final Button button = findViewById(R.id.button_activity1);
            alphaAnimation = createAlphaAnimation();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    button.startAnimation(alphaAnimation);
                    if (!isActivityInForeground(MainActivity.class)) {
                        MainActivity.Activity2.this.startActivity(new Intent(MainActivity.Activity2.this, MainActivity.class));
                    }
                }
            });
        }

        private boolean isActivityInForeground(Class<?> activityClass) {
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
            if (!tasks.isEmpty()) {
                ComponentName topActivity = tasks.get(0).topActivity;
                if (topActivity.getClassName().equals(activityClass.getName())) {
                    return true;
                }
            }
            return false;
        }
    }
}
```

## Troubleshooting

### Common Issues

1. **App crashes on startup**: Ensure that you have the correct permissions and dependencies in your `AndroidManifest.xml` and `build.gradle` files.
2. **Animation not working**: Check if the animation instance is being reused correctly and that the duration is set properly.
3. **Activity not toggling**: Ensure that the `isActivityInForeground` method is correctly identifying the running activity.

### FAQs

1. **How do I add more activities?**
   - To add more activities, create new activity classes and update the button click listeners to start the new activities.

2. **Can I change the animation?**
   - Yes, you can change the animation by modifying the `createAlphaAnimation` method to create a different type of animation.

3. **How do I handle configuration changes?**
   - To handle configuration changes, override the `onConfigurationChanged` method in your activity and update the UI elements accordingly.

