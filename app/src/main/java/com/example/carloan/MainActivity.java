package com.example.carloan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton LoanButton;
    private TextView CarCost;
    private EditText CostofCar;
    private TextView DownPayment;
    private EditText DownPaymentCost;
    private EditText editText5;
    private Button button;
    private EditText FinalPay;
    private SeekBar seekBar;
    private TextView barLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarCost = findViewById(R.id.CarCost);
        CostofCar = findViewById(R.id.CostofCar);
        DownPayment = findViewById(R.id.DownPayment);
        DownPaymentCost = findViewById(R.id.DownPaymentCost);
        editText5 = findViewById(R.id.editText5);
        LoanButton = findViewById(R.id.LoanButton);
        button = findViewById(R.id.button);
        FinalPay = findViewById(R.id.FinalPay);
        seekBar = findViewById(R.id.seekBar);
        barLabel = findViewById(R.id.barLabel);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                barLabel.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void loan(View v) {
        if (LoanButton.isChecked()) {
            String input = CostofCar.getText().toString();
            String input2 = DownPaymentCost.getText().toString();
            String input3 = editText5.getText().toString();
            String input4 = barLabel.getText().toString();
            if (input.length() > 0) {
                if (input2.length() > 0) {
                    if (input3.length() > 0) {
                        if (input4.length() > 0) {
                            double Cost = Double.parseDouble(input);
                            double Dp = Double.parseDouble(input2);
                            double apr = Double.parseDouble(input3);
                            double month = Double.parseDouble(input4);
                            double mpr = (apr / 100) / 12;
                            double L = (Cost - Dp);
                            double next = (1 + mpr);
                            double next2 = Math.pow((next), (-month));
                            double next3 = (1 - next2);
                            double total = ((mpr * L) / (next3));
                            FinalPay.setText(String.format("%.2f", total));
                        }
                    }
                }
            }
        }
    }
}