package com.app.android.deal.dealclub.Bus;

import com.squareup.otto.Bus;

public class BusProvider {

    private static Bus bus;


    public static Bus getInstance()
    {


        return  bus =new Bus();
    }
}
