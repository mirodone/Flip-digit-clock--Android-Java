package ro.mirodone.flipdigit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;
import com.aldrek.digitflip.FlipWidget;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    FlipWidget hours, minutes, seconds;

    int hoursNumber, minutesNumber, secondsNumber;

    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hours = findViewById(R.id.hours);
        minutes = findViewById(R.id.minutes);
        seconds = findViewById(R.id.seconds);


        mHandler = new Handler();
        mRunnable = new Runnable() {

            @Override
            public void run() {

                Calendar calendar = Calendar.getInstance();

                hoursNumber = calendar.get(Calendar.HOUR_OF_DAY);
                minutesNumber = calendar.get(Calendar.MINUTE);
                secondsNumber = calendar.get(Calendar.SECOND);

                hours.setValue(hoursNumber, true);
                minutes.setValue(minutesNumber, true);
                seconds.setValue(secondsNumber, true);

                mHandler.postDelayed(mRunnable, 1000);
            }
        };

        mHandler.postDelayed(mRunnable, 1000);
    }
}
