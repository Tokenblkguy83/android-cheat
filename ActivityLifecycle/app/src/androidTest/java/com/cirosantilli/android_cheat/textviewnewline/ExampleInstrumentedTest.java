package com.cirosantilli.android_cheat.activitylifecycle;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.cirosantilli.android_cheat.activitylifecycle", appContext.getPackageName());
    }

    @Test
    public void testButtonActivity2() {
        // Click the button to go to Activity2
        onView(withId(R.id.button_activity2)).perform(click());

        // Check if the button in Activity2 is displayed
        onView(withId(R.id.button_activity1)).check(matches(withText(R.string.button_activity1_text)));
    }

    @Test
    public void testButtonActivity1() {
        // Click the button to go to Activity2
        onView(withId(R.id.button_activity2)).perform(click());

        // Click the button to go back to MainActivity
        onView(withId(R.id.button_activity1)).perform(click());

        // Check if the button in MainActivity is displayed
        onView(withId(R.id.button_activity2)).check(matches(withText(R.string.button_activity2_text)));
    }
}
