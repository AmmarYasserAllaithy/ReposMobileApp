package app.ammar.rippletask.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ammar.rippletask.data.model.Repo
import app.ammar.rippletask.data.repository.MainRepository
import app.ammar.rippletask.utils.NetworkHelper
import app.ammar.rippletask.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _repos = MutableLiveData<Resource<List<Repo>>>()
    val repos: LiveData<Resource<List<Repo>>> get() = _repos

    fun search(name: String) {
        viewModelScope.launch {
            _repos.postValue(Resource.loading(null))

            if (networkHelper.isNetworkConnected()) {

                mainRepository.search(parse(name)).let {
                    if (it.isSuccessful) _repos.postValue(Resource.success(it.body()!!.repos))
                    else _repos.postValue(Resource.error(it.errorBody().toString(), null))
                }

            } else _repos.postValue(Resource.error("No internet connection", null))
        }
    }

    private fun parse(name: String) = name.replace(" ", "+")

}
