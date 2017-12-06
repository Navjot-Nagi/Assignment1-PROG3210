package data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by navjot on 2017-11-23.
 */
@Entity(tableName = "Weather",
        foreignKeys = {
                @ForeignKey(
                        entity = Location.class,
                        parentColumns = "locationId",
                        childColumns = "locationId",
                        onDelete = ForeignKey.CASCADE
                )})
public class Weather {
    @PrimaryKey(autoGenerate = true)
    public int weatherId;
    public String weatherCondition;
    public String temperature;
    public String lastUpdatedDate;
    public int locationId;

    public  Weather(String weatherCondition, String temperature, String lastUpdatedDate, int locationId)
    {

        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.lastUpdatedDate = lastUpdatedDate;
        this.locationId = locationId;
    }

}
