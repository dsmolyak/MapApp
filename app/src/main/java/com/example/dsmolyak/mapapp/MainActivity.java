package com.example.dsmolyak.mapapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.api.client.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    //The "x" and "y" position of the "Show Button" on screen.

    ArrayList<Button> buttons;
    ArrayList<Point> points;
    DriveConnect dc=null;

    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        image = (ImageView) findViewById(R.id.imageView1);

        TextView tv = new TextView(this);

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

        int size = classrooms.size();
        buttons = classrooms;

        final ArrayList<Boolean> colored = new ArrayList<Boolean>();
        for (int i = 0; i < size; i++) {
            colored.add(true);
        }

        for (int i = 0; i < classrooms.size(); i++) {
            final int j = i;
            classrooms.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (colored.get(j)) {
                        classrooms.get(j).setBackgroundColor(Color.LTGRAY);
                    }
                    else {
                        classrooms.get(j).setBackgroundColor(Color.TRANSPARENT);
                    }
                    colored.set(j, !colored.get(j));


                    //Open popup window
                    if (points.get(j) != null) {
                        showPopup(MainActivity.this, points.get(j), j);
                    }

                }
            });
        }

        dc= new DriveConnect();
        dc.execute(new FileWrapper(OpenFileDialog(),OpenotherFileDialog()));

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        int[] location = new int[2];

        points = new ArrayList<Point>();


        for (Button button : buttons) {
            // Get the x, y location and store it in the location[] array
            // location[0] = x, location[1] = y.
            button.getLocationOnScreen(location);

            //Initialize the Point with x, and y positions
            Point p = new Point();
            p.x = location[0];
            p.y = location[1];
            points.add(p);
        }

    }

    private void showPopup(final Activity context, Point p, int j) {
        int popupWidth = 500;
        int popupHeight = 375;

        String id = convertToId(j);



        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_layout, viewGroup);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = -170;
        int OFFSET_Y = 85;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.
        ImageButton close = (ImageButton) layout.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

        TextView classInfo = (TextView)popup.getContentView().findViewById(R.id.textView2);
        StringBuilder info = new StringBuilder("");
        System.out.println(classInfo.getText());
        String[] teachers = dc.getRoomHandler().getTeachersInRoom(id);
        if (teachers == null) {
            classInfo.setText("Empty");
        }
        else {
            for (int i = 0; i < teachers.length; i++) {
                String teacher = teachers[i];
                if (teacher == "" || teacher == null) {
                    info.append("Period " + (i + 1) + ": Planning" + "\n");
                }
                else {
                    info.append("Period " + (i + 1) + ": " + teacher + "\n");
                }
            }
            classInfo.setText(info.toString());
        }
    }

    private String convertToId(int j) {
        j = j + 100;
        String result = j + "";
        if (j >= 100 && j <= 113) {
            result = 'A' + result;
        }
        else if (j >= 114 && j <= 127) {
            result = 'B' + result;
        }
        else if (j >= 128 && j <= 156) {
            result = 'C' + result;
        }
        else if (j >= 157 && j <= 170) {
            result = 'D' + result;
        }
        else if (j >= 171 && j <= 177) {
            result = 'E' + result;
        }
        else if (j >= 178 && j <= 190) {
            result = 'F' + result;
        }

        return result;
    }

    public InputStream OpenFileDialog(){
        Resources res = this.getResources();
        InputStream in = res.openRawResource(R.raw.client_secret);
        return in;
    }
    public File OpenotherFileDialog(){
        try {
            Resources res = this.getResources();
            InputStream in = res.openRawResource(R.raw.my_project_70bcd65a0234);

            final File tempFile = File.createTempFile("my_project_10bcd65a0234", ".p12");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            IOUtils.copy(in, out);
            return tempFile;

        }
        catch(IOException e){
            System.out.println(e);
            return null;
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
            System.out.println("settings");
            return true;
        }

        if (id == R.id.second_floor) {
            System.out.println("second floor");
            Intent second = new Intent(this, SecondActivity.class);
            startActivity(second);
        }

        return super.onOptionsItemSelected(item);
    }



}
