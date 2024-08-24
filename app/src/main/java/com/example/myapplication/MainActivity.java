package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMultiply, btnDivide, btnPercent;

    private void initControl(){
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnPercent = findViewById(R.id.btnPercent);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('%');
            }
        });
    }

    private void calculate(char operator) {
        try {
            double x = Double.parseDouble(txtX.getText().toString());
            double y = Double.parseDouble(txtY.getText().toString());
            double result = 0;

            switch (operator) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    if (y != 0) {
                        result = x / y;
                    } else {
                        txtResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
                case '%':
                    result = x % y;
                    break;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtResult.setText("Invalid input");
        }
    }
}
