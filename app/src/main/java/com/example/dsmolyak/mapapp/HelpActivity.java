package com.example.dsmolyak.mapapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    TextView helpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helpText = (TextView)findViewById(R.id.helpText);
        helpText.setTextColor(Color.BLACK);
        Button blah = (Button)findViewById(R.id.Fraggot);
        blah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helpText.setTextColor(Color.rgb((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random()*256)));


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.first_floor) {
            Intent first = new Intent(this, FirstFloor.class);
            startActivity(first);
        }

        if (id == R.id.second_floor) {
            Intent second = new Intent(this, SecondFloor.class);
            startActivity(second);
        }

        return super.onOptionsItemSelected(item);
    }

}
