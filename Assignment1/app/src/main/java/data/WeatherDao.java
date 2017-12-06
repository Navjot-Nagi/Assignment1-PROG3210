package data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
/**
 * Created by navjot on 2017-11-24.
 */
import java.util.List;
@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void addWeather(Weather weather);

    @Query("select * from weather")
    public List<Weather> getWeather();
}
