package com.example.lab2;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double Num;
    double Currency_Converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText Number = (EditText) findViewById(R.id.num1);
       final TextView Result = (TextView) findViewById(R.id.output);
       final RadioButton Euro = (RadioButton) findViewById(R.id.radioButton1);
       final RadioButton Peso = (RadioButton) findViewById(R.id.radioButton2);
       final RadioButton Dollar = (RadioButton) findViewById(R.id.radioButton3);

      final Button bttn = (Button) findViewById(R.id.button);

      bttn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Num = Double.parseDouble(Number.getText().toString());
              DecimalFormat tenth = new DecimalFormat(("#.#"));

              if(Euro.isChecked()){

                  if(Num <100000){
                  Currency_Converted = Num * 1.16303;
                  Result.setText( Num + "USD = " + Currency_Converted+ " Euro");}
                  else{
                      Toast.makeText(MainActivity.this, "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                  }

              }

              if(Peso.isChecked()){

                  if(Num<100000){
                  Currency_Converted = Num * 0.05;
                  Result.setText(Num + "USD = " + Currency_Converted+ " Mexican Peso");}
                  else{
                      Toast.makeText(MainActivity.this, "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                  }
          }

              if(Dollar.isChecked()){

                  if(Num<100000){
                  Currency_Converted = Num * 0.79;
                  Result.setText(Num + "USD = " + Currency_Converted+ " Canadian Dollar");}
                  else{
                      Toast.makeText(MainActivity.this, "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                  }
              }

      }


    });
  }
}