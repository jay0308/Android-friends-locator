package com.example.jaykarn.ourproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by JayKarn on 3/18/2016.
 */
public class ContactsList extends ListActivity {
    String contacts[]={"Contact 1","Contact 2","Contact 3","Contact 4","Contact 5","Contact 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(ContactsList.this, android.R.layout.simple_dropdown_item_1line, contacts));
        ListView lv = getListView();
        lv.setCacheColorHint(0);
        lv.setBackgroundResource(R.drawable.bg);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        v.setBackgroundColor(6);
        String cheese=contacts[position];
        Toast.makeText(ContactsList.this,cheese,Toast.LENGTH_SHORT).show();
//        try {
//            Class myClass =Class.forName("com.example.jaykarn.test."+cheese);
//
//            Intent myIntent=new Intent(ContactsList.this,myClass);
//            startActivity(myIntent);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

}
