package com.example.android_no4_taximoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_no4_taximoney.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(taxi);
    }

    private View.OnClickListener taxi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            EditText findcount = (EditText)findViewById(R.id.editview1);
            EditText findcount1 = (EditText)findViewById(R.id.editview2);
            EditText findcount2 = (EditText)findViewById(R.id.editview3);
            int standard = 75;
            double distance = Double.parseDouble(findcount.getText().toString());
            double basicCount = Double.parseDouble(findcount1.getText().toString());
            double addCost = Double.parseDouble(findcount2.getText().toString());
            double count = standard + ((distance / basicCount) * addCost);
            TextView cost = (TextView)findViewById(R.id.textview5);
            if (distance < 250){
                cost.setText("80 元");
            }
            else if(distance >= 250 && addCost >=5){
                cost.setText(nf.format(count) + "元");
            }
        }
    };
}