package app.ammar.rippletask.data.repository

import app.ammar.rippletask.data.api.ApiHelper
import app.ammar.rippletask.utils.NetworkHelper
import app.ammar.rippletask.utils.Resource


class MainRepository(private val apiHelper: ApiHelper, private val networkHelper: NetworkHelper) {

    suspend fun search(name: String) =
        if (networkHelper.isNetworkConnected())
            with(apiHelper.get(name)) {
                if (isSuccessful) Resource.success(body()!!.repos)
                else Resource.error(errorBody().toString(), null)
            }
        else Resource.error("No internet connection", null)

}
