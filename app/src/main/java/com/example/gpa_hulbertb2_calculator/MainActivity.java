package com.example.gpa_hulbertb2_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Grade1;
    private EditText Grade2;
    private EditText Grade3;
    private EditText Grade4;
    private EditText Grade5;
    private Button ComputeGPA;
    private TextView textView1, textView2, textView3, textView4, textView5;
    private double GPA;
    private double totalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grade1 = findViewById(R.id.editTextNumber1);
        Grade2 = findViewById(R.id.editTextNumber2);
        Grade3 = findViewById(R.id.editTextNumber3);
        Grade4 = findViewById(R.id.editTextNumber4);
        Grade5 = findViewById(R.id.editTextNumber5);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        ComputeGPA = findViewById(R.id.computeGPABtn);
    }

    public void GPACompute() {

        double newGrade1 = Double.parseDouble(Grade1.getText().toString());
        double newGrade2 = Double.parseDouble(Grade2.getText().toString());
        double newGrade3 = Double.parseDouble(Grade3.getText().toString());
        double newGrade4 = Double.parseDouble(Grade4.getText().toString());
        double newGrade5 = Double.parseDouble(Grade5.getText().toString());
        totalGrade = newGrade1 + newGrade2 + newGrade3 + newGrade4 + newGrade5;
        GPA = totalGrade / 5;

        ConstraintLayout Layout = (ConstraintLayout) findViewById(R.id.constraintlayout);

        TextView displayGPA = (TextView) findViewById(R.id.displayGPA);

        if (Grade1.getText().toString().isEmpty() || Grade2.getText().toString().isEmpty() ||
                Grade3.getText().toString().isEmpty() || Grade4.getText().toString().isEmpty() ||
                Grade5.getText().toString().isEmpty()) {
                    displayGPA.setText("Please enter in a score for course 1, 2, 3, 4, and 5.");
        }

        else {
            displayGPA.setText("Your GPA is: " + GPA);
            ComputeGPA.setBackgroundColor(Color.TRANSPARENT);
            }

        if (GPA < 60) {
            Layout.setBackgroundColor(Color.RED);
        } else if (GPA >= 61 && GPA <= 79) {
            Layout.setBackgroundColor(Color.YELLOW);
        } else if (GPA >= 80 && GPA == 100) {
            Layout.setBackgroundColor(Color.GREEN);
        }

         ComputeGPA.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 GPACompute();

             }
         });
    };
}

