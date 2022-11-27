package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MSSG = "com.ArRyan.multiscreen.MSSG";

    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private Switch Switch;
    private EditText editText3;
    private Button button;
    private TextView textView2;
    private TextView textView3;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,DisplayResult.class);

        textView = findViewById(R.id.textView);  //tile
        editText1 = findViewById(R.id.editTextNumberDecimal);  //wt
        editText2 = findViewById(R.id.editTextNumberDecimal2);  //ht
        textView3 = findViewById(R.id.textView3);  //display
        textView2 = findViewById(R.id.textView4);  //display
        button = findViewById(R.id.button3);   //press


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = editText1.getText().toString();
                String s2 = editText2.getText().toString();
                //String s3 = editText3.getText().toString();

                double weight = Double.parseDouble(s1);
                double height = Double.parseDouble(s2);
                //double age = Double.parseDouble(s3);

                double bmi = (10000*weight)/(height*height);

                String S1 = ("Your BMI is " + bmi );
                String S2;

                if(bmi < 16) {
                    S2 = S1 + " and You belong to the category of Severe Thinness";
                }
                else if(bmi >= 16 && bmi <17){
                    S2 = S1 + " and You belong to the category of Moderate Thinness";
                }
                else if(bmi >= 17 && bmi <18.5){
                    S2 = S1 + " and You belong to the category of Mild Thinness";

                }

                else if(bmi >= 18.5 && bmi < 25){
                    S2 = S1 + " and You belong to the category of Normal Body Mass Index";
                }
                else if(bmi >= 25 && bmi <30){
                    S2 = S1 + " and You belong to the category of Overweight";
                }
                else if(bmi>=30 && bmi<35){
                    S2 = S1 + " and You belong to the category of Obese Class 1";
                }
                else if(bmi>=35 && bmi<40){
                    S2 = S1 + " and You belong to the category of Obese Class 2";
                }
                else{
                    S2 = S1 + " and You belong to the category of Obese Class 3";
                }



                intent.putExtra(MSSG,S2);
                startActivity(intent);
            }
        });

    }




}