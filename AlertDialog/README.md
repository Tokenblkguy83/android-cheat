# AlertDialog

This repository demonstrates how to use `AlertDialog` in an Android application. It shows how to display an alert dialog when the app opens and then show the selected value on the main activity.

## Purpose

The purpose of this repository is to provide a simple example of how to use `AlertDialog` in an Android application. It shows how to handle dialog creation, display, and retain the dialog instance across configuration changes.

## Features

- Display an alert dialog when the app opens
- Show the selected value on the main activity
- Retain the `AlertDialog` instance across configuration changes
- Reuse animation instances

## Usage

1. Clone the repository:
    ```
    git clone https://github.com/yourusername/AlertDialog.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.
4. The alert dialog will be displayed when the app opens. Select a value to see it displayed on the main activity.

## Examples

### MainActivity

The `MainActivity` class demonstrates how to handle the lifecycle of an activity and manage the display of an `AlertDialog`.

```java
public class MainActivity extends FragmentActivity {
    private static final String DIALOG_FRAGMENT_TAG = "dialog_fragment";
    private Animation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Handle the case where savedInstanceState is null
        }
        final TextView textView = new TextView(this);
        textView.setText("before");
        this.setContentView(textView);

        alphaAnimation = createAlphaAnimation();

        CustomDialogFragment dialogFragment = (CustomDialogFragment) getSupportFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);
        if (dialogFragment == null) {
            dialogFragment = new CustomDialogFragment();
            dialogFragment.show(getSupportFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    private Animation createAlphaAnimation() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        return animation;
    }

    public static class CustomDialogFragment extends DialogFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            if (getDialog() == null) {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .setTitle("Title of alert")
                    .setMessage("Message of the alert. Yes or no?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((TextView) getActivity().findViewById(android.R.id.content)).setText("yes");
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((TextView) getActivity().findViewById(android.R.id.content)).setText("no");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .create();

                alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alertDialog.show();
            }
        }
    }
}
```

## Troubleshooting

### Common Issues

1. **App crashes on startup**: Ensure that you have the correct permissions and dependencies in your `AndroidManifest.xml` and `build.gradle` files.
2. **Dialog not showing**: Check if the `CustomDialogFragment` is being created and displayed correctly.
3. **Animation not working**: Check if the animation instance is being reused correctly and that the duration is set properly.

### FAQs

1. **How do I customize the dialog?**
   - To customize the dialog, modify the `AlertDialog.Builder` in the `CustomDialogFragment` class. You can change the title, message, buttons, and other properties.

2. **Can I use a different type of dialog?**
   - Yes, you can use different types of dialogs by extending the `DialogFragment` class and creating the desired dialog in the `onCreateDialog` method.

3. **How do I handle configuration changes?**
   - To handle configuration changes, set the `setRetainInstance(true)` method in the `CustomDialogFragment` class. This will retain the dialog instance across configuration changes.
