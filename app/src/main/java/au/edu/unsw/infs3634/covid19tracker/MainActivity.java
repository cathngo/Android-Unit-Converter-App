package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView txtLeftUnit;
    private TextView txtRightUnit;
    private TextView txtPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //generate random number to select conversion type
        Random r = new Random();
        int low = 1;
        int high = 12;
        int result = r.nextInt(high-low) + low;
        System.out.println("number is " + result);

        txtLeftUnit = findViewById(R.id.txtLeftUnit);
        txtRightUnit = findViewById(R.id.txtRightUnit);
        txtPrompt = findViewById(R.id.txtPrompt);

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


        //get units entered
        EditText editOriginalUnits = findViewById(R.id.editOriginalUnits);

        /*

        //check drop down menu
        Spinner conversion = findViewById(R.id.spinnerConvert);
        String[] conversion_types = getResources().getStringArray(R.array.conversion_options);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_item, conversion_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        conversion.setAdapter(adapter);

        //conversion.setOnItemSelectedListener(MainActivity.this);
    */

        //convert button onclick
        Button btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalNumber = editOriginalUnits.getText().toString();
                //check if user input data
                if (!originalNumber.isEmpty()) {
                    //pass input units
                    Intent intent = new Intent(MainActivity.this, ConvertUnits.class);
                    intent.putExtra("originalNumber", originalNumber);
                    //check conversion type
                    if (result == 1) {
                        intent.putExtra("conversion", "cm_to_m");
                    } else if (result == 2){
                        intent.putExtra("conversion","m_to_cm");
                    } else if (result == 3) {
                        intent.putExtra("conversion", "cm_to_mm");
                    } else if (result == 4 ) {
                        intent.putExtra("conversion", "mm_to_cm");
                    } else if (result == 5 ) {
                        intent.putExtra("conversion", "km_to_m");
                    } else if (result == 6 ) {
                        intent.putExtra("conversion", "m_to_km");
                    } else if (result == 7 ) {
                        intent.putExtra("conversion", "cm_to_km");
                    } else if (result == 8 ) {
                        intent.putExtra("conversion", "km_to_cm");
                    } else if (result == 9 ) {
                        intent.putExtra("conversion", "m_to_mm");
                    } else if (result == 10) {
                        intent.putExtra("conversion", "mm_to_m");
                    } else if (result == 11) {
                        intent.putExtra("conversion", "mm_to_km");
                    } else if (result == 12) {
                        intent.putExtra("conversion", "km_to_mm");
                    }
                    //switch screen
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Please input units to be converted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.spinnerConvert) {
            String conversion_type = adapterView.getItemAtPosition(i).toString();
            if (conversion_type.equals("cm to m")) {

            } else {

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}