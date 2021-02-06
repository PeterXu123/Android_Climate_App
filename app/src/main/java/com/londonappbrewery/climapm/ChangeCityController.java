package com.londonappbrewery.climapm;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {
    EditText cityName;
    ImageButton goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);
        cityName = findViewById(R.id.queryET);
        goBack = (ImageButton) findViewById(R.id.backButton);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        cityName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String newCity = cityName.getText().toString();
                Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
                newCityIntent.putExtra("City", newCity);
                startActivity(newCityIntent);
                return false;
            }
        });
    }
}