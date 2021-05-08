package app.ammar.rippletask.data.api

import app.ammar.rippletask.data.model.EntireResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("search/repositories")
    suspend fun get(@Query("q") name: String): Response<EntireResponse>

}
