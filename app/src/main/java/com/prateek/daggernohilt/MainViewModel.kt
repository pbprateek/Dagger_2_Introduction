package com.prateek.daggernohilt

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prateek.daggernohilt.car.Car
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Provider


@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> ComponentActivity.getViewmodel(
    provider: Provider<T>
): T {
    return ViewModelProvider(this,
        object : AbstractSavedStateViewModelFactory() {
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return provider.get() as T
            }
        }
    )[T::class.java]
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> ComponentActivity.getViewmodel(
    assistedFactory:MainViewModelInjectFactory
): T {
    return ViewModelProvider(this,
        object : AbstractSavedStateViewModelFactory() {
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return assistedFactory.create(handle) as T
            }
        }
    )[T::class.java]
}


@AssistedFactory
interface MainViewModelInjectFactory {
    fun create(savedStateHandle: SavedStateHandle): MainViewModel
}


class MainViewModel @AssistedInject constructor(
    private val car: Car,
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {


    fun drive() {
        Log.d("HURRRRRRRRRRRRRRR", "HURRRRRRRRRRRRRRRRRR")
        car.drive()
    }

}