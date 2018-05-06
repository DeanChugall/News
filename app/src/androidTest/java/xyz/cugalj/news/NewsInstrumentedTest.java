package xyz.cugalj.news;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented getNewsData, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NewsInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under getNewsData.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("xyz.cugalj.news", appContext.getPackageName());
    }
}
