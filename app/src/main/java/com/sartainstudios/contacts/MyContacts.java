package com.sartainstudios.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;


public class MyContacts extends AppCompatActivity {

    // starts and shows activity_my_contacts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts);
    }

    // Default onCreateOptionsMenu
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_contacts, menu);
        return true;
    }
    */


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_contacts, menu);
        // Action View
        //MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.action_add_contact:
                startActivity(new Intent(this, AddContact.class));
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
