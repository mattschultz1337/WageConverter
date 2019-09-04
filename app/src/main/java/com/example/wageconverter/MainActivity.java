package com.example.wageconverter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText wage = findViewById(R.id.HourlyWage);
        final TextView mainText = findViewById(R.id.Pennies);

        final TextView yearlyText = findViewById(R.id.Yearly);

        final TextView cokeText = findViewById(R.id.coke);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                double value = 0;
                double Potter = 0;
                double YearlyNum = 0;
                double cokeNum = 30000;
                String text = wage.getText().toString();
                if(!text.isEmpty())
                    try
                    {
                        value= Double.parseDouble(text);
                        // it means it is double
                    } catch (Exception e1) {
                        // this means it is not double
                        e1.printStackTrace();
                    }
                Potter = value * 19.65;
                DecimalFormat df = new DecimalFormat("#.00");
                mainText.setText("$" + df.format(Potter) + "");
                YearlyNum = value * 2080;
                yearlyText.setText("$" + df.format((YearlyNum)) + "");
                cokeNum = (cokeNum / value)/8;
                cokeText.setText(df.format(cokeNum));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
