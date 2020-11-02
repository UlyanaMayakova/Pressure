package com.example.pressure;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "PressureThird";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        saving();
    }

    Map<FirstInfo, ArrayList<LifeInfo>> linfo = new HashMap<>();

    private void putData(FirstInfo first, LifeInfo life) {
        if (!linfo.containsKey(first)) {
            linfo.put(first, new ArrayList<LifeInfo>());
        }
        Objects.requireNonNull(linfo.get(first)).add(life);
    }

    private void saving() {
        EditText weightText = findViewById(R.id.weight);
        EditText stepsText = findViewById(R.id.steps);

        double weight = 0;
        int steps = 0;
        try {
            weight = Double.parseDouble(weightText.getText().toString());
            steps = Integer.parseInt(stepsText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(ThirdActivity.this, R.string.insert_number, Toast.LENGTH_LONG).show();

        }

        final LifeInfo life = new LifeInfo(weight, steps);

        Button save = findViewById(R.id.saveButton3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку 'Сохранить (3)' ");
                putData(MainActivity.listOfUsers.get(MainActivity.listOfUsers.size()-1), life);
            }
        });
    }
}