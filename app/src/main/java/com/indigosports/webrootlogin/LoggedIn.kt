package com.indigosports.webrootlogin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_logged_in.*

class LoggedIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val signedInIntent = Intent(this, ProfileActivity::class.java)
            startActivity(signedInIntent)
        }

        fab_logout.setOnClickListener { view ->
            val prefs = AppSharedPreferences(this)
            prefs.setString("currentUser" , "")
            finish()
        }
    }

}
