package com.example.calculator_2010392;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView resultDisplay;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultDisplay = findViewById(R.id.resultDisplay);

        setupButtonListeners();
    }


    private void setupButtonListeners() {

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button clickedButton = (Button) view;
                String buttonValue = clickedButton.getText().toString();
                String currentDisplayText = resultDisplay.getText().toString();


                if (currentDisplayText.equals("0")) {
                    resultDisplay.setText(buttonValue);
                } else {
                    resultDisplay.setText(currentDisplayText + buttonValue);
                }
            }
        };


        findViewById(R.id.button0).setOnClickListener(numberClickListener);
        findViewById(R.id.button1).setOnClickListener(numberClickListener);
        findViewById(R.id.button2).setOnClickListener(numberClickListener);
        findViewById(R.id.button3).setOnClickListener(numberClickListener);
        findViewById(R.id.button4).setOnClickListener(numberClickListener);
        findViewById(R.id.button5).setOnClickListener(numberClickListener);
        findViewById(R.id.button6).setOnClickListener(numberClickListener);
        findViewById(R.id.button7).setOnClickListener(numberClickListener);
        findViewById(R.id.button8).setOnClickListener(numberClickListener);
        findViewById(R.id.button9).setOnClickListener(numberClickListener);
        findViewById(R.id.button_decimal).setOnClickListener(numberClickListener);


        findViewById(R.id.button_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("+");
            }
        });
        findViewById(R.id.button_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("-");
            }
        });
        findViewById(R.id.button_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("×");
            }
        });
        findViewById(R.id.button_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("÷");
            }
        });


        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });


        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetCalculator();
            }
        });
    }


    private void setOperator(String operator) {
        firstNumber = Double.parseDouble(resultDisplay.getText().toString());
        currentOperator = operator;
        resultDisplay.setText("0");
    }


    private void calculateResult() {
        secondNumber = Double.parseDouble(resultDisplay.getText().toString());
        double result = 0;


        switch (currentOperator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "×": result = firstNumber * secondNumber; break;
            case "÷":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    result = 0;
                }
                break;
        }


        resultDisplay.setText(String.valueOf(result));
        currentOperator = "";
        firstNumber = result;
    }


    private void resetCalculator() {
        resultDisplay.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        currentOperator = "";
    }
}
