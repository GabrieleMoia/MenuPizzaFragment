package com.example.giulia.menufragment;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giulia on 22/02/2018.
 */

public class Utils {

    public static void initDataSource(Context context){
        List<Pizza> pizzaList=new ArrayList<Pizza>();

        pizzaList.add(new Pizza("Margherita","Pomodoro, Mozzarella, Basilico"));
        pizzaList.add(new Pizza("Capricciosa", "Pomodoro, Mozzarella, Carciofi, Funghi, Prosciutto, Olive, Capperi"));
        pizzaList.add(new Pizza("Napoli", "Pomodoro, Mozzarella, Alici, Origano"));

        Singleton.getInstance().setItemList(pizzaList);
    }

    public static List<Pizza> getDataSource(){
        return Singleton.getInstance().getItemList();
    }

    public static Pizza getItemByPosition(Context context, int positon) {
        Pizza contByPos = Singleton.getInstance().getItemList().get(positon);
        return contByPos;
    }
}
