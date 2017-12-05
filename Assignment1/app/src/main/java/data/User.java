package data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.widget.EditText;

/**
 * Created by navjot on 2017-11-23.
 */
@Entity
public class User {
@PrimaryKey
@NonNull
    public String userName;
    public String password;
    public String firstName;
    public String lastName;


    public User(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

