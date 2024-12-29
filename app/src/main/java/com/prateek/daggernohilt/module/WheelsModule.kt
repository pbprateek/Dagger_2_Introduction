package com.prateek.daggernohilt.module

import com.prateek.daggernohilt.car.Rims
import com.prateek.daggernohilt.car.Tires
import com.prateek.daggernohilt.car.Wheels
import dagger.Module
import dagger.Provides


@Module
object WheelsModule {
    //You can also make these methods static as it adds lil bit performance
    @JvmStatic
    @Provides
    fun provideRims(): Rims {
        return Rims()
    }


    @JvmStatic
    @Provides
    fun provideTires(): Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @JvmStatic
    @Provides
    fun provideWheels(rims: Rims?, tires: Tires?): Wheels {
        return Wheels(rims, tires)
    }
}
