package ca.on.conestogac.navjot.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar simpleSeekBar;
    private TextView txtProgress;
    int progress = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleSeekBar = (SeekBar)
                findViewById(R.id.seekBar);
        txtProgress = (TextView)
                findViewById(R.id.seekBarText);

        simpleSeekBar.setMax(100);
        simpleSeekBar.setProgress(progress);
        txtProgress.setText("" + progress);
        txtProgress.setTextSize(progress);

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                txtProgress.setText("" + progress);
                txtProgress.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
