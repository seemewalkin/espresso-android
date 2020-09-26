package com.github.fgoncalves.qa

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.github.fgoncalves.qa.pageObject.LoginPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.github.fgoncalves.qa.pageObject.HomePage
import com.github.fgoncalves.qa.pageObject.WelcomePage
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class LoginTests {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun A_userIsNotAbleToSignInWithInexistentAccount () {
        LoginPage.onLoginFormPage().apply {
            signInWithEmailAndPass("nonexist@yo.com", "whatever")
            verifyTextIsVisible("Account does not exist", activityRule)
        }
    }

    @Test
    fun B_userSeesValidationOnIncorrectPassword () {
        LoginPage.onLoginFormPage().apply {
            signInWithEmailAndPass("arthur@gmail.com","987653141")
            verifyTextIsVisible("Wrong password", activityRule)
        }
    }
    @Test
    fun C_userSeesValidationAfterSignInWithEmptyInputs () {
        LoginPage.onLoginFormPage().apply {
            tapLoginButton()
            verifyTextIsVisible("This field is required", activityRule)
        }
    }

    @Test
    fun D_userIsAbleToSignIn() {
        LoginPage.onLoginFormPage().apply {
            signInWithEmailAndPass("percival@gmail.com", "123456")
        }

        HomePage.onHomePage().apply {
            isSpinnerVisible()
            waitForImageToBeDisplayed()
            tapClickMeButton()
        }

        WelcomePage.onWelcomePage().apply {
            isWelcomeTextDisplayed()
            tapOnClickMeBtn()
            verifyTextIsVisible("Capture me while you can!", activityRule)
        }
    }
}
