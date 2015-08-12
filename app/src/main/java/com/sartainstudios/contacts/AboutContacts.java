package com.sartainstudios.contacts;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


public class AboutContacts extends AppCompatActivity {



    // Starts and shows activity_my_contacts.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_contacts);

        final int versionCode = BuildConfig.VERSION_CODE;
        final String versionName = BuildConfig.VERSION_NAME;
        final   String ok = getString(R.string.ok);
        final  String thisIsVersionNumber = getString(R.string.this_is_version_number);
        final    String thisIsBuildNumber = getString(R.string.this_is_build_number);
        final   String hereIsWhatsNewInThisVersion = getString(R.string.here_is_whats_new_in_this_version);
        final    String newInThisVersion = getString(R.string.new_in_this_version);

        setVersionNameText();

        TextView versionNameDisplay;
        versionNameDisplay = (TextView) findViewById(R.id.display_version_name);
        versionNameDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display in short period of time
                Toast.makeText(getApplicationContext(), thisIsVersionNumber + " " + versionCode + " ", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), thisIsBuildNumber + " " + versionName + " ", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(AboutContacts.this);
                builder.setTitle(hereIsWhatsNewInThisVersion)
                        .setMessage(newInThisVersion)
                        .setNeutralButton(ok, null); // try to link to version number

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void setVersionNameText() {
        final String version = getString(R.string.version);
        String versionName = BuildConfig.VERSION_NAME;
        TextView displayVersionName = (TextView) findViewById(R.id.display_version_name);

        // sets textView to display version name
        displayVersionName.setText(version + " " + versionName);
    }
    // Default onCreateOptionsMenu
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R..menu.menu_about_contacts., menu);
        return true;
    }
    */

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_contacts, menu);
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

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.action_add_contact:
                startActivity(new Intent(this, AddContact.class));
                return true;

            case R.id.action_my_contacts:
                startActivity(new Intent(this, MyContacts.class));
                return true;

            case R.id.action_settings:
                startActivity(new Intent(this, ContactsSettings.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}