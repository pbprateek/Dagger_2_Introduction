package com.prateek.daggernohilt;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;



/*
This is not a special annotation,it's identical to @Singelton but we have named it PerActivity so we should use this
in Components which will be declared in Activities so that it remains Singelton only to that activity..


Also something which u will get slowely,(Why don't we put Singeleton Everywhere bcz anyway they are doing the Same thing?)

One reason is that we don't put the module in Wrong Component

Answer is bcz We also annotate the Component with Scope Annotation, So if we just had annotation we won't be able
 to tell dagger that we need to Scope this class to Which Component...

 */


@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity { }
