package com.imastudio.remmss.fashinoapp.signIn

import android.os.Bundle

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.imastudio.remmss.fashinoapp.network.ConfigNetwork
import com.imastudio.remmss.fashinoapp.signIn.model.ResponseSignIn
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import android.content.Intent
import com.imastudio.remmss.fashinoapp.signUp.SignUpActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.base.BaseActivity
import com.imastudio.remmss.fashinoapp.home.produk.HomePageActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LoginActivity :BaseActivity() {

    var disposable : CompositeDisposable? = null


    private var RC_SIGN_IN = 1
    var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        disposable = CompositeDisposable()

        initView()
        initGmail()


    }

    private fun initGmail() {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun initView() {
        loginlinkSignUp.onClick {

            startActivity<SignUpActivity>()
        }

        loginGoogle.onClick {

            signIn()
        }

        loginBtn.onClick {

            if (loginEmail.text.toString() != "" && loginPassword.text.toString() != "") {

                actionLogin()

            } else {
                toast("tidak boleh kosong")

            }

        }

    }

    private fun actionLogin() {


        disposable?.add(  ConfigNetwork.retrofit.login(loginEmail.text.toString(),
                loginPassword.text.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({

                    t ->
                    actionResult(t)
                },
                        {

                        }))






    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {
        val name = task?.result?.displayName
        val email = task?.result?.email

        ConfigNetwork.retrofit.logingmail(name ?: "", email ?: "", "0", "n").enqueue(object : Callback<ResponseSignIn> {

            override fun onFailure(call: Call<ResponseSignIn>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ResponseSignIn>?, response: Response<ResponseSignIn>?) {

                val responses = response?.body()?.sukses

                if(responses ?: true){

                }
                else{
                    toast("failed login")
                }
            }
        })


    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient?.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun actionResult(response: ResponseSignIn) {

        if(response.sukses ?: true){
            var user = response.data

            sesi?.email = user?.userEmail
            sesi?.nama = user?.userNama
            sesi?.hp = user?.userHp
            sesi?.createLoginSession("1")


            startActivity<HomePageActivity>()
        }
        else toast(response.pesan ?: "")


    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }

    override fun onStart() {
        super.onStart()



    }
}
