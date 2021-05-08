package app.ammar.rippletask.data.api


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun get(name: String) = apiService.get(name)

}
