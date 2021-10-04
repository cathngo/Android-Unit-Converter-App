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

        //get units entered
        EditText editOriginalUnits = findViewById(R.id.editOriginalUnits1);

        //check drop down menu
        Spinner conversion = findViewById(R.id.spinnerConvert1);
        String[] conversion_types = getResources().getStringArray(R.array.conversion_options);
        ArrayAdapter adapter = new ArrayAdapter(SelectConversion.this,
                android.R.layout.simple_spinner_item, conversion_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        conversion.setAdapter(adapter);
        conversion.setOnItemSelectedListener(SelectConversion.this);

        //convert button onclick
        Button btnConvert = findViewById(R.id.btnConvert1);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalNumber = editOriginalUnits.getText().toString();
                //check if user input data
                if (!originalNumber.isEmpty()) {
                    //pass input units
                    Intent intent = new Intent(SelectConversion.this, ConvertUnits.class);
                    intent.putExtra("originalNumber", originalNumber);
                    //check conversion type
                    intent.putExtra("conversion", conversion.getSelectedItem().toString());
                    //switch screen
                    startActivity(intent);
                } else {
                    Toast.makeText(SelectConversion.this,
                            "Please input units to be converted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

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