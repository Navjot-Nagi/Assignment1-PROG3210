package data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by navjot on 2017-11-24.
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void addUser(User user);

    @Query("select * from user")
    public List<User> getAllUser();

    @Query("select * from user where userName = :userName")
    public List<User> getUser(String userName);
// db.getUser("Navjot Nagi")
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Query("delete from user")
    void removeAllUsers();
}
