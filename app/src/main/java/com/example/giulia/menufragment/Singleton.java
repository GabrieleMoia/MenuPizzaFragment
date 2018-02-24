package com.example.giulia.menufragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giulia on 22/02/2018.
 */

public class Singleton {

    private static Singleton ourInstance = new Singleton();
    private List<Pizza> pizzaList;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

    }

    public void setItemList(List<Pizza> contactList) {
        this.pizzaList = contactList;
    }

    public List<Pizza> getItemList() {
        return pizzaList;
    }


}
