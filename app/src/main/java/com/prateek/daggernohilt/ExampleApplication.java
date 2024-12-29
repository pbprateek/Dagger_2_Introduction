package com.prateek.daggernohilt;

import android.app.Application;

import com.prateek.daggernohilt.component.AppComponent;
import com.prateek.daggernohilt.component.DaggerAppComponent;
import com.prateek.daggernohilt.module.DriverModule;

public class ExampleApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.factory().create(new DriverModule("Prateek"));
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
