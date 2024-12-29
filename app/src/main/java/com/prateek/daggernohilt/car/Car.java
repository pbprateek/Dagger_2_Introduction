package com.prateek.daggernohilt.car;

import android.util.Log;

import com.prateek.daggernohilt.PerActivity;

import javax.inject.Inject;


@PerActivity
public class Car {

    public static final String TAG = "Car";


    private Wheels wheels;
    private Driver driver;
    @Inject
    Engine engine; //Field injection but no need of any component


//Now dagger knows how to Construct a car but for this to work it should also know the same abt Engine and Wheels

    @Inject
    public Car(Wheels wheels, Driver driver){
        this.wheels = wheels;
        this.driver = driver;
    }



    //This is method injection less commonly used,so here dagger will create Remote for us and inject in into this method
    //It will automatically get triggered..
    //It happens in Following order: Constructor -> Field -> Method

    @Inject
    public void enableRemote(Remote remote){
        remote.setListener(this);
    }

    //Can't think of proper usecase for Method Injection


    public void drive(){
        engine.start();
        Log.d(TAG, driver+" "+driver.name +" driving car "+this);
    }
}
