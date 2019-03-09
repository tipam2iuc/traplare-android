package com.example.ruthelpc.traplare.modele;

import android.content.Context;

import com.example.ruthelpc.traplare.Serializer;
import com.example.ruthelpc.traplare.users_connected;

public  class Usertools {
private static users_connected u;
private static String data="profil";

public static void  saveConnect(String username, String firstname, Context context)
{
    u=new users_connected(username,firstname);
    Serializer.Serilize(data,u,context);
}

    public static users_connected  getConnect(Context context)
    {
        u=(users_connected) Serializer.Deserialize(data,context);
      return  u;
    }

}
