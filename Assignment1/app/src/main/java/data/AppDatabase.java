package data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by navjot on 2017-11-29.
 */

@Database(entities = {User.class}, version = 16, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
//creating object of AppDatabase calss
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

}
