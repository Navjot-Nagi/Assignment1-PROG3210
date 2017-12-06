package data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by navjot on 2017-11-23.
 */
@Entity(tableName = "Location",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "userName",
                        childColumns = "userName",
                        onDelete = ForeignKey.CASCADE
                )}
)
public class Location {
@PrimaryKey(autoGenerate = true)
    public int locationId;
    public String name;
    public String address;
    public double latitude;
    public double longiude;
    public String userName;

    public Location(String name, String address, double latitude, double longiude, String userName){
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longiude = longiude;
        this.userName = userName;
    }

}
