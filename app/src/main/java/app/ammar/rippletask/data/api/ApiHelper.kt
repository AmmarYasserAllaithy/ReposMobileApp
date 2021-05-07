package app.ammar.rippletask.data.api


class ApiHelper(private val apiService: ApiService) {

    suspend fun getRepos(name: String) = apiService.get(name).repos

}
