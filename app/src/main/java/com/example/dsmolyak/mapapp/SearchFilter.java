package com.example.dsmolyak.mapapp;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Drew on 2/25/2016.
 */
public class SearchFilter extends Filter {
    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint){
        constraint = constraint.toString().toLowerCase();
        FilterResults result = new FilterResults();
        if(constraint != null && constraint.toString().length() > 0)
        {
            ArrayList<Room> filteredItems = new ArrayList<Room>();

            for(int i = 0, l = SearchActivity.classroomList.size(); i < l; i++)
            {
                Room room = SearchActivity.classroomList.get(i);
                if(room.toString().toLowerCase().contains(constraint))
                    filteredItems.add(room);
            }
            result.count = filteredItems.size();
            result.values = filteredItems;
        }
        else
        {
            synchronized(this)
            {
                result.values = SearchActivity.classroomList;
                result.count = SearchActivity.classroomList.size();
            }
        }
        return result;
    }
    @Override
    public void publishResults (CharSequence constraint, Filter.FilterResults results){

    }
}
