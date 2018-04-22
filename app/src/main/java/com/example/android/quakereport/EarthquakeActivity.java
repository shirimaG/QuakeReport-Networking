/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        final ArrayList<Info> info = QueryUtils.extractEarthquakes();
//        info.add(new Info("7.2","San Francisco","Feb 2, 2016"));
//        info.add(new Info("6.1","London","July 20, 2015"));
//        info.add(new Info("3.9","Tokyo","Nov 10, 2014"));
//        info.add(new Info("5.4","Mexico city","May 3, 2014"));
//        info.add(new Info("2.8","Moscow","Jan 12, 2013"));
//        info.add(new Info("4.9","Rio De Jeneiro","Aug 21, 2016"));
//        info.add(new Info("1.6","Paris","Sept 13, 2015"));

        //Using Custom WordAdapter to hold data into the ListView
        final InfoAdapter adapter = new InfoAdapter(this,info);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        earthquakeListView.setAdapter(adapter);

        //set onItemClick Listener
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Find the current earthquake that was clicked on
                Info currentEarthquake = (Info) adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                // Create a new intent to view the earthquake URI
                //Remember ths is an Implicit intent
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }
}
