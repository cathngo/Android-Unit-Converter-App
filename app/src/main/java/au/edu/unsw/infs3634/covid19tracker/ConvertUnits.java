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
            convertCentimetresToMetre(originalNumber);
        } else if (conversion_type.equals("m_to_cm")){
            txtTo.setText("CM");
            txtFrom.setText("M");
            txtOriginalNumber.setText(originalNumber + "m");
            convertMetresToCentimetres(originalNumber);
        } else if (conversion_type.equals("cm_to_mm")) {
            txtTo.setText("MM");
            txtFrom.setText("CM");
            txtOriginalNumber.setText(originalNumber + "cm");
            convertCentimetresToMillimetres(originalNumber);
        } else if (conversion_type.equals("mm_to_cm")){
            txtTo.setText("CM");
            txtFrom.setText("MM");
            txtOriginalNumber.setText(originalNumber + "mm");
            convertMillimetresToCentimetres(originalNumber);
        } else if (conversion_type.equals("km_to_m")){
            txtFrom.setText("KM");
            txtTo.setText("M");
            txtOriginalNumber.setText(originalNumber + "km");
            convertKilometresToMetres(originalNumber);
        } else if (conversion_type.equals("m_to_km")){
            txtFrom.setText("M");
            txtTo.setText("KM");
            txtOriginalNumber.setText(originalNumber + "m");
            convertMetresToKilometres(originalNumber);
        } else if (conversion_type.equals("cm_to_km")){
            txtFrom.setText("CM");
            txtTo.setText("KM");
            txtOriginalNumber.setText(originalNumber + "cm");
            convertCentimetresToKilometres(originalNumber);
        } else if (conversion_type.equals("km_to_cm")) {
            txtFrom.setText("KM");
            txtTo.setText("CM");
            txtOriginalNumber.setText(originalNumber + "km");
            convertKilometresToCentimetres(originalNumber);
        } else if (conversion_type.equals("m_to_mm")) {
            txtFrom.setText("M");
            txtTo.setText("MM");
            txtOriginalNumber.setText(originalNumber + "m");
            convertMetresToMillimetres(originalNumber);
        } else if (conversion_type.equals("mm_to_m")) {
            txtFrom.setText("MM");
            txtTo.setText("M");
            txtOriginalNumber.setText(originalNumber + "mm");
            convertMillimetresToMetres(originalNumber);
        } else if (conversion_type.equals("mm_to_km")) {
            txtFrom.setText("MM");
            txtTo.setText("KM");
            txtOriginalNumber.setText(originalNumber + "mm");
            convertMillimetresToKilometres(originalNumber);
        } else if (conversion_type.equals("km_to_mm")) {
            txtFrom.setText("KM");
            txtTo.setText("MM");
            txtOriginalNumber.setText(originalNumber + "km");
            convertKilometresToMillimetres(originalNumber);
        }

    }
    public void convertKilometresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");

    }
    public void convertMillimetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);
        //double convertedNumber = (double) initialNumber /100;

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000000);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "km");

    }
    public void convertMillimetresToMetres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);
        //double convertedNumber = (double) initialNumber /100;

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "m");

    }
    public void convertMetresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");

    }
    public void convertCentimetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);
        //double convertedNumber = (double) initialNumber /100;

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(100000);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "km");

    }

    public void convertKilometresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "cm");

    }

    public void convertMetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);
        //double convertedNumber = (double) initialNumber /100;

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "km");

    }


    public void convertKilometresToMetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "m");

    }

    public void convertCentimetresToMetre(String originalNumber){
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

    public void convertMetresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "cm");

    }

    public void convertCentimetresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(10);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");

    }

    public void convertMillimetresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //convert to human math
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(10);
        BigDecimal res = bdNumber.divide(divisor);

        //set text
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        //txtConvertedNumber.setText(originalNumber + "cm = " + res.toString() + "m");
        txtConvertedNumber.setText(res.toString() + "cm");

    }


}