package app.ammar.rippletask.data.repository

import app.ammar.rippletask.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun search(name: String) = apiHelper.get(name)

}
