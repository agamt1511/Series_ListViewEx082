package com.example.series_listviewex082;

import androidx.appcompat.app.AppCompatActivity;

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
    float fOrgan, srm;
    boolean oSeries;
    Button btn2;

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

        ri = new Intent(this,MainActivity.class);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,organs);
        lv.setAdapter(adp);

        start();
    }

    private void start() {
        ri = getIntent();
        fOrgan = ri.getFloatExtra("fOrgan", 0);
        srm = ri.getFloatExtra("srm", 0);
        oSeries = ri.getBooleanExtra("oSeries",true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv2.setText("X1 = " + fOrgan);
        tv3.setText("d = " + srm);
        tv4.setText("n = " + (position + 1));
        if (oSeries == false){
            tv5.setText("Sn = " + fOrgan*(position + 1));
        }
        tv5.setText("Sn = " + Math.pow(fOrgan,(position + 1)));
    }

    public void goBack(View view) {
        startActivity(ri);
    }
}