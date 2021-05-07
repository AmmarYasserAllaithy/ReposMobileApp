package app.ammar.rippletask.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.ammar.rippletask.data.api.ApiHelper
import app.ammar.rippletask.data.repository.MainRepository
import app.ammar.rippletask.ui.main.viewmodel.MainViewModel


class MainViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(MainRepository(apiHelper)) as T

        throw IllegalArgumentException("Unknown class name")
    }

}
