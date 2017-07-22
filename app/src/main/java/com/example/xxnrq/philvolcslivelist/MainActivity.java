package com.example.xxnrq.philvolcslivelist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView onlineData;
    ListView itemListView;
    ArrayList<ArrayList<String>> liveDataResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onlineData = findViewById(R.id.onlineData);
        itemListView = findViewById(R.id.itemListView);
        itemListView.setAdapter(new ListAdapter(this, R.layout.list_live_results, liveDataResults));

        try {
            Toast.makeText(this, "Pasok", Toast.LENGTH_SHORT).show();
            EarthquakeLiveFeed equakeFeed = new EarthquakeLiveFeed(onlineData, MainActivity.this, itemListView);
            equakeFeed.execute();
        } catch (Exception e) {
            Toast.makeText(this, "Hindi pasok", Toast.LENGTH_SHORT).show();
            onlineData.setText(e.toString());
        }
    }
}


