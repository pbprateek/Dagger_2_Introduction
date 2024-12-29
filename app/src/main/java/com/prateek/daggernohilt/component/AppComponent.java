package com.prateek.daggernohilt.component;


import com.prateek.daggernohilt.module.DriverModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {DriverModule.class})
public interface AppComponent {

    // If we have other Classes in this Component and if we have not Exposed them explicetely then
    //Depedency will not be able to access it

    //Driver getDriver();


    //We will not pass WheelsModule bcz that's abstract and Dagger dosen't initilize them,
    //So we will pass all Modules which are not abstract and have public Constructor

    //ActivityComponent getActivityComponent(DisealEngineModule disealEngineModule);


    //ActivityComponent.Builder getActivityComponentBuilder();


    ActivityComponent.Factory getActivityComponentFactory();


    @Component.Factory
    interface Factory{

        AppComponent create(DriverModule driverModule);
    }

}
