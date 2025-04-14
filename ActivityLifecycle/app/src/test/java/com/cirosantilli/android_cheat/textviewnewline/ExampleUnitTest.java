package com.cirosantilli.android_cheat.activitylifecycle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testActivityLifecycle() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        assertTrue(mainActivity.isActivityInForeground(MainActivity.class));
        mainActivity.onPause();
        assertFalse(mainActivity.isActivityInForeground(MainActivity.class));
        mainActivity.onResume();
        assertTrue(mainActivity.isActivityInForeground(MainActivity.class));
        mainActivity.onDestroy();
        assertFalse(mainActivity.isActivityInForeground(MainActivity.class));
    }

    @Test
    public void testAlphaAnimation() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        assertNotNull(mainActivity.createAlphaAnimation());
    }

    @Test
    public void testLogActivityLifecycle() {
        MainActivity mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        mainActivity.logActivityLifecycle("Test log");
    }
}
