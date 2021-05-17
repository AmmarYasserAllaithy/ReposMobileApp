package app.ammar.rippletask.di.module

import app.ammar.rippletask.ui.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}
