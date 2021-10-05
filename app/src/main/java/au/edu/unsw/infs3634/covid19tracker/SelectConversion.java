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

public class SelectConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView txtLeftUnit;
    private TextView txtRightUnit;
    private TextView txtPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_conversion);

        //Get user input for units to be converted
        EditText editOriginalUnits = findViewById(R.id.editOriginalUnits1);

        //Instantiate drop down menu for selection
        Spinner conversion = findViewById(R.id.spinnerConvert1);
        String[] conversion_types = getResources().getStringArray(R.array.conversion_options);
        ArrayAdapter adapter = new ArrayAdapter(SelectConversion.this,
                android.R.layout.simple_spinner_item, conversion_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        conversion.setAdapter(adapter);
        conversion.setOnItemSelectedListener(SelectConversion.this);

        //Instantiate convert button and switch to convert activity when clicked
        Button btnConvert = findViewById(R.id.btnConvert1);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalNumber = editOriginalUnits.getText().toString();
                //Check that the user inputted data
                if (!originalNumber.isEmpty()) {
                    //Pass the original number as an intent extra
                    Intent intent = new Intent(SelectConversion.this, ConvertUnits.class);
                    intent.putExtra("originalNumber", originalNumber);
                    //Check the conversion type selected
                    intent.putExtra("conversion", conversion.getSelectedItem().toString());
                    //Switch screens
                    startActivity(intent);
                } else {
                    //Error message
                    Toast.makeText(SelectConversion.this,
                            "Please enter a number to convert", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Change the conversion type depending on option user selects from spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        txtLeftUnit = findViewById(R.id.txtLeftUnit1);
        txtRightUnit= findViewById(R.id.txtRightUnit1);
        txtPrompt = findViewById(R.id.txtPrompt1);
        if (adapterView.getId() == R.id.spinnerConvert1) {
            String conversion_type = adapterView.getItemAtPosition(i).toString();
            if (conversion_type.equals("cm to m")) {
                txtLeftUnit.setText("CM");
                txtRightUnit.setText("M");
                txtPrompt.setText("Enter units in centimetres to convert");
            } else if (conversion_type.equals("m to cm")){
                txtLeftUnit.setText("M");
                txtRightUnit.setText("CM");
                txtPrompt.setText("Enter units in metres to convert");
            } else if (conversion_type.equals("cm to mm")) {
                txtLeftUnit.setText("CM");
                txtRightUnit.setText("MM");
                txtPrompt.setText("Enter units in centimetres to convert");
            } else if (conversion_type.equals("mm to cm")){
                txtLeftUnit.setText("MM");
                txtRightUnit.setText("CM");
                txtPrompt.setText("Enter units in millimetres to convert");
            } else if (conversion_type.equals("km to m")){
                txtLeftUnit.setText("KM");
                txtRightUnit.setText("M");
                txtPrompt.setText("Enter units in kilometres to convert");
            } else if (conversion_type.equals("m to km")){
                txtLeftUnit.setText("M");
                txtRightUnit.setText("KM");
                txtPrompt.setText("Enter units in metres to convert");
            } else if (conversion_type.equals("cm to km")){
                txtLeftUnit.setText("CM");
                txtRightUnit.setText("KM");
                txtPrompt.setText("Enter units in centimetres to convert");
            } else if (conversion_type.equals("km to cm")) {
                txtLeftUnit.setText("KM");
                txtRightUnit.setText("CM");
                txtPrompt.setText("Enter units in kilometres to convert");
            } else if (conversion_type.equals("m to mm")) {
                txtLeftUnit.setText("M");
                txtRightUnit.setText("MM");
                txtPrompt.setText("Enter units in metres to convert");
            } else if (conversion_type.equals("mm to m")) {
                txtLeftUnit.setText("MM");
                txtRightUnit.setText("M");
                txtPrompt.setText("Enter units in millimetres to convert");
            } else if (conversion_type.equals("mm to km")) {
                txtLeftUnit.setText("MM");
                txtRightUnit.setText("KM");
                txtPrompt.setText("Enter units in millimetres to convert");
            } else if (conversion_type.equals("km to mm")) {
                txtLeftUnit.setText("KM");
                txtRightUnit.setText("MM");
                txtPrompt.setText("Enter units in kilometres to convert");
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}