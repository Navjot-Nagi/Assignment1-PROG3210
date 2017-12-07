package ca.on.conestogac.navjot.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;

import java.util.List;

import data.AppDatabase;
import data.Location;



public class LocationActivity extends AppCompatActivity {
    private AppDatabase database;
    private Location location;
    private TextView nameOfLocation;
    private TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        nameOfLocation = (TextView)
                findViewById(R.id.locationNameLabel);
        address = (TextView)
                findViewById(R.id.userAddress);
        database = AppDatabase.getDatabase(this.getApplication());

    }

    public void logInData()
    {
        String userNameString = nameOfLocation.getText().toString();
        String passwordString = address.getText().toString();
        List<Location> getLocation = database.locationDao().getLocation();

        nameOfLocation.setText(getLocation.get(1).name);
        address.setText("hello");

    }

    public void goBack(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    public void test(View view) {
        logInData();
    }
}
