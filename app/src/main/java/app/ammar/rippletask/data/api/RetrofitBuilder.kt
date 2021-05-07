package app.ammar.rippletask.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private const val GITHUB_SEARCH_BASE_URL = "https://api.github.com/search/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_SEARCH_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}
