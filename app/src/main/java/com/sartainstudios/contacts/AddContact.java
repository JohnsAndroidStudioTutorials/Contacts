package com.sartainstudios.contacts;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.action_search:
                startActivity(new Intent(this, SearchContacts.class));
                return true;

            case R.id.action_my_contacts:
                startActivity(new Intent(this, MyContacts.class));
                return true;

            case R.id.action_about:
                startActivity(new Intent(this, AboutContacts.class));
                return true;

            case R.id.action_settings:
                startActivity(new Intent(this, ContactsSettings.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}