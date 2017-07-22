package com.example.xxnrq.philvolcslivelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainMenu extends Activity {

    TextView dispJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        dispJSON = findViewById(R.id.dispJSON);
    }

    public void gotoLiveData(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void gotoMaps(View view) {
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void createJson(View view) throws JSONException {
        try {
            JSONWriter jsonw = new JSONWriter();
            dispJSON.setText(jsonw.getData(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
