package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConvertUnits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_units);

        //get original number
        Intent incomingIntent = getIntent();
        String originalNumber = incomingIntent.getStringExtra("originalNumber");

        //set original number
        TextView txtOriginalNumber = findViewById(R.id.txtOriginalNumber);
        txtOriginalNumber.setText("Original Number: " + originalNumber + "cm");

        //convert original number
        double initialNumber = Double.parseDouble(originalNumber);
        double convertedNumber = (double)Math.round(initialNumber) / 100;

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText("Converted Number (2dp): " + Double.toString(convertedNumber) + "m");




    }



}