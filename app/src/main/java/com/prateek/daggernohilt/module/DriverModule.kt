package com.prateek.daggernohilt.module

import com.prateek.daggernohilt.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DriverModule(private val name: String) {
    @Singleton
    @Provides
    fun providesDriver(): Driver {
        return Driver(name)
    }
}
