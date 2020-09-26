package com.github.fgoncalves.qa.pageObject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.github.fgoncalves.qa.R

class LoginPage : BasePage() {

    companion object {
        private val LOGIN_FORM_PAGE: LoginPage by lazy {
            LoginPage().also {
                onView(withId(R.id.email_sign_in_button)).check(matches(isDisplayed()))
            }
        }

        fun onLoginFormPage() = LOGIN_FORM_PAGE
    }

    fun signInWithEmailAndPass(email: String, password: String) = this.also {
        onView(withId(R.id.email))
            .perform(replaceText(email), closeSoftKeyboard())
        onView(withId(R.id.password))
            .perform(replaceText(password), closeSoftKeyboard())
        onView(withId(R.id.email_sign_in_button))
            .perform(click())
    }

    fun tapLoginButton() = this.also {
        onView(withId(R.id.email_sign_in_button))
            .perform(click())
    }
}
