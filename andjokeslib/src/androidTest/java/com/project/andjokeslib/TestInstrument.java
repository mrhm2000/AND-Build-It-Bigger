package com.project.andjokeslib;
import org.junit.runner.RunWith;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import android.support.test.InstrumentationRegistry;
import android.content.Context;



import static org.junit.Assert.*;

/**
 * Created on july 2018
 */

@RunWith(AndroidJUnit4.class)

public class TestInstrument {
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.project.andjokeslib.test", appContext.getPackageName());
    }
}
