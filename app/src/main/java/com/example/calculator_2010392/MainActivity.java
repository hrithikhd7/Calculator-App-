package com.example.calculator_2010392;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultDisplay;
    private double valueOne = 0;
    private double valueTwo = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay = findViewById(R.id.resultDisplay);

        setButtonListeners();
    }

    private void setButtonListeners() {
        View.OnClickListener numberListener = view -> {
            Button button = (Button) view;
            String currentText = resultDisplay.getText().toString();
            resultDisplay.setText(currentText.equals("0") ? button.getText() : currentText + button.getText());
        };

        // Number buttons
        findViewById(R.id.button0).setOnClickListener(numberListener);
        findViewById(R.id.button1).setOnClickListener(numberListener);
        findViewById(R.id.button2).setOnClickListener(numberListener);
        findViewById(R.id.button3).setOnClickListener(numberListener);
        findViewById(R.id.button4).setOnClickListener(numberListener);
        findViewById(R.id.button5).setOnClickListener(numberListener);
        findViewById(R.id.button6).setOnClickListener(numberListener);
        findViewById(R.id.button7).setOnClickListener(numberListener);
        findViewById(R.id.button8).setOnClickListener(numberListener);
        findViewById(R.id.button9).setOnClickListener(numberListener);
        findViewById(R.id.button_decimal).setOnClickListener(numberListener);

        // Operator buttons
        findViewById(R.id.button_plus).setOnClickListener(view -> handleOperator("+"));
        findViewById(R.id.button_minus).setOnClickListener(view -> handleOperator("-"));
        findViewById(R.id.button_multiply).setOnClickListener(view -> handleOperator("×"));
        findViewById(R.id.button_divide).setOnClickListener(view -> handleOperator("÷"));

        // Equal button
        findViewById(R.id.button_equals).setOnClickListener(view -> calculate());

        // Clear button
        findViewById(R.id.button_clear).setOnClickListener(view -> {
            resultDisplay.setText("0");
            valueOne = 0;
            valueTwo = 0;
            operator = "";
        });
    }

    private void handleOperator(String op) {
        valueOne = Double.parseDouble(resultDisplay.getText().toString());
        operator = op;
        resultDisplay.setText("0");
    }

    private void calculate() {
        valueTwo = Double.parseDouble(resultDisplay.getText().toString());
        double result = 0;

        switch (operator) {
            case "+": result = valueOne + valueTwo; break;
            case "-": result = valueOne - valueTwo; break;
            case "×": result = valueOne * valueTwo; break;
            case "÷": result = valueTwo != 0 ? valueOne / valueTwo : 0; break;
        }

        resultDisplay.setText(String.valueOf(result));
        operator = "";
        valueOne = result;
    }
}
