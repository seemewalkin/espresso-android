//package com.github.fgoncalves.qa
//
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.platform.app.InstrumentationRegistry
//import androidx.test.rule.ActivityTestRule
//import android.os.SystemClock
//import org.junit.Assert.assertEquals
//import java.util.regex.Pattern.matches
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.ViewAssertion
//import androidx.test.espresso.action.ViewActions.typeText
//import androidx.test.espresso.action.ViewActions
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.matcher.ViewMatchers.*
//import androidx.test.espresso.matcher.ViewMatchers.withText
//import androidx.test.espresso.assertion.ViewAssertions.*
//import androidx.test.espresso.matcher.ViewMatchers
//import java.util.regex.Pattern.matches
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * See [testing documentation](http://d.android.com/tools/testing).
// */
//@RunWith(AndroidJUnit4::class)
//
//class ExampleInstrumentedTest {
//    @get:Rule
//    var activityRule: ActivityTestRule<MainActivity>
//            = ActivityTestRule(MainActivity::class.java)
//
//    @Test
//    fun userSeesValidationForShortText() {
//        // Type text and then press the button.
//        onView(withId(R.id.email))
//            .perform(typeText("yo."));
//
//        onView(withId(R.id.password))
//            .perform(typeText("hey"))
//
//        onView(withId(R.id.email_sign_in_button))
//            .perform(click())
//
////        onView(withText(R.string.error_invalid_password))
//    }
//
//    @Test
//    fun userIsAbleToSignInWithCorrectDataAndSeesSpinnerAndImage() {
//        // Type text and then press the button.
//        onView(withId(R.id.email))
//            .perform(typeText("percival@gmail.com"));
//
//        onView(withId(R.id.password))
//            .perform(typeText("123456"))
//
//        onView(withId(R.id.email_sign_in_button))
//            .perform(click())
//
//        onView(withId(R.id.login_progress))
//            .check(matches(isDisplayed()))
//
//        SystemClock.sleep(5000)
//
//        onView(withId(R.id.imageOfTheHouse))
//            .check(matches(isDisplayed()))
//    }
//}
