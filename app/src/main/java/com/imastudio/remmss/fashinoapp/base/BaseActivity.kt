package com.imastudio.remmss.fashinoapp.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.imastudio.remmss.fashinoapp.utils.SessionManager

open class BaseActivity : AppCompatActivity() {

    protected var sesi : SessionManager? = null
    protected var c : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        c = this
        sesi = SessionManager(c as BaseActivity)

    }
}
