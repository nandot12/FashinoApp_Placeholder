package com.imastudio.remmss.fashinoapp.signUp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.network.ConfigNetwork
import com.imastudio.remmss.fashinoapp.signIn.LoginActivity
import com.imastudio.remmss.fashinoapp.signUp.model.ResponseSignUp
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        initView()
    }

    private fun initView() {

        registerBtnSignup.onClick {

            actionRegister()
        }


    }

    private fun actionRegister() {
        if (registerEmail.text.toString() != "" && registerName.text.toString() != "" && registerPass.text.toString() != ""
                && registerhp.text.toString() != "" && registerConfirmPass.text.toString() != "") {
            actionSignUp()
        } else {

            toast("tidak boleh kosong")
        }


    }

    private fun actionSignUp() {
        ConfigNetwork.retrofit.registr(
                registerEmail.text.toString(),
                registerName.text.toString(),
                registerhp.text.toString(),
                registerPass.text.toString()).enqueue(object : Callback<ResponseSignUp> {
            override fun onFailure(call: Call<ResponseSignUp>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ResponseSignUp>?, response: Response<ResponseSignUp>?) {
                result(response)
            }
        })
    }

    private fun result(response: Response<ResponseSignUp>?) {

        val sukses = response?.body()?.sukses
        val pesan = response?.body()?.pesan

        if(if (sukses != null) sukses else throw NullPointerException("Expression 'sukses' must not be null")){ startActivity<LoginActivity>()
        }else toast(pesan!!)



    }
}