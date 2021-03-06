package edu.uc.app.parkfinder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var retrofit: Retrofit? = null
private const val BASE_URL = "https://pkgstore.datahub.io"

object RetrofitClientInstance {


    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}