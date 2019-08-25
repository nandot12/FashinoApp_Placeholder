package com.imastudio.remmss.fashinoapp.profile

import android.os.Bundle
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.base.BaseActivity
import com.imastudio.remmss.fashinoapp.signIn.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        setView()
    }

    private fun setView() {

        profileEmail.text = sesi?.email
        profileHp.text = sesi?.hp
        profileName.text = sesi?.nama

        profileButton.onClick {

            sesi?.logout()
            startActivity<LoginActivity>()
            finish()
        }

    }
}
