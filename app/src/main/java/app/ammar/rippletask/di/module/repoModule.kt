package app.ammar.rippletask.di.module

import app.ammar.rippletask.data.repository.MainRepository
import org.koin.dsl.module


val repoModule = module {
    single {
        MainRepository(get())
    }
}
