package com.indigosports.webrootlogin

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class AppSharedPreferences (context: Context) {

    private var prefs = PreferenceManager.getDefaultSharedPreferences(context)
    private var prefsEditor: SharedPreferences.Editor? = null


    fun registerSharedPrefsChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        prefs.registerOnSharedPreferenceChangeListener(listener)
    }


    fun prefsContains(key: String): Boolean {
        return prefs.contains(key)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        prefsEditor = prefs.edit()
        prefsEditor!!.putInt(key, value)
        prefsEditor!!.apply()
    }


    fun getString(key: String, defaultValue: String): String? {
        return prefs.getString(key, defaultValue)
    }

    fun setString(key: String, value: String) {
        prefsEditor = prefs.edit()
        prefsEditor!!.putString(key, value)
        prefsEditor!!.apply()
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return prefs.getLong(key, defaultValue)
    }

    fun setLong(key: String, value: Long) {
        prefsEditor = prefs.edit()
        prefsEditor!!.putLong(key, value)
        prefsEditor!!.apply()
    }

    private fun getFloat(key: String, defaultValue: Float): Float {
        return prefs.getFloat(key, defaultValue)
    }

    private fun setFloat(key: String, value: Float) {
        prefsEditor = prefs.edit()
        prefsEditor!!.putFloat(key, value)
        prefsEditor!!.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        prefsEditor = prefs.edit().putBoolean(key, value)
        prefsEditor!!.putBoolean(key, value)
        prefsEditor!!.apply()
    }


}