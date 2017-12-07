package data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
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
            INSTANCE = buildDatabase(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, "appDatabase")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull final SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        ContentValues values = new ContentValues();
                        values.put("userName", "Navjot Nagi");
                        values.put("password", "navi");
                        values.put("firstName", "Navjot");
                        values.put("lastName", "Nagi");
                        db.insert("user", 1, values);
                        values.clear();
                        values.put("name", "Home");
                        values.put("address", "1123 queenston Road");
                        values.put("latitude", 43.3924381);
                        values.put("longiude", -80.35378630000002);
                        values.put("userName", "Navjot Nagi");
                        db.insert("location", 1, values);
                        values.clear();
                        values.put("weatherCondition", "Raining");
                        values.put("temperature", "8 C");
                        values.put("lastUpdatedDate", "2017-12-05");
                        values.put("locationId", 1);
                        db.insert("weather", 1, values);
                        values.clear();
                    }
                }).allowMainThreadQueries().build();
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}