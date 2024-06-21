// MainActivity.java
package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTanggalLahir;
    private EditText editTextTanggalHariIni;
    private Button buttonHitung;
    private Button buttonReset;
    private TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTanggalLahir = findViewById(R.id.editTextTanggalLahir);
        editTextTanggalHariIni = findViewById(R.id.editTextTanggalHariIni);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        textViewHasil = findViewById(R.id.textViewHasil);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dobString = editTextTanggalLahir.getText().toString();
                String currentDateString = editTextTanggalHariIni.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    Date currentDate = dateFormat.parse(currentDateString);
                    DetailedPerson person = new DetailedPerson(dobString);

                    String result = person.calculateDetailedAge(currentDate);
                    textViewHasil.setText(result);
                } catch (ParseException e) {
                    e.printStackTrace();
                    textViewHasil.setText("Format Tanggal Salah");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextTanggalLahir.setText("");
                editTextTanggalHariIni.setText("");
                textViewHasil.setText("");
            }
        });
    }
}
