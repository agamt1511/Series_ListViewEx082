package com.example.series_listviewex082;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    TextView tv2, tv3, tv4, tv5;
    Intent ri;
    Button btn2;
    double fOrgan, srm;
    double[] numbers = new double[20];
    double[] sum = new double[20];
    boolean oSeries;
    String[] organs = new String[20];
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        btn2 = (Button) findViewById(R.id.btn2);

        lv = (ListView) findViewById(R.id.lv);

        ri = new Intent(this, MainActivity.class);
        ri = getIntent();
        fOrgan = ri.getDoubleExtra("fOrgan", 0);
        srm = ri.getDoubleExtra("srm", 0);
        oSeries = ri.getBooleanExtra("oSeries", true);

        tv2.setText("X1 = " + fOrgan);
        tv3.setText("d = " + srm);

        numbers[0] = fOrgan;
        organs[0] = String.valueOf(numbers[0]);
        sum[0] = numbers[0];
        if (oSeries == false) {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] + srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i-1] + numbers[i];
            }
        } else {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] * srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i-1] + numbers[i];
            }
        }
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,organs);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        place = (String.valueOf(position+1));
        tv4.setText(place);
        tv5.setText("Sn = " + sum[position]);
    }

    public void goBack(View view) {
        finish();
    }
}