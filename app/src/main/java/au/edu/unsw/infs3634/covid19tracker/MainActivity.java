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

public class MainActivity extends AppCompatActivity{
    private Button btnSelectConversion;
    private Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate select conversion button
        btnSelectConversion = findViewById(R.id.btnSelectConversion);
        btnSelectConversion.setOnClickListener(new View.OnClickListener() {

            //Switch screens to select conversion activity when clicked
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectConversion.class);
                startActivity(intent);
            }
        });

        //Instantiate random conversion button
        btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {

            //Switch screens to random conversion activity when clicked
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RandomConversion.class);
                startActivity(intent);
            }
        });
    }

}