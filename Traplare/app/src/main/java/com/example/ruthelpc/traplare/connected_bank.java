package com.example.ruthelpc.traplare;

import java.util.ArrayList;
import java.util.List;

public class connected_bank {
    public static List<users_connected> users_connecteds;
    public static void add(users_connected uc){
        if(users_connecteds == null)
            users_connecteds = new ArrayList<>();
        users_connecteds.add(uc);
    }
    public static users_connected get(){
        return users_connecteds.get(0);
    }
}
