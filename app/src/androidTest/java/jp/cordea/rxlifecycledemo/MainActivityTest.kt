package jp.cordea.rxlifecycledemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Yoshihiro Tanaka on 2017/06/14.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testInitialState() {
        val title = "Subscribe"

        onView(withId(R.id.switch_compat))
                .check(matches(isNotChecked()))

        onView(withId(R.id.title_text_view))
                .check(matches(withText(title)))
    }

    @Test
    fun testCheckedState() {
        val title = "Subscribe with RxLifecycle"

        onView(withId(R.id.switch_compat))
                .perform(click())
                .check(matches(isChecked()))

        onView(withId(R.id.title_text_view))
                .check(matches(withText(title)))
    }
}