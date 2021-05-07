package app.ammar.rippletask.data.repository

import app.ammar.rippletask.data.api.ApiHelper
import app.ammar.rippletask.data.model.Repo


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun search(name: String): List<Repo> = apiHelper.getRepos(name)

}
