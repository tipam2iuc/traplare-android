package com.example.ruthelpc.traplare;

import java.util.ArrayList;
import java.util.List;

public class connected_bank {
    public static List<StaticsFunctions> users_connecteds;
    public static void add(StaticsFunctions uc){
        if(users_connecteds == null)
            users_connecteds = new ArrayList<>();
        users_connecteds.add(uc);
    }
    public static StaticsFunctions get(){
        return users_connecteds.get(0);
    }
}
