package com.example.pressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PressureFirst";

    public static final List<FirstInfo> listOfUsers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saving();
        goToPressure();
        goToLifeInfo();
    }

    private void saving() {
        EditText fioText = findViewById(R.id.fio);
        EditText ageText = findViewById(R.id.age);

        final String fio = fioText.getText().toString();
        String ageString = ageText.getText().toString();
        int age = 0;
        try {
            age = Integer.parseInt(ageString);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, R.string.insert_number, Toast.LENGTH_LONG).show();
        }

        Button save = findViewById(R.id.saveButton1);
        final int finalAge = age;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку 'Сохранить (1)' ");
                FirstInfo userInfo = new FirstInfo(fio, finalAge);
                listOfUsers.add(userInfo);
            }
        });
    }

    private void goToPressure() {
        Button pressureButton = findViewById(R.id.pressureButton);
        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку 'Показатели давления' ");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goToLifeInfo() {
        Button lifeButton = findViewById(R.id.lifeButton);
        lifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку 'Жизненные показатели здоровья' ");
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}