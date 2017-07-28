package com.example.kotlinnullability

import android.support.test.*
import android.support.test.runner.*
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class) class ExampleInstrumentedTest {
    @Test fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("kotlinnullability.android.example.com.kotlinandroidnullability", appContext.packageName)
    }
}
