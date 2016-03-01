package com.example.dsmolyak.mapapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.api.client.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Button> buttons;
    ArrayList<Point> points;
    DriveConnect dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<Button> classrooms = new ArrayList<>();

        classrooms.add((Button)findViewById(R.id.G200));
        classrooms.add((Button)findViewById(R.id.G201));
        classrooms.add((Button)findViewById(R.id.G202));
        classrooms.add((Button)findViewById(R.id.G203));
        classrooms.add((Button)findViewById(R.id.G204));
        classrooms.add((Button)findViewById(R.id.G205));
        classrooms.add((Button)findViewById(R.id.G206));
        classrooms.add((Button)findViewById(R.id.G207));
        classrooms.add((Button)findViewById(R.id.G208));
        classrooms.add((Button)findViewById(R.id.G209));
        classrooms.add((Button)findViewById(R.id.G210));
        classrooms.add((Button)findViewById(R.id.G211));
        classrooms.add((Button)findViewById(R.id.G212));
        classrooms.add((Button)findViewById(R.id.G213));
        classrooms.add((Button)findViewById(R.id.G214));
        classrooms.add((Button)findViewById(R.id.G215));

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
//                    if (colored.get(j)) {
//                        classrooms.get(j).setBackgroundColor(Color.LTGRAY);
//                    }
//                    else {
//                        classrooms.get(j).setBackgroundColor(Color.TRANSPARENT);
//                    }
//                    colored.set(j, !colored.get(j));


                    //Open popup window
                    if (points.get(j) != null) {
                        showPopup(SecondActivity.this, points.get(j), j);
                    }

                }
            });
        }

        dc = new DriveConnect();
        dc.execute(new FileWrapper(OpenFileDialog(), OpenotherFileDialog()));




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

        String roomId = convertToId(j);

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

        TextView title = (TextView)popup.getContentView().findViewById(R.id.textView1);
        title.setText(roomId);

        TextView classInfo = (TextView)popup.getContentView().findViewById(R.id.textView2);
        StringBuilder info = new StringBuilder("");
        System.out.println(classInfo.getText());
        String[] teachers = dc.getRoomHandler().getTeachersInRoom(roomId);
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

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = -170;
        int OFFSET_Y = 85;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, 1100, 450);

    }

    private String convertToId(int j) {
        j = j + 200;
        String result = "G" + j;
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
        getMenuInflater().inflate(R.menu.menu_second_floor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            System.out.println("settings");
            return true;
        }

        if (id == R.id.first_floor) {
            System.out.println("first floor");
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        }

        return super.onOptionsItemSelected(item);
    }

}
