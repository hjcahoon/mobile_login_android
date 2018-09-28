package com.indigosports.webrootlogin

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginUtilsTest {

    @Test
    fun emptyEmail() {
        assertFalse(LoginUtils.isEmailValid(""))
    }

    @Test
    fun missingAtSymEmail() {
        assertFalse(LoginUtils.isEmailValid("asdf.df"))
    }

    @Test
    fun missingDotEmail() {
        assertFalse(LoginUtils.isEmailValid("sdfas@sagasd"))
    }

    @Test
    fun noCharAfterDot() {
        assertFalse(LoginUtils.isEmailValid("asdfas@agg."))
    }

    @Test
    fun noCharBeforeAtSym() {
        assertFalse(LoginUtils.isEmailValid("@agg.sfd"))
    }

    @Test
    fun multipleAtSym() {
        assertFalse(LoginUtils.isEmailValid("agg@@dd.sfd"))
        assertFalse(LoginUtils.isEmailValid("aa@geee@dd.sfd"))
        assertFalse(LoginUtils.isEmailValid("ag@gadg@age@dd.sfd"))
    }

    @Test
    fun lastDotBeforeAtSym() {
        assertFalse(LoginUtils.isEmailValid("aseag.asdf@gae"))
        assertFalse(LoginUtils.isEmailValid("asdfasdf.@hj"))

        assertTrue(LoginUtils.isEmailValid("asdfas.ea@asga.aer"))
        assertTrue(LoginUtils.isEmailValid("asdf.asdfa@agea.asdf"))
    }

    @Test
    fun charactersBetweenAtSymAndDot() {
        assertFalse(LoginUtils.isEmailValid("asdfasdf@.asdf"))

    }

    @Test
    fun numbersAllowed() {
        assertTrue(LoginUtils.isEmailValid("sd32@sdf43.3"))
        assertTrue(LoginUtils.isEmailValid("23asdfas@whpr.pb"))
    }

    @Test
    fun passwordIs8Chars() {
        assertTrue(LoginUtils.isPasswordValid("asdfasH8"))
    }


}