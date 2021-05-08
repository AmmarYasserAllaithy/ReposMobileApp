package app.ammar.rippletask.data.api

import app.ammar.rippletask.data.model.EntireResponse
import retrofit2.Response


interface ApiHelper {

    suspend fun get(name: String): Response<EntireResponse>

}
