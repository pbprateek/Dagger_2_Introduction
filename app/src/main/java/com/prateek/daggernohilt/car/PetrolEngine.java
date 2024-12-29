package com.prateek.daggernohilt.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {

    private static final String TAG = "Car";

    int horsePower;
    int engineCapacity;


    //Bcz we have provided Dagger Car component horsePower and engineCapacity ,so whereever it's needed dagger will put it
    //if we don't provide @Named then Dagger will get confused ,bcz now we have two variables expecting int value,
    //if it was just one int then like in previous part,it would have worked

    @Inject
    public PetrolEngine(@Named("horse power") int horsePower , @Named("engine capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {

        Log.d(TAG, "Petrol engine started. " +
                "\nHorsepower: " + horsePower +
                "\nEngine capacity: " + engineCapacity);
    }
}
