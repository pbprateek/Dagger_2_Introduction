package com.prateek.daggernohilt.car;

//So how we will tell Dagger to construct Wheels rims and tires,So we Have Module for that

public class Wheels {

    //Assume we don't won this class and is part of some library,so we can't annotate it with @Inject

    private Rims rims;
    private Tires tires;

    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
