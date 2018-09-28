package com.indigosports.webrootlogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.content_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        actionBar?.title = getString(R.string.title_activity_profile)

        val prefs = AppSharedPreferences(this)
        val currentUser = prefs.getString("currentUser", "")
        if (currentUser.isNullOrEmpty()) {
            //create profile

        } else {
            email_input.setText(currentUser)
            email_label.text = getString(R.string.your_email)
            password_label.text = getString(R.string.update_password)
            create_profile.text = getString(R.string.update)

        }

        password_input.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    if (isValidUserNameAndPassword()) {
                        addUser()
                        true
                    } else {
                        false
                    }
                }
                else -> false
            }
        }

        create_profile.setOnClickListener{
            if (isValidUserNameAndPassword() ) {
                addUser()
            }
        }
    }


    private fun isValidUserNameAndPassword() :Boolean {

        val emailStr = email_input.text.toString()
        val passwordStr = password_input.text.toString()

        var valid = true
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!LoginUtils.isPasswordValid(passwordStr)) {
            password_input.error = getString(R.string.error_invalid_password)
            focusView = password_input
            valid = false
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            email_input.error = getString(R.string.error_field_required)
            focusView = email_input
            valid = false
        } else if (!LoginUtils.isEmailValid(emailStr)) {
            email_input.error = getString(R.string.error_invalid_email)
            focusView = email_input
            valid = false
        }
        if (!valid) {
            focusView?.requestFocus()
        }
        return valid
    }

    private fun addUser() {
        val emailStr = email_input.text.toString()
        val passwordStr = password_input.text.toString()

        val prefs = AppSharedPreferences(this)

        var message = ""
        if (!prefs.prefsContains(emailStr)) {
            // NEW
            prefs.setString(emailStr, passwordStr)
            message = getString(R.string.signedUp)
        } else {
            // UPDATE
            prefs.setString(emailStr, passwordStr)
            message = getString(R.string.passwordChanged)
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        finish()



//        return if (prefs.prefsContains(mEmail)) {
//            if (prefs.getString(mEmail, "") == mPassword) "success" else "Username and password do not match."
//        } else "Username not found."
    }
}
