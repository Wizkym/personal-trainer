package net.androidbootcamp.personaltrainer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.felipecsl.gifimageview.library.GifImageView;


public class MainActivity extends AppCompatActivity {
    private TextView reservation;
    Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    String txtDate;
    AnimationDrawable gifAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        reservation = (TextView) findViewById(R.id.txtDescription);
        GifImageView imgFrame = (GifImageView)findViewById(R.id.gifimageView);
        imgFrame.setBackgroundResource(R.drawable.animation);
        gifAnimation=(AnimationDrawable)imgFrame.getBackground();
        gifAnimation.start();
        Button btDate = (Button) findViewById(R.id.btnDate);
        final Button btTime = (Button) findViewById(R.id.btnTime);

        btDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                //btTime.callOnClick();
            }
        });

        btTime.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, hour, minute,false).show();
            }
        });

        ImageView img_animation = (ImageView) findViewById(R.id.imgBottom);

        TranslateAnimation animation = new TranslateAnimation(0.0f, 2190.0f,
                0.0f, 0.0f);
        animation.setDuration(7000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        img_animation.startAnimation(animation);
    }
    DateFormat fmtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            txtDate = "Your reservation is set for "+fmtDate.format(c.getTime()).toString();
            reservation.setText(txtDate);
        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener(){

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            c.set(Calendar.HOUR, hourOfDay);
            c.set(Calendar.MINUTE, minute);
            reservation.setText(txtDate + " at " + String.valueOf(hourOfDay)
                    + " : " + String.valueOf(minute));
        }
    };

}
