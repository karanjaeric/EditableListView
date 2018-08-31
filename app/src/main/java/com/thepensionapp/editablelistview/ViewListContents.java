package com.thepensionapp.editablelistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ekaranja on 3/25/18.
 */

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView=(ListView)findViewById(R.id.listView);
        db=new DatabaseHelper(this);
        ArrayList<String>theList=new ArrayList<>();
        Cursor data=db.getListContents();
        if(data.getCount()==0)
            Toast.makeText(ViewListContents.this,"The Database was empty",Toast.LENGTH_LONG).show();
        else{

            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }


    }
}
