package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RandomConversion extends AppCompatActivity{
    private TextView txtLeftUnit;
    private TextView txtRightUnit;
    private TextView txtPrompt;
    private Button btnSelectConversion;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_conversion);

        //Generate random number to select conversion type
        Random r = new Random();
        int low = 1;
        int high = 12;
        result = r.nextInt(high-low) + low;

        //Set textViews depending on number generated
        setTextViews(result);

        //Get the user input for original number
        EditText editOriginalUnits = findViewById(R.id.editOriginalUnits2);

        //Instantiate convert button and create on click to switch to conversion screen
        Button btnConvert = findViewById(R.id.btnConvert2);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalNumber = editOriginalUnits.getText().toString();
                //Check if user inputted data
                if (!originalNumber.isEmpty()) {
                    //Pass the entered data as intent extra to conversion class
                    Intent intent = new Intent(RandomConversion.this, ConvertUnits.class);
                    intent.putExtra("originalNumber", originalNumber);
                    //Check the conversion type that was randomly generated
                    if (result == 1) {
                        intent.putExtra("conversion", "cm to mm");
                    } else if (result == 2){
                        intent.putExtra("conversion","m to cm");
                    } else if (result == 3) {
                        intent.putExtra("conversion", "cm to m");
                    } else if (result == 4 ) {
                        intent.putExtra("conversion", "mm to cm");
                    } else if (result == 5 ) {
                        intent.putExtra("conversion", "km to m");
                    } else if (result == 6 ) {
                        intent.putExtra("conversion", "m to km");
                    } else if (result == 7 ) {
                        intent.putExtra("conversion", "cm to km");
                    } else if (result == 8 ) {
                        intent.putExtra("conversion", "km to cm");
                    } else if (result == 9 ) {
                        intent.putExtra("conversion", "m to mm");
                    } else if (result == 10) {
                        intent.putExtra("conversion", "mm to m");
                    } else if (result == 11) {
                        intent.putExtra("conversion", "mm to km");
                    } else if (result == 12) {
                        intent.putExtra("conversion", "km to mm");
                    }
                    //Switch screens
                    startActivity(intent);
                } else {
                    //Error message
                    Toast.makeText(RandomConversion.this,
                            "Please enter a number to convert", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Change textviews to match the random conversion selected
    public void setTextViews(int result) {
        txtLeftUnit = findViewById(R.id.txtLeftUnit2);
        txtRightUnit = findViewById(R.id.txtRightUnit2);
        txtPrompt = findViewById(R.id.txtPrompt2);

        if (result == 1) {
            txtLeftUnit.setText("CM");
            txtRightUnit.setText("M");
            txtPrompt.setText("Enter units in centimetres to convert");
        } else if (result == 2) {
            txtLeftUnit.setText("M");
            txtRightUnit.setText("CM");
            txtPrompt.setText("Enter units in metres to convert");
        } else if (result == 3) {
            txtLeftUnit.setText("CM");
            txtRightUnit.setText("MM");
            txtPrompt.setText("Enter units in centimetres to convert");
        } else if (result == 4) {
            txtLeftUnit.setText("MM");
            txtRightUnit.setText("CM");
            txtPrompt.setText("Enter units in millimetres to convert");
        }  else if (result == 5) {
            txtLeftUnit.setText("KM");
            txtRightUnit.setText("M");
            txtPrompt.setText("Enter units in kilometres to convert");
        }  else if (result == 6) {
            txtLeftUnit.setText("M");
            txtRightUnit.setText("KM");
            txtPrompt.setText("Enter units in metres to convert");
        } else if (result == 7) {
            txtLeftUnit.setText("CM");
            txtRightUnit.setText("KM");
            txtPrompt.setText("Enter units in centimetres to convert");
        } else if (result == 8) {
            txtLeftUnit.setText("KM");
            txtRightUnit.setText("CM");
            txtPrompt.setText("Enter units in kilometres to convert");
        } else if (result == 9) {
            txtLeftUnit.setText("M");
            txtRightUnit.setText("MM");
            txtPrompt.setText("Enter units in metres to convert");
        } else if (result == 10) {
            txtLeftUnit.setText("MM");
            txtRightUnit.setText("M");
            txtPrompt.setText("Enter units in millimetres to convert");
        } else if (result == 11) {
            txtLeftUnit.setText("MM");
            txtRightUnit.setText("KM");
            txtPrompt.setText("Enter units in millimetres to convert");
        } else if (result == 12) {
            txtLeftUnit.setText("KM");
            txtRightUnit.setText("MM");
            txtPrompt.setText("Enter units in kilometres to convert");
        }
    }
}