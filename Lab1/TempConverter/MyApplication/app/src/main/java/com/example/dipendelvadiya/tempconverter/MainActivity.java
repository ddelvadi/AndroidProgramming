package com.example.dipendelvadiya.tempconverter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView iv; //create iv object to manipulate image view

    private EditText text;
    View view; //create object to manipulate background color


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button8:
                RadioButton celsiusButton = (RadioButton)
                        findViewById(R.id.radioButton6);
                RadioButton fahrenheitButton = (RadioButton)
                        findViewById(R.id.radioButton5);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }

                //grab CURRENT result value now in Text Field
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                iv=(ImageView) findViewById(R.id.imageView);
                if (inputValue>90){
                //set hex color to skyblue
                    view.setBackgroundColor(Color.parseColor("#87ceff"));
                    iv.setVisibility(View.VISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.sunny);  //show sun on image

                }
                else if (inputValue < 0)
                {
                    view.setBackgroundColor(Color.RED); //to set background red
                    iv.setVisibility(View.VISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.cold);
                }
                else {
                    view.setBackgroundColor(Color.YELLOW);//to set Background yellow
                    iv.setVisibility(View.INVISIBLE);
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                }
                break;
        }
    }
}
