package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class ConvertUnits extends AppCompatActivity {

    private TextView txtOriginalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_units);

        //get original number
        Intent incomingIntent = getIntent();
        String originalNumber = incomingIntent.getStringExtra("originalNumber");

        //set original number
        TextView txtOriginalNumber = findViewById(R.id.txtOriginalNumber);
        TextView txtTo = findViewById(R.id.txtTo);
        TextView txtFrom = findViewById(R.id.txtFrom);


        //check conversion type
        String conversion_type = incomingIntent.getStringExtra("conversion");
        if (conversion_type.equals("cm_to_m")) {
            //convert original number(cm) to metre
            txtOriginalNumber.setText(originalNumber + "cm");
            txtTo.setText("M");
            txtFrom.setText("CM");
            convertToMetre(originalNumber);
        } else {
            txtTo.setText("CM");
            txtFrom.setText("M");
            txtOriginalNumber.setText(originalNumber + "m");
            convertToCentimetres(originalNumber);
        }



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
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "m");

    }

    public void convertToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "cm");

    }


}