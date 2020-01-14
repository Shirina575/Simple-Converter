package com.example.viserion.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    RadioButton KiloToMeter, inchesToMeter, KgToPound;
    Button submit;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.Input);
        KiloToMeter = (RadioButton) findViewById(R.id.kmPerHour);
        inchesToMeter = (RadioButton) findViewById(R.id.Inches);
        KgToPound = (RadioButton) findViewById(R.id.Kg);
        submit = (Button) findViewById(R.id.Submit);
        output = (TextView) findViewById(R.id.Output);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder stringBuilder = new StringBuilder();

                if (KiloToMeter.isChecked()){
                    double kiloMeterPerHour = Double.parseDouble(input.getText().toString());
                    double meterPerSec = (kiloMeterPerHour*1000)/3600;
                    stringBuilder.append(meterPerSec+" m/s");
                }
                if (inchesToMeter.isChecked()){
                    double inches = Double.parseDouble(input.getText().toString());
                    double meter = inches/39.3701;
                    stringBuilder.append(meter+" m");
                }
                if (KgToPound.isChecked()){
                    double kg = Double.parseDouble(input.getText().toString());
                    double pound = kg*2.2;
                    stringBuilder.append(pound+" pound");
                }
                output.setText(stringBuilder);
            }
        });
    }
}
