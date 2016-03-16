package com.example.dsmolyak.mapapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.api.client.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FirstFloor extends AppCompatActivity {

    private static final String TAG = "tag";
    ImageView image;
    SearchView searchView;
    String send;
    String received;

    //The "x" and "y" position of the "Show Button" on screen.

    ArrayList<Button> prevSearch = new ArrayList<Button>();
    ArrayList<Button> currSearch = new ArrayList<Button>();
    ArrayList<Button> buttons;
    ArrayList<Point> points;
    static DriveConnect dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<Button> classrooms = new ArrayList<>();

// <editor-fold desc="Buttons">
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
        // </editor-fold>

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
                        showPopup(FirstFloor.this, points.get(j), j);
                    }

                }
            });
        }




        if (dc == null) {
            dc = new DriveConnect();
            dc.execute(new FileWrapper(OpenFileDialog(), OpenotherFileDialog()));
        }
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
        searchView.setQuery("", false);
        searchView.setIconified(true);
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

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, 700, 450);

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



    public int convertToInt(String id) {
        if (id.length() != 3 && id.length() != 4) {
            return -1;
        }
        if (id.length() == 4) {
            id = id.substring(1);
        }
        if (id.equalsIgnoreCase("Gym")) {
            return 77;
        }
        int result = Integer.valueOf(id);
        result -= 100;
        if (result >= 0 && result <= 90) {
            return result;
        }
        return -1;

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

        SearchManager searchManager = (SearchManager) FirstFloor.this.getSystemService(Context.SEARCH_SERVICE);

        final MenuItem searchMenuItem = menu.findItem(R.id.searchView);
        final SearchView search = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView = search;

        int options = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            options = search.getImeOptions();
        }
        search.setImeOptions(options | EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        search.setQueryHint("Search");
        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                currSearch.clear();
                send = query;
                ArrayList<Room> rooms = dc.getRoomHandler().getAllRooms();
                if (prevSearch.size() != 0) {
                    for (Button button : prevSearch) {

                        button.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                for (Room room : rooms) {
                    if (room.contains(query)) {
                        float[] hsv = {120, 100, 100};
                        int id = convertToInt(room.getRoomNumber());
                        if (id != -1) {
                            buttons.get(id).setBackgroundColor(Color.HSVToColor(50, hsv));
                            currSearch.add(buttons.get(id));
                        } else {
                        }
                    }
                }

                prevSearch = (ArrayList<Button>) currSearch.clone();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                return false;
            }
        });

        received = getIntent().getStringExtra("Search");
        System.out.println("Second Check: " + received);
        search.setQuery(received, true);


        if (search != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(search.getWindowToken(), 0);
            System.out.println("IWENTHERE1");
        }
        search.setIconified(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement



        if (id == R.id.second_floor) {
            Intent second = new Intent(this, SecondFloor.class).putExtra("Search", send);
            System.out.println("First Check: " + send);
            startActivity(second);
        }

        return super.onOptionsItemSelected(item);
    }


}
