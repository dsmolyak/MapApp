package com.example.dsmolyak.mapapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by Drew on 2/26/2016.
 */
public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {
    private ListView searchListView;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    private SearchListAdapter searchListAdapter;
    protected static ArrayList<Room> classroomList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list);
        searchListView = new ListView(this);
        searchView = new SearchView(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        initFriendList();
        getMenuInflater().inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();
        System.out.println(searchView);
        System.out.println(searchManager);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
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


    /**
     * Initialize friend list
     */
    public void initFriendList() {
        classroomList = MainActivity.dc.getRoomHandler().getAllRooms();
        searchListView = (ListView) findViewById(R.id.searchList);
        searchListAdapter = new SearchListAdapter(this, classroomList);

        // add header and footer for list
      //  View headerView = View.inflate(this, R.layout.list_header, null);
      //  View footerView = View.inflate(this, R.layout.list_header, null);
        //seachListView.addHeaderView(headerView);
        //friendListView.addFooterView(footerView);
        searchListView.setAdapter(searchListAdapter);
        searchListView.setTextFilterEnabled(false);

        // use to enable search view popup text
        //friendListView.setTextFilterEnabled(true);

        // set up click listener
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= classroomList.size()) {
                    handelListItemClick((Room) searchListAdapter.getItem(position - 1));
                }
            }
        });
    }

    /**
     * Navigate to share activity form here
     *
     * @param room user
     */
    private void handelListItemClick(Room room) {
        // close search view if its visible
        if (searchView.isShown()) {
            searchMenuItem.collapseActionView();
            searchView.setQuery("", false);
        }

        // pass selected user and sensor to share activity
        //Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("com.example.dsmolyak.mapapp.Room", room);
        //this.startActivity(intent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        searchListAdapter.getFilter().filter(newText);

        // use to enable search view popup text
//        if (TextUtils.isEmpty(newText)) {
//            friendListView.clearTextFilter();
//        }
//        else {
//            friendListView.setFilterText(newText.toString());
//        }

        return true;
    }

}
