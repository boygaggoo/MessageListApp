package com.example.messagelistapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. Access the TextView defined in layout XML
        // and then set its text
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");
        // 2. Access the Button defined in layout XML
        // and listen for it here
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        // 3. Access the EditText defined in layout XML
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        // 4. Access the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);

        // Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);
        // 5. Set this activity to react to list items being pressed
        mainListView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        // Take what was typed into the EditText
        // and use in TextView
        mainTextView.setText(mainEditText.getText().toString()
                + " is learning Android development!");
        // Also add that value to the list shown in the ListView
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        // Log the item's position and contents
        // to the console in Debug
        Log.d("omg android", position + ": " + mNameList.get(position));
    }
}
