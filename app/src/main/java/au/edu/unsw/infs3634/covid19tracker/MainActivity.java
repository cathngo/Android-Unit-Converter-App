package au.edu.unsw.infs3634.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get units entered
        EditText editOriginalUnits = findViewById(R.id.editOriginalUnits);


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
                    //switch screen
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please input units to be converted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}