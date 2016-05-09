package com.example.dsmolyak.mapapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondFloor extends AppCompatActivity implements View.OnTouchListener {

    ArrayList<Button> buttons;
    ArrayList<Button> prevSearch = new ArrayList<Button>();
    ArrayList<Button> currSearch = new ArrayList<Button>();
    ArrayList<Point> points;
    DriveConnect dc;
    String received;
    String send;
    SearchView searchView;
    private ScaleGestureDetector mScaleDetector;
    Button change;
    int changeColor;
    PopupWindow popupWindow;

    RelativeLayout relativeLayout;
    ScrollView scroll;
    HorizontalScrollView horizontalScrollView;
    FrameLayout.LayoutParams layoutParams;
    float totalScaleFactor;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        relativeLayout = (RelativeLayout) findViewById(R.id.fitsIsit);
        scroll = (ScrollView) findViewById(R.id.scrollView2);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView2);

        totalScaleFactor = 1;

        scaleGestureDetector = new ScaleGestureDetector(this.getBaseContext(), new OnPinchListener());

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                scaleGestureDetector.onTouchEvent(event);

                return true;
            }
        });

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

        changeColor = Color.TRANSPARENT;

        final ArrayList<Boolean> colored = new ArrayList<Boolean>();
        for (int i = 0; i < size; i++) {
            colored.add(true);
        }

        for (int i = 0; i < classrooms.size(); i++) {
            final int j = i;
            classrooms.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    float[] hsv = {206, 100, 100};

                    showPopup(SecondFloor.this, j);
                    classrooms.get(j).setBackgroundColor(Color.HSVToColor(50, hsv));


                }
            });
        }

        mScaleDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
            }
            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
//                Log.d(LOG_KEY, "zoom ongoing, scale: " + detector.getScaleFactor());
                System.out.println("That's a god question");
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleDetector.onTouchEvent(event);
        System.out.println("Bob Saget");
        return true;
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

        if (change != null && !popupWindow.isShowing()) {
            change.setBackgroundColor(changeColor);
        }
    }

    private void showPopup(final Activity context, int j) {



        searchView.setQuery("", false);
        searchView.setIconified(true);
        int popupWidth = 500;
        int popupHeight = 375;

        String roomId = convertToId(j);

        Button button = buttons.get(j);
        if (button != null) {
            change = button;
            if (button.getBackground() != null) {
                changeColor = ((ColorDrawable) button.getBackground()).getColor();
            }
            else {
                changeColor = Color.TRANSPARENT;
            }
        }

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
            setSchedule(info, teachers);
            classInfo.setText(info.toString());
        }

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = -170;
        int OFFSET_Y = 85;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, 1100, 450);

        popupWindow = popup;

    }

    private void setSchedule(StringBuilder info, String[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            String teacher = teachers[i];
            String periodNumber;
            if (i < 3) {
                periodNumber = (i + 1) + "";
            }
            else if (i == 3) {
                periodNumber = (i + 1) + "A";
            }
            else if (i == 4) {
                periodNumber = (i) + "B";
            }
            else {
                periodNumber = i + "";
            }
            info.append("Period " + periodNumber + ": ");
            if (teacher == "" || teacher == null) {
                info.append("Planning" + "\n");
            }
            else {
                info.append(teacher + "\n");
            }
        }
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
                int counter = 0;
                int roomId = 0;
                for (Room room : rooms) {
                    if (room.contains(query)) {
                        counter++;
                        roomId = convertToInt(room.getRoomNumber());
                        float[] hsv = {120, 100, 100};
                        int id = convertToInt(room.getRoomNumber());
                        if (id != -1) {
                            buttons.get(id).setBackgroundColor(Color.HSVToColor(50, hsv));
                            currSearch.add(buttons.get(id));
                        }
                    }
                }
                if (counter == 1){
                    showPopup(SecondFloor.this,roomId);
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




        search.setIconified(true);
        search.clearFocus();

//        if (search != null) {
//            hideSoftKeyboard(this);
//            System.out.println("IWENTHERE2");
//        }

        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                received = data.getStringExtra("Search");
                System.out.println("Second Check: " + received);
                searchView.setQuery(received, true);
            }
        }
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
            Intent first = new Intent(this, FirstFloor.class).putExtra("Search", send);
            System.out.println("First Check: " + send);
            startActivityForResult(first, 1);
            startActivity(first);
        }

        if (id == R.id.help) {
            Intent help = new Intent(this, HelpActivity.class);
            startActivity(help);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Intent intent = new Intent();
        if(searchView.getQuery()!="") {
            intent.putExtra("Search",send);
            setResult(RESULT_OK, intent);
            System.out.println("Stop having it be closed");
        }
    }

    private class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        float currentSpan;
        float lastScaleFactor;
        float lastSpan = 1f;
        ImageView uhhhhh = (ImageView) findViewById(R.id.imageView2);
        float originalImageWidth , originalImageHeight ;
        float newImageWidth, newImageHeight;


        public boolean onScaleBegin(ScaleGestureDetector detector) {
            lastScaleFactor = 1f;
            lastSpan = detector.getCurrentSpan();
            System.out.println("Start Span: " + lastSpan);
            totalScaleFactor = 1f;

            return true;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        public boolean onScale(ScaleGestureDetector detector) {


            currentSpan = detector.getCurrentSpan();
            lastScaleFactor = ((lastScaleFactor + (currentSpan / lastSpan)) / 2f);
            relativeLayout.setScaleX(lastScaleFactor);
            relativeLayout.setScaleY(lastScaleFactor);
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(relativeLayout.getWidth(), relativeLayout.getHeight());
            }
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector) {
            System.out.println("Final Span: " + currentSpan);
//            System.out.println("new scale" + lastScaleFactor);
            if(originalImageHeight==0f){
                originalImageHeight=uhhhhh.getHeight();
                originalImageWidth=uhhhhh.getWidth();
//                System.out.println("Height: " + uhhhhh.getHeight());
//                System.out.println("Width: " + uhhhhh.getWidth());
            }
            newImageHeight = originalImageHeight * lastScaleFactor;
            newImageWidth = originalImageWidth * lastScaleFactor;
//            System.out.println("Old Height "+originalImageHeight+" Old Width "+originalImageWidth+" \nNew Height "+newImageHeight+" New Width "+newImageWidth);
            layoutParams.setMargins((int) ((newImageWidth - originalImageWidth) / 2), (int)(/*layoutParams.topMargin*/+ (newImageHeight - originalImageHeight)/2),(int) ((newImageWidth - originalImageWidth) / 2), (int) (/*layoutParams.bottomMargin +*/ (newImageHeight - originalImageHeight)/2));
            relativeLayout.setLayoutParams(layoutParams);
            //relativeLayout.setTranslationX(-1*(newImageWidth - originalImageWidth) / 2);

//            System.out.println("Scroll Height: " + scroll.getHeight());
//            System.out.println("Scroll Width: " + scroll.getWidth());
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
