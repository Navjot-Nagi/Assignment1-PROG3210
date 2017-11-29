package data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by navjot on 2017-11-23.
 */
@Entity
public class Weather {
    @PrimaryKey
    public int weatherId;
    public String weatherCondition;
    public String temperature;
    public String lastUpdatedDate;

    public  Weather(int weatherId, String weatherCondition, String temperature, String lastUpdatedDate)
    {
        this.weatherId = weatherId;
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
