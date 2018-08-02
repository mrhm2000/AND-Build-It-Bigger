package com.udacity.gradle.builditbigger;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityTestCase;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



/**
 * Created on july 2018
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestEpUnit  extends ActivityTestCase {

    String strJokeResult = null;
    public static final String strEMPTY_STRING = "";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestEndpointUnitTask() throws InterruptedException {

        final CountDownLatch signal = new CountDownLatch(1);

        TaskAsynckEpoint task = new TaskAsynckEpoint();
        task.setListener(new TaskAsynckEpoint.GetJoke() {
            @Override
            public void onComplete(String strJson) {
                strJokeResult = strJson;
                signal.countDown();
            }
        });
            task.execute(mActivityRule.getActivity());

        signal.await(10, TimeUnit.SECONDS);
        assertFalse(strJokeResult.isEmpty());
        onView(withId(R.id.tvJokes)).check(matches(withText(strJokeResult)));

    }
}
