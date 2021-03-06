package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Random;

public class ConvertUnits extends AppCompatActivity {

    private TextView txtOriginalNumber;
    private Button btnHome;
    private TextView txtOriginalNumber_c;
    private TextView txtOriginalUnit_c;
    private TextView txtDesiredUnit_c;
    private TextView txtConvertedNumber_c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_units);

        //Get the original number that was inputted by user
        Intent incomingIntent = getIntent();
        String originalNumber = incomingIntent.getStringExtra("originalNumber");

        //Initialise text views
        txtOriginalNumber = findViewById(R.id.txtOriginalNumber);
        txtOriginalNumber_c = findViewById(R.id.txtOriginalNumber_c);
        txtOriginalUnit_c = findViewById(R.id.txtOriginalUnit_c);
        txtDesiredUnit_c = findViewById(R.id.txtDesiredUnit_c);
        txtOriginalNumber_c.setText(originalNumber);

        //Check conversion type that was selected and call the respective conversion method
        String conversion_type = incomingIntent.getStringExtra("conversion");
        if (conversion_type.equals("cm to m")) {
            txtOriginalNumber.setText(originalNumber + "cm");
            txtOriginalUnit_c.setText("Centimetres");
            txtDesiredUnit_c.setText("Metres");
            convertCentimetresToMetre(originalNumber);
        } else if (conversion_type.equals("m to cm")){
            txtOriginalNumber.setText(originalNumber + "m");
            txtOriginalUnit_c.setText("Metres");
            txtDesiredUnit_c.setText("Centimetres");
            convertMetresToCentimetres(originalNumber);
        } else if (conversion_type.equals("cm to mm")) {
            txtOriginalNumber.setText(originalNumber + "cm");
            txtOriginalUnit_c.setText("Centimetres");
            txtDesiredUnit_c.setText("Millimetres");
            convertCentimetresToMillimetres(originalNumber);
        } else if (conversion_type.equals("mm to cm")){
            txtOriginalNumber.setText(originalNumber + "mm");
            txtOriginalUnit_c.setText("Millimetres");
            txtDesiredUnit_c.setText("Centimetres");
            convertMillimetresToCentimetres(originalNumber);
        } else if (conversion_type.equals("km to m")){
            txtOriginalNumber.setText(originalNumber + "km");
            txtOriginalUnit_c.setText("Kilometres");
            txtDesiredUnit_c.setText("Metres");
            convertKilometresToMetres(originalNumber);
        } else if (conversion_type.equals("m to km")){
            txtOriginalNumber.setText(originalNumber + "m");
            txtOriginalUnit_c.setText("Metres");
            txtDesiredUnit_c.setText("Kilometres");
            convertMetresToKilometres(originalNumber);
        } else if (conversion_type.equals("cm to km")){
            txtOriginalNumber.setText(originalNumber + "cm");
            txtOriginalUnit_c.setText("Centimetres");
            txtDesiredUnit_c.setText("Kilometres");
            convertCentimetresToKilometres(originalNumber);
        } else if (conversion_type.equals("km to cm")) {
            txtOriginalNumber.setText(originalNumber + "km");
            txtOriginalUnit_c.setText("Kilometres");
            txtDesiredUnit_c.setText("Centimetres");
            convertKilometresToCentimetres(originalNumber);
        } else if (conversion_type.equals("m to mm")) {
            txtOriginalNumber.setText(originalNumber + "m");
            txtOriginalUnit_c.setText("Metres");
            txtDesiredUnit_c.setText("Millimetres");
            convertMetresToMillimetres(originalNumber);
        } else if (conversion_type.equals("mm to m")) {
            txtOriginalNumber.setText(originalNumber + "mm");
            txtOriginalUnit_c.setText("Millimetres");
            txtDesiredUnit_c.setText("Metres");
            convertMillimetresToMetres(originalNumber);
        } else if (conversion_type.equals("mm to km")) {
            txtOriginalNumber.setText(originalNumber + "mm");
            txtOriginalUnit_c.setText("Millimetres");
            txtDesiredUnit_c.setText("Kilometres");
            convertMillimetresToKilometres(originalNumber);
        } else if (conversion_type.equals("km to mm")) {
            txtOriginalNumber.setText(originalNumber + "km");
            txtOriginalUnit_c.setText("Kilometres");
            txtDesiredUnit_c.setText("Millimetres");
            convertKilometresToMillimetres(originalNumber);
        }

        //Initialise a home button to take user back to main screen
        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConvertUnits.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //Converts kilometres to millimetres
    public void convertKilometresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        //Convert to big decimal
        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        //Set textviews
        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts millimetres to kilometres
    public void convertMillimetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000000);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "km");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts millimetres to metres
    public void convertMillimetresToMetres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "m");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }
    //Converts metres to millimetres
    public void convertMetresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts centimetres to kilometres
    public void convertCentimetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(100000);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "km");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts kilometres to centimetres
    public void convertKilometresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "cm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts metres to kilometres
    public void convertMetresToKilometres(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "km");

        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts kilometres to metres
    public void convertKilometresToMetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(1000);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "m");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts centimetres to metres
    public void convertCentimetresToMetre(String originalNumber){
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(100);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "m");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    // Converts metres to centimetres
    public void convertMetresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(100);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "cm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts centimetres to millimetres
    public void convertCentimetresToMillimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal multiplier = new BigDecimal(10);
        BigDecimal res = bdNumber.multiply(multiplier).stripTrailingZeros();

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toPlainString() + "mm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }

    //Converts millimetres to centimetres
    public void convertMillimetresToCentimetres(String originalNumber) {
        double initialNumber = Double.parseDouble(originalNumber);

        BigDecimal bdNumber = BigDecimal.valueOf(initialNumber);
        BigDecimal divisor = new BigDecimal(10);
        BigDecimal res = bdNumber.divide(divisor);

        TextView txtConvertedNumber = findViewById(R.id.txtConvertedNumber);
        txtConvertedNumber.setText(res.toString() + "cm");
        txtConvertedNumber_c = findViewById(R.id.txtConvertedNumber_c);
        txtConvertedNumber_c.setText(res.toPlainString());
    }
}