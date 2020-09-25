package com.github.fgoncalves.qa

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.login_frag.*

data class User(val email: String, val pwd: String)

class LoginFragment : Fragment() {
    private val availableAccounts = listOf(
        User("percival@gmail.com", "123456"),
        User("arthur@gmail.com", "98765")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.login_frag, container, false)

    override fun onResume() {
        super.onResume()

        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {
        // Reset errors.
        email.error = null
        password.error = null

        // Store values at the time of the login attempt.
        val emailStr = email.text.toString()
        val passwordStr = password.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        when {
            !TextUtils.isEmpty(passwordStr) && !isPasswordValid(passwordStr) -> {
                password.error = getString(R.string.error_invalid_password)
                focusView = password
                cancel = true
            }

            TextUtils.isEmpty(emailStr) -> {
                email.error = getString(R.string.error_field_required)
                focusView = email
                cancel = true
            }

            !isEmailValid(emailStr) -> {
                email.error = getString(R.string.error_invalid_email)
                focusView = email
                cancel = true
            }

            userDoesNotExist(emailStr) -> {
                email.error = getString(R.string.error_user_does_not_exist)
                focusView = email
                cancel = true
            }

            passwordsDontMatch(emailStr, passwordStr) -> {
                password.error = getString(R.string.error_wrong_password)
                focusView = password
                cancel = true
            }
        }

        // Check for a valid email address.
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true)

            login()
        }
    }

    private fun passwordsDontMatch(emailStr: String, passwordStr: String) =
        availableAccounts.find { it.email == emailStr }?.let { it.pwd != passwordStr } == true

    private fun userDoesNotExist(emailStr: String) =
        !(availableAccounts.map { it.email }.contains(emailStr.toLowerCase()))

    private fun login() {
        view?.apply {
            postDelayed({
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }, 5000)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > PWD_MIN_LENGTH
    }

    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

        login_form.visibility = if (show) View.GONE else View.VISIBLE
        login_form.animate()
            .setDuration(shortAnimTime)
            .alpha((if (show) 0 else 1).toFloat())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    login_form.visibility = if (show) View.GONE else View.VISIBLE
                }
            })

        login_progress.visibility = if (show) View.VISIBLE else View.GONE
        login_progress.animate()
            .setDuration(shortAnimTime)
            .alpha((if (show) 1 else 0).toFloat())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    login_progress.visibility = if (show) View.VISIBLE else View.GONE
                }
            })
    }

    companion object {
        const val PWD_MIN_LENGTH = 4
    }
}
