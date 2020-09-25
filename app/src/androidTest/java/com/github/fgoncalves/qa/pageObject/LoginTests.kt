package com.github.fgoncalves.qa


import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.github.fgoncalves.qa.MainActivity
import com.github.fgoncalves.qa.R
import com.github.fgoncalves.qa.pageObject.LoginPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.os.SystemClock
import com.github.fgoncalves.qa.pageObject.HomePage
import com.github.fgoncalves.qa.pageObject.WelcomePage

@RunWith(AndroidJUnit4::class)

class ExampleInstrumentedTest {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userIsAbleToSignIn() {
        LoginPage.onLoginFormPage().apply {
            fillEmail("percival@gmail.com")
            fillPassword("123456")
            tapLoginButton()
          SystemClock.sleep(10000)

        HomePage.onHomePage().apply {
            isHomeImageVisible()
            tapClickMeButton()
            SystemClock.sleep(10000)
        }


        WelcomePage.onWelcomePage().apply {
            isWelcomeTextDisplayed()
            tapOnClickMeBtn()
            isToastTextVisible()
        }

        }
    }
}