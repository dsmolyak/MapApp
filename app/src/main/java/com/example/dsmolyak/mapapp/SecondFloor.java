package com.example.dsmolyak.mapapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondFloor extends AppCompatActivity {

    ArrayList<Button> buttons;
    ArrayList<Button> prevSearch = new ArrayList<Button>();
    ArrayList<Button> currSearch = new ArrayList<Button>();
    ArrayList<Point> points;
    DriveConnect dc;
    String received;
    String send;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ArrayList<Button> classrooms = new ArrayList<>();
// <editor-fold desc="Buttons">
        classrooms.add((Button)findViewById(R.id.G200));
        classrooms.add((Button)findViewById(R.id.G201));
        classrooms.add((Button)findViewById(R.id.G202));
        classrooms.add((Button)findViewById(R.id.G203));
        classrooms.add((Button)findViewById(R.id.G204));
        classrooms.add((Button) findViewById(R.id.G205));
        classrooms.add((Button) findViewById(R.id.G206));
        classrooms.add((Button) findViewById(R.id.G207));
        classrooms.add((Button) findViewById(R.id.G208));
        classrooms.add((Button) findViewById(R.id.G209));
        classrooms.add((Button)findViewById(R.id.G210));
        classrooms.add((Button) findViewById(R.id.G211));
        classrooms.add((Button)findViewById(R.id.G212));
        classrooms.add((Button)findViewById(R.id.G213));
        classrooms.add((Button)findViewById(R.id.G214));
        classrooms.add((Button)findViewById(R.id.G215));
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


                    //Open popup window
                    if (points.get(j) != null) {
                        showPopup(SecondFloor.this, points.get(j), j);
                    }

                }
            });
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_floor, menu);

        dc = FirstFloor.dc;

        SearchManager searchManager = (SearchManager) SecondFloor.this.getSystemService(Context.SEARCH_SERVICE);

        final SearchView search = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.searchView2));
        searchView = search;

        int options = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            options = search.getImeOptions();
        }
        search.setImeOptions(options | EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        search.setQueryHint("Search");

        search.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                search.clearFocus();
                return false;
            }
        });
        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

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
            System.out.println("IWENTHERE2");
        }
        search.setIconified(true);
        return true;
    }

    public int convertToInt(String id) {
        if (id.length() != 3 && id.length() != 4) {
            return -1;
        }
        if (id.length() == 4) {
            id = id.substring(1);
        }
        if (id.equalsIgnoreCase("Gym")) {
            return -1;
        }
        int result = Integer.valueOf(id);
        result -= 200;
        if (result >= 0 && result <= 90) {
            return result;
        }
        return -1;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.first_floor) {
            Intent main = new Intent(this, FirstFloor.class).putExtra("Search", send);
            System.out.println("First Check: " + send);
            startActivity(main);

        }

        return super.onOptionsItemSelected(item);
    }

}
