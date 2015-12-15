package com.example.dsmolyak.mapapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image = (ImageView) findViewById(R.id.imageView1);


        final ArrayList<Button> classrooms = new ArrayList<>();
        classrooms.add((Button)findViewById(R.id.C128));
        classrooms.add((Button)findViewById(R.id.C129));
        classrooms.add((Button)findViewById(R.id.C130));
        classrooms.add((Button)findViewById(R.id.C131));
        classrooms.add((Button)findViewById(R.id.C132));
        classrooms.add((Button)findViewById(R.id.C133));
        classrooms.add((Button)findViewById(R.id.C134));
        classrooms.add((Button)findViewById(R.id.C135));
        classrooms.add((Button)findViewById(R.id.C136));
        classrooms.add((Button)findViewById(R.id.C137));
        classrooms.add((Button)findViewById(R.id.C138));
        classrooms.add((Button)findViewById(R.id.C139));
        classrooms.add((Button)findViewById(R.id.C140));
        classrooms.add((Button)findViewById(R.id.C141));
        classrooms.add((Button)findViewById(R.id.C142));
        classrooms.add((Button)findViewById(R.id.C143));
        classrooms.add((Button)findViewById(R.id.C144));
        classrooms.add((Button)findViewById(R.id.C145));
        classrooms.add((Button)findViewById(R.id.C146));
        classrooms.add((Button)findViewById(R.id.C147));
        classrooms.add((Button)findViewById(R.id.C148));
        classrooms.add((Button)findViewById(R.id.C149));
        classrooms.add((Button)findViewById(R.id.C150));
        classrooms.add((Button)findViewById(R.id.C151));
        classrooms.add((Button)findViewById(R.id.C152));
        classrooms.add((Button)findViewById(R.id.C153));
        classrooms.add((Button)findViewById(R.id.C154));
        classrooms.add((Button)findViewById(R.id.C155));
        classrooms.add((Button)findViewById(R.id.C156));

//        boolean[] clicked = new boolean[29];

        for (int i = 0; i < 29; i++) {
            final int j = i;
            classrooms.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    classrooms.get(j).setBackgroundColor(Color.GREEN);
                }
            });
        }


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
