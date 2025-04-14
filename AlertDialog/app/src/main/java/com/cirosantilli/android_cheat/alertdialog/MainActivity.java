package com.cirosantilli.android_cheat.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

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
