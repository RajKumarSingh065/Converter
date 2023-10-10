package com.example.converter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private RadioButton radioButtonCelsius;
    private RadioButton radioButtonFahrenheit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.degree);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        radioButtonCelsius = findViewById(R.id.radioButtonCelsius);
        radioButtonFahrenheit = findViewById(R.id.radioButtonFahrenheit);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(view -> convertTemperature());
    }

    @SuppressLint({"StringFormatInvalid", "DefaultLocale"})
    private void convertTemperature() {
        String temperatureText = editTextTemperature.getText().toString().trim();
        if (!temperatureText.isEmpty()) {
            double temperature = Double.parseDouble(temperatureText);

            if (radioButtonCelsius.isChecked()) {
                // Convert to Fahrenheit
                double convertedTemperature = (temperature * 9 / 5) + 32;
                textViewResult.setText(String.format("%.2f Celsius", convertedTemperature));
            } else if (radioButtonFahrenheit.isChecked()) {
                // Convert to Celsius
                double convertedTemperature = (temperature - 32) * 5 / 9;
                textViewResult.setText(String.format("%.2f Fahrenheit", convertedTemperature));
            }
        } else {
            textViewResult.setText(getString(R.string.empty_temperature_error));

        }
    }
}
