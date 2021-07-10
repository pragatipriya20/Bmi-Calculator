package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculateBMI(View view){
//        name of the person
        EditText hasName = (EditText) findViewById(R.id.person_name);
        Editable name = hasName.getText();

//        to specify gender of the person
        CheckBox isMale = (CheckBox) findViewById(R.id.male);
        boolean male = isMale.isChecked();

        CheckBox isFemale = (CheckBox) findViewById(R.id.female);
        boolean female = isFemale.isChecked();

//        get the weight of the person
        EditText hasWeight = (EditText) findViewById(R.id.weight);
        String weight = hasWeight.getText().toString();
        Double weightIs = Double.parseDouble(weight);

//        get the weight of the person
        EditText hasHeight = (EditText) findViewById(R.id.height);
        String height = hasHeight.getText().toString();
        Double heightIs = Double.parseDouble(height);
        heightIs=heightIs/100;

//        calculate bmi
        Double bmi = weightIs/(heightIs*heightIs);
        String finalBmi = String.format("%.2f",bmi);

//        to add image
        ImageView imageView = (ImageView) findViewById(R.id.bmi_image_view);
        imageView.setImageResource(R.drawable.bmi);


//        result to be displayed
        String result ="Hi "+ name + " , \nYour BMI is "+ finalBmi+"\nYou are "+isHealthy(bmi);

//        displaying the result on screen
        displayResult(result);
    }

/**
* Creating a method to find whether the person is healthy or not
 */

    public String isHealthy(double bmi){
        String state = null ;
        if(bmi <= 18.5) state = "Under-Weight";
        else if (bmi > 18.5 && bmi <= 24.9) state = "Normal";
        else if (bmi >= 25 && bmi <= 29.9) state = "Over-Weight";
        else if (bmi >= 30 && bmi <= 34.9) state = "Obese";
        else state = "Extremely-Obese";
        return state;
    }
    /**
     * Creating a method to display the output
     */
    private void displayResult (String message){
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(message);
    }
}