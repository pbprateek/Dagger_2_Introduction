package com.prateek.daggernohilt.car;

public class Driver {
    //we don't own this class so we can't put @Inject,
    //let's suppose we want Driver as a global Singeleton like an okHTTP client
    public String name;

    public Driver(String name){

        this.name = name;
    }



}
