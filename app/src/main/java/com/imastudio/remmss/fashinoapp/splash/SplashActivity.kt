package com.imastudio.remmss.fashinoapp.splash

import android.os.Bundle
import android.os.Handler
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.base.BaseActivity
import com.imastudio.remmss.fashinoapp.home.produk.HomePageActivity
import com.imastudio.remmss.fashinoapp.signIn.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({

            if(sesi?.isLoggedIn ?: true) startActivity<HomePageActivity>()
            else startActivity<HomePageActivity>()
            finish()

        },4000)
    }
}
