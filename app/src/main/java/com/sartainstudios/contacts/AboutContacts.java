package com.sartainstudios.contacts;

import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class AboutContacts extends AppCompatActivity {

    // Starts and shows activity_my_contacts.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_contacts);
        // Adds carrot to to left of icon on action bar to return to home
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Adds action bar icons or text to the action bar if present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_contacts, menu);
        return true;
    }

    // Determines if Action bar item was selected. If true then do corresponding action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
