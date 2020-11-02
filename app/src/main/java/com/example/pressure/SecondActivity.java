package com.example.pressure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "PressureSecond";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        saving();
    }

    Map<FirstInfo, ArrayList<PressureInfo>> pinfo = new HashMap<>();

    private void putData(FirstInfo first, PressureInfo pressure) {
        if (!pinfo.containsKey(first)) {
            pinfo.put(first, new ArrayList<PressureInfo>());
        }
        Objects.requireNonNull(pinfo.get(first)).add(pressure);
    }

    private void saving() {
        EditText higherPressureText = findViewById(R.id.higherPressure);
        EditText lowerPressureText = findViewById(R.id.lowerPressure);
        EditText pulseText = findViewById(R.id.pulse);

        int higherPressure = 0;
        int lowerPressure = 0;
        int pulse = 0;

        try {
            higherPressure = Integer.parseInt(higherPressureText.getText().toString());
            lowerPressure = Integer.parseInt(lowerPressureText.getText().toString());
            pulse = Integer.parseInt(pulseText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(SecondActivity.this, R.string.insert_number, Toast.LENGTH_LONG).show();
        }

        final CheckBox checkTahikardia = findViewById(R.id.checkTahikardia);
        final boolean tahikardia = checkTahikardia.isChecked();
        final Date time = new Date();
        final PressureInfo pressure = new PressureInfo(higherPressure, lowerPressure, pulse, tahikardia, time);

        Button save = findViewById(R.id.saveButton2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку 'Сохранить (2)' ");
                putData(MainActivity.listOfUsers.get(MainActivity.listOfUsers.size()-1), pressure);

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}