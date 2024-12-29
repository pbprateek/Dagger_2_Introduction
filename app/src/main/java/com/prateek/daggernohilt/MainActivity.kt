package com.prateek.daggernohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prateek.daggernohilt.car.Car
import com.prateek.daggernohilt.ui.theme.DaggerNoHiltTheme
import javax.inject.Inject


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerNoHiltTheme {
        Greeting("Android")
    }
}


class MainActivity : ComponentActivity() {


    @Inject
    lateinit var injectFactory: MainViewModelInjectFactory

    val mainViewModel: MainViewModel by lazy {
        getViewmodel(injectFactory)
    }


    lateinit var car: Car

    //For this to work ,variable has to be public or dagger can't change it
    @Inject
    lateinit var car1: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerNoHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }


        //Also if we create one more component then it will have different instance of Driver,So singeleton is only in one
        //Component,For Global Singeleton we will see

        //This won't work now bcz ActivityComponent is a Subcomponent,so we will have to access it using it's parent Component
        /*ActivityComponent component = DaggerActivityComponent.builder().horsePower(1500).engineCapacity(1500)
                .appComponent(((ExampleApplication) getApplication()).getAppComponent()).build();

         */


        /*
        ActivityComponent component = ((ExampleApplication)getApplication()).getAppComponent().getActivityComponentBuilder()
                .engineCapacity(170).horsePower(190).build();

         */
        val component =
            (application as ExampleApplication).appComponent.activityComponentFactory.create(
                170,
                150
            )



        component.inject(this@MainActivity)

        //We can't do constructor injection here bcz we don't create MainInjection
        //So we use Field Injection ,basically for android and all
        car = component.car

        car.drive()

        car1.drive()

        mainViewModel.drive()


        //Now we can see in log that instance of car and Driver are same for both car and car1,but if we rotate the device instance
        //of Car will be changed but for driver it will be same bcz that's app level
    }
}
