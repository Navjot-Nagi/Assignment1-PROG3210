package ca.on.conestogac.navjot.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import data.AppDatabase;
import data.Weather;


public class MainActivity extends AppCompatActivity {
    private AppDatabase database;
    private Weather weather;
    private TextView weatherCondition;
    private TextView temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        weatherCondition = (TextView)
                findViewById(R.id.WeatherConditionLabel);
        temperature = (TextView)
                findViewById(R.id.temperature);
        database = AppDatabase.getDatabase(this.getApplication());
    }
    public void weatherConditions()
    {
        String userNameString = weatherCondition.getText().toString();
        String passwordString = temperature.getText().toString();
        List<Weather> getWeather = database.weatherDao().getWeather();

        weatherCondition.setText(getWeather.get(0).weatherCondition);
        temperature.setText(getWeather.get(0).temperature);

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
        } else if (id == R.id.action_locations) {
            Intent location = new Intent(this, LocationActivity.class);
            startActivity(location);

        }

        return super.onOptionsItemSelected(item);
    }

    public void getWeatherConditions(View view) {
        weatherConditions();
    }
}