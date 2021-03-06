package ca.on.conestogac.navjot.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void logout(View view) {
        Intent logIn = new Intent(this, LogInActivity.class);
        startActivity(logIn);
    }

    public void goWeather(View view) {
        Intent weather = new Intent(this, MainActivity.class);
        startActivity(weather);
    }

    public void goLocation(View view) {
        Intent location = new Intent(this, LocationActivity.class);
        startActivity(location);
    }
}
