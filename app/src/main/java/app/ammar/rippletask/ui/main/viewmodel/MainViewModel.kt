package app.ammar.rippletask.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.ammar.rippletask.data.repository.MainRepository
import app.ammar.rippletask.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun get(name: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            emit(Resource.success(mainRepository.search(name)))

        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!", null))
        }
    }

}
