package com.example.dsmolyak.mapapp;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LinearLayout.LayoutParams params;
    LinearLayout mainLayout;
    boolean click = true;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        popUp = new PopupWindow(this);
//        layout = new LinearLayout(this);
////        mainLayout = new LinearLayout(this);
//        tv = new TextView(this);
//
//        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        tv.setText("Hi this is a sample text for popup window");
//        layout.addView(tv, params);
//        popUp.setContentView(layout);
//        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
////        setContentView(mainLayout);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        image = (ImageView) findViewById(R.id.imageView1);
//        Drawable image1 = getResources().getDrawable(R.drawable.ahs_map1);

//        Zoom zoom = new Zoom(this, image1);

        textview = (TextView) findViewById(R.id.textView);

        final ArrayList<Button> classrooms = new ArrayList<>();

        classrooms.add((Button)findViewById(R.id.A100));
        classrooms.add((Button)findViewById(R.id.A101));
        classrooms.add((Button)findViewById(R.id.A102));
        classrooms.add((Button)findViewById(R.id.A103));
        classrooms.add((Button)findViewById(R.id.A104));
        classrooms.add((Button)findViewById(R.id.A105));
        classrooms.add((Button)findViewById(R.id.A106));
        classrooms.add((Button)findViewById(R.id.A107));
        classrooms.add((Button)findViewById(R.id.A108));
        classrooms.add((Button)findViewById(R.id.A109));
        classrooms.add((Button)findViewById(R.id.A110));
        classrooms.add((Button)findViewById(R.id.A111));
        classrooms.add((Button)findViewById(R.id.A112));
        classrooms.add((Button)findViewById(R.id.A113));

        classrooms.add((Button)findViewById(R.id.B114));
        classrooms.add((Button)findViewById(R.id.B115));
        classrooms.add((Button)findViewById(R.id.B116));
        classrooms.add((Button)findViewById(R.id.B117));
        classrooms.add((Button)findViewById(R.id.B118));
        classrooms.add((Button)findViewById(R.id.B119));
        classrooms.add((Button)findViewById(R.id.B120));
        classrooms.add((Button)findViewById(R.id.B121));
        classrooms.add((Button)findViewById(R.id.B122));
        classrooms.add((Button)findViewById(R.id.B123));
        classrooms.add((Button)findViewById(R.id.B124));
        classrooms.add((Button)findViewById(R.id.B125));
        classrooms.add((Button)findViewById(R.id.B126));
        classrooms.add((Button)findViewById(R.id.B127));

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

        classrooms.add((Button)findViewById(R.id.D157));
        classrooms.add((Button)findViewById(R.id.D158));
        classrooms.add((Button)findViewById(R.id.D159));
        classrooms.add((Button)findViewById(R.id.D160));
        classrooms.add((Button)findViewById(R.id.D161));
        classrooms.add((Button)findViewById(R.id.D162));
        classrooms.add((Button)findViewById(R.id.D163));
        classrooms.add((Button)findViewById(R.id.D164));
        classrooms.add((Button)findViewById(R.id.D165));
        classrooms.add((Button)findViewById(R.id.D166));
        classrooms.add((Button)findViewById(R.id.D167));
        classrooms.add((Button)findViewById(R.id.D168));
        classrooms.add((Button)findViewById(R.id.D169));
        classrooms.add((Button)findViewById(R.id.D170));

        classrooms.add((Button)findViewById(R.id.E171));
        classrooms.add((Button)findViewById(R.id.E172));
        classrooms.add((Button)findViewById(R.id.E173));
        classrooms.add((Button)findViewById(R.id.E174));
        classrooms.add((Button)findViewById(R.id.E175));
        classrooms.add((Button)findViewById(R.id.E176));
        classrooms.add((Button)findViewById(R.id.E177));

        classrooms.add((Button)findViewById(R.id.F178));
        classrooms.add((Button)findViewById(R.id.F179));
        classrooms.add((Button)findViewById(R.id.F180));
        classrooms.add((Button)findViewById(R.id.F181));
        classrooms.add((Button)findViewById(R.id.F182));
        classrooms.add((Button)findViewById(R.id.F183));
        classrooms.add((Button)findViewById(R.id.F184));
        classrooms.add((Button)findViewById(R.id.F186));
        classrooms.add((Button)findViewById(R.id.F187));
        classrooms.add((Button)findViewById(R.id.F188));
        classrooms.add((Button)findViewById(R.id.F189));
        classrooms.add((Button) findViewById(R.id.F190));

        for (int i = 0; i < classrooms.size(); i++) {
            final int j = i;
            classrooms.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    classrooms.get(j).setBackgroundColor(Color.LTGRAY);
                    textview.setText((j + 100) + "");
//                    if (click) {
//                        popUp.showAtLocation(mainLayout, Gravity.BOTTOM, 10, 10);
//                        popUp.update(50, 50, 300, 80);
//                        click = false;
//                    } else {
//                        popUp.dismiss();
//                        click = true;
//                    }
                }
            });
        }

//        InputStream in = OpenotherFileDialog();
//        File file = new File(in);
//        DriveConnect.connect(OpenFileDialog());

    }
    public InputStream OpenFileDialog(){
        Resources res = this.getResources();
        InputStream in = res.openRawResource(R.raw.client_secret);
        return in;
    }
    public InputStream OpenotherFileDialog(){
        Resources res = this.getResources();
        InputStream in = res.openRawResource(R.raw.my_project_70bcd65a0234);
        return in;
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
            System.out.println("settings");
            return true;
        }

        if (id == R.id.second_floor) {
            System.out.println("second floor");
        }

        return super.onOptionsItemSelected(item);
    }



}
