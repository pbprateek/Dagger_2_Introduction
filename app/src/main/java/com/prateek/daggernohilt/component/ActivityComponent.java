package com.prateek.daggernohilt.component;


//Component creates the Injection graph
//The injector


import com.prateek.daggernohilt.car.Car;
import com.prateek.daggernohilt.MainActivity;
import com.prateek.daggernohilt.PerActivity;
import com.prateek.daggernohilt.module.WheelsModule;
import com.prateek.daggernohilt.module.PetrolEngineModule;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;

//@Component

//We also will have to annotate the Componenet with Singeleton,Even if one Class in the Component is Singeleton
//We can also put Singelton Directly above @Bind or @Provides



//Now we will convert this Component to Subcomponent,then it will be able to access all the dependency graph of
//Parent Component without Exposing them Explictly in Parent Component

@PerActivity
@Subcomponent(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface ActivityComponent {


    Car getCar();

    //We can't pass superclass here,So if we have something like BaseActivity ,that won't work
    void inject(MainActivity mainActivity);


    /*
    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        //Builder appComponent(AppComponent component);//We don't need this anymore,bcz it's a subcomponent and it can
        //directly access all the depedency graph of parent

        ActivityComponent build();
    }
     */



    //@Subcomponent.Factory -> Advantage is that it's concise and provide compile time safety as we will have to
    //pass all the arguments,but we can't use Factory if we have to pass optional arguments


    @Subcomponent.Factory
    interface Factory{
        ActivityComponent create(@BindsInstance @Named("horse power") int horsePower,
                                 @BindsInstance @Named("engine capacity") int engineCapacity);
    }

}
