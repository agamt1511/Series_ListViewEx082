package com.example.series_listviewex082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb1;
    EditText et1, et2;
    Button btn1;
    Intent si;
    String st1, st2;
    float fOrgan, srm;
    boolean oSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = (ToggleButton) findViewById(R.id.tb1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn1 = (Button) findViewById(R.id.btn1);
        si = new Intent(this,SecondActivity.class);
    }

    public void goResults(View view) {
        st1 = et1.getText().toString();
        fOrgan = Float.valueOf(st1);
        st2 = et2.getText().toString();
        srm = Float.valueOf(st2);
        oSeries = tb1.isChecked();

        si.putExtra("fOrgan", fOrgan);
        si.putExtra("srm", srm);
        si.putExtra("oSeries", oSeries);
        startActivity(si);
    }
}