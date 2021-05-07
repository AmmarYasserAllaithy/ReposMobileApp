package app.ammar.rippletask.data.api

import app.ammar.rippletask.data.model.EntireResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("repositories")
    suspend fun get(@Query("q") name: String): EntireResponse

}
