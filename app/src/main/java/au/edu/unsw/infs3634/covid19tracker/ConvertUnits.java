package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

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

        //convert original number(cm) to metre
        convertToMetre(originalNumber);

    }

    public void convertToMetre(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);
        //double convertedNumber = (double) initialNumber /100;

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(100);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText("Converted Number: " + res.toString() + "m");

    }

    public void convertToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText("Converted Number: " + res.toPlainString() + "cm");

    }


}