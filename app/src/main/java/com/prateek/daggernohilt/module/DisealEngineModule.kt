package com.prateek.daggernohilt.module

import com.prateek.daggernohilt.car.DisealEngine
import com.prateek.daggernohilt.car.Engine
import dagger.Module
import dagger.Provides


@Module
class DisealEngineModule(private val horsePower: Int) {
    @Provides
    fun provideHorsePower(): Int {
        return horsePower
    }

    @Provides
    fun provideEngine(engine: DisealEngine): Engine {
        return engine
    }
}
