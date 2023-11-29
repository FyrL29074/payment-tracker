package com.fyrl29074.payment_tracker.data

import com.fyrl29074.payment_tracker.data.model.LoginBody
import com.fyrl29074.payment_tracker.data.model.PaymentResponse
import com.fyrl29074.payment_tracker.data.model.TokenDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


const val BASE_URL = "https://easypay.world/api-test/"

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mainApi: MainApi = retrofit.create(MainApi::class.java)
}

interface MainApi {
    @Headers(
        "app-key: 12345",
        "v: 1"
    )
    @POST("login")
    suspend fun login(@Body loginBody: LoginBody): Response<TokenDto>

    @Headers(
        "app-key: 12345",
        "v: 1",
    )
    @GET("payments")
    suspend fun getPayments(@Header("token") token: String): Response<PaymentResponse>
}