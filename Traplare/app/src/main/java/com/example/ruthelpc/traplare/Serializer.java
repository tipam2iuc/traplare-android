package com.example.ruthelpc.traplare;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public abstract class Serializer {

    public  static void Serilize(String filename, Object object, Context context)
    {
        try
        {
            FileOutputStream file=context.openFileOutput(filename,Context.MODE_PRIVATE);
            ObjectOutputStream oos;
            try
            {
                oos=new ObjectOutputStream(file);
                oos.writeObject(object);
                oos.flush();
                oos.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static Object Deserialize(String filename,Context context)
    {
        try
        {
            FileInputStream file=context.openFileInput(filename);
            ObjectInputStream ois;
            try
            {
                ois=new ObjectInputStream(file);
                try
                {
                    Object object=ois.readObject();
                    ois.close();
                    return object;
                }
                catch (ClassNotFoundException ex)
                {
                    ex.printStackTrace();
                }

            }
            catch (StreamCorruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}
