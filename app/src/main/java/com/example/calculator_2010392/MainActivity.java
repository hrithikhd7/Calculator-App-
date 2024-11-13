package com.example.calculator_2010392;

// Import the necessary libraries for Android apps
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Define the main class for our calculator app
public class MainActivity extends AppCompatActivity {

    // Declare variables to hold our display and numbers
    private TextView resultDisplay;  // TextView to show the result
    private double firstNumber = 0;  // Holds the first number in the calculation
    private double secondNumber = 0; // Holds the second number in the calculation
    private String currentOperator = "";  // Holds the selected operator (+, -, ×, ÷)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call to parent class's onCreate method
        setContentView(R.layout.activity_main); // Set the layout for the calculator

        // Link the result display to the TextView in our XML layout
        resultDisplay = findViewById(R.id.resultDisplay);

        // Set up the button listeners
        setupButtonListeners();
    }

    // Method to link each button to its action
    private void setupButtonListeners() {
        // Listener for number buttons (0-9 and .)
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked button
                Button clickedButton = (Button) view;
                String buttonValue = clickedButton.getText().toString();
                String currentDisplayText = resultDisplay.getText().toString();

                // Update display: if "0", replace it; otherwise, add new number
                if (currentDisplayText.equals("0")) {
                    resultDisplay.setText(buttonValue);
                } else {
                    resultDisplay.setText(currentDisplayText + buttonValue);
                }
            }
        };

        // Assign the numberClickListener to each number button
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

        // Listeners for operator buttons (+, -, ×, ÷)
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

        // Listener for the equals button
        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        // Listener for the clear button
        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetCalculator();
            }
        });
    }

    // Method to set the operator and store the first number
    private void setOperator(String operator) {
        firstNumber = Double.parseDouble(resultDisplay.getText().toString()); // Convert display text to a number
        currentOperator = operator;  // Store the chosen operator (+, -, ×, ÷)
        resultDisplay.setText("0");  // Reset display for the next number
    }

    // Method to perform the calculation when the equals button is pressed
    private void calculateResult() {
        secondNumber = Double.parseDouble(resultDisplay.getText().toString()); // Convert display text to the second number
        double result = 0;  // Variable to hold the calculation result

        // Perform the operation based on the selected operator
        switch (currentOperator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "×": result = firstNumber * secondNumber; break;
            case "÷":
                if (secondNumber != 0) { // Prevent division by zero
                    result = firstNumber / secondNumber;
                } else {
                    result = 0; // Set result to 0 if dividing by zero
                }
                break;
        }

        // Display the result and reset the operator
        resultDisplay.setText(String.valueOf(result));
        currentOperator = "";  // Reset operator after calculation
        firstNumber = result;  // Store result for further calculations
    }

    // Method to reset the calculator
    private void resetCalculator() {
        resultDisplay.setText("0");  // Set display to 0
        firstNumber = 0;  // Clear stored numbers
        secondNumber = 0;
        currentOperator = "";  // Clear the operator
    }
}
