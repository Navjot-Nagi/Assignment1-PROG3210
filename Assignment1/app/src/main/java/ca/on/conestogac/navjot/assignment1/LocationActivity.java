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
        locationData();

    }

    public void locationData()
    {
        String userNameString = nameOfLocation.getText().toString();
        String passwordString = address.getText().toString();
        List<Location> getLocation = database.locationDao().getLocation();

        nameOfLocation.setText(getLocation.get(0).name);
        address.setText(getLocation.get(0).address);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent logOut = new Intent(this, SettingsActivity.class);
            startActivity(logOut);
        }
        else if (id == R.id.action_locations) {
            Intent location = new Intent(this, LocationActivity.class);
            startActivity(location);
        }


        return super.onOptionsItemSelected(item);

    }

}
