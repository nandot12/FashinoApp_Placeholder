package com.imastudio.remmss.fashinoapp.network

import com.imastudio.remmss.fashinoapp.detailProdukkategori.model.ResultProdukPerKategori
import com.imastudio.remmss.fashinoapp.home.produk.modelKategori.ResponseKategori
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.ResponseProduk
import com.imastudio.remmss.fashinoapp.signIn.model.ResponseSignIn
import com.imastudio.remmss.fashinoapp.signUp.model.ResponseSignUp
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @FormUrlEncoded
    @POST("produkPerKategori")
    fun getProdukPerkategori(@Field("idkategori")idkategori : String):Flowable<ResultProdukPerKategori>

    @GET("produk")
    fun getProduk():Flowable<ResponseProduk>

    @GET("kategori")
    fun getKategori():Flowable<ResponseKategori>


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email : String,
              @Field("password") password : String) :Single<ResponseSignIn>


    @FormUrlEncoded
    @POST("loginGmail")
    fun logingmail(@Field("email") email : String,@Field("name") name : String,
                   @Field("hp") hp : String,
                   @Field("password") password : String) : Call<ResponseSignIn>


    @FormUrlEncoded
    @POST("register")
    fun registr(@Field("email") email : String,@Field("name") name : String,
                @Field("hp") hp : String,
              @Field("password") password : String) : Call<ResponseSignUp>

}