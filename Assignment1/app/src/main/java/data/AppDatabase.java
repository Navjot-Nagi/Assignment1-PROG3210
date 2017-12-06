package data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by navjot on 2017-11-29.
 */

@Database(entities = {User.class, Location.class, Weather.class}, version = 16, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //creating object of AppDatabase class
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public abstract LocationDao locationDao();

    public abstract WeatherDao weatherDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "appDatabase").addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            sampleData(context.getApplicationContext());
                        }
                    })
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the exercise, allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    private static void sampleData(Context applicationContext) {
        INSTANCE.userDao().addUser(new User("Navjot Nagi","navi", "Navjot", "Nagi" ));
        INSTANCE.locationDao().addLocation(new Location("Home", "1123 queenston Road", 43.3924381, -80.35378630000002, "Navjot Nagi"));
        INSTANCE.weatherDao().addWeather(new Weather("Raining", "8 C", "2017-12-05", 1));
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}