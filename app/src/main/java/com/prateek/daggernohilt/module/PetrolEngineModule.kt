package com.prateek.daggernohilt.module

import com.prateek.daggernohilt.car.Engine
import com.prateek.daggernohilt.car.PetrolEngine
import dagger.Module
import dagger.Provides


@Module
class PetrolEngineModule {
    @Provides
    fun provideEngine(petrolEngine: PetrolEngine): Engine {
        return petrolEngine
    }
}
