package com.github.fgoncalves.qa.pageObject

import android.view.View
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import com.github.fgoncalves.qa.pageObject.EspressoExtensions.waitForView
import org.hamcrest.Matcher


abstract class BasePage {

    fun doOnView(matcher: Matcher<View>, vararg actions: ViewAction) {
        actions.forEach {
            waitForView(matcher).perform(it)
        }
    }

    fun assertOnView(matcher: Matcher<View>, vararg assertions: ViewAssertion) {
        assertions.forEach {
            waitForView(matcher).check(it)
        }
    }
}