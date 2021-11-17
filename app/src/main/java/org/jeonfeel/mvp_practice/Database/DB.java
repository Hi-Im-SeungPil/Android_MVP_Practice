package org.jeonfeel.mvp_practice.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {org.jeonfeel.mvp_practice.Database.infoDTO.class},version = 1)
public abstract class DB extends RoomDatabase {

    public abstract org.jeonfeel.mvp_practice.Database.infoDAO infoDAO();

    private static DB instance;

    private static final Object sLock = new Object();

    public static DB getInstance(Context context){
        synchronized (sLock){
            if (instance == null){
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        DB.class,
                        "DB")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return instance;
        }
    }

}
