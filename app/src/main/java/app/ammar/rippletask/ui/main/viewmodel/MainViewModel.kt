package app.ammar.rippletask.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ammar.rippletask.data.model.Repo
import app.ammar.rippletask.data.repository.MainRepository
import app.ammar.rippletask.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _repos = MutableLiveData<Resource<List<Repo>>>()
    val repos: LiveData<Resource<List<Repo>>> get() = _repos

    fun search(name: String) = with(_repos) {
        postValue(Resource.loading(null))

        viewModelScope.launch { postValue(mainRepository.search(parse(name))) }
    }

    private fun parse(name: String) = name.replace(" ", "+")

}
