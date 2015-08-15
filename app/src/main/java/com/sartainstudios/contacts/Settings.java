package com.sartainstudios.contacts;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Locale;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        final int versionCode = BuildConfig.VERSION_CODE;
        final String versionName = BuildConfig.VERSION_NAME;
        final String ok = getString(R.string.ok);
        final String thisIsVersionNumber = getString(R.string.this_is_version_number);
        final String thisIsBuildNumber = getString(R.string.this_is_build_number);
        final String hereIsWhatsNewInThisVersion = getString(R.string.here_is_whats_new_in_this_version);
        final String newInThisVersion = getString(R.string.new_in_this_version);

        setVersionNameText();

        TextView versionNameDisplay;
        versionNameDisplay = (TextView) findViewById(R.id.display_version_name);
        versionNameDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display in short period of time
                Toast.makeText(getApplicationContext(), thisIsVersionNumber + " " + versionCode + " ", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), thisIsBuildNumber + " " + versionName + " ", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
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
}

/*
        final ListPreference listPreference = (ListPreference) findPreference("language");

        listPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                setListPreferenceData(listPreference);
                return false;
            }
        });
    }

    protected static void setListPreferenceData(ListPreference lp) {
        CharSequence[] entries = {"English", "French"};
        CharSequence[] entryValues = {"1", "2"};
        lp.setEntries(entries);
        lp.setDefaultValue("1");
        lp.setEntryValues(entryValues);
    }
}*/
//PreferenceManager.setDefaultValues(this, R.xml.preferences, false);


//SharedPreferences getData = Settings.
//Boolean;
        /*
        switch (language()) {
            case R.id.en:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in English !", Toast.LENGTH_LONG).show();
                break;

            case R.id.pt:
                Locale locale2 = new Locale("pt");
                Locale.setDefault(locale2);
                Configuration config2 = new Configuration();
                config2.locale = locale2;
                getBaseContext().getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(this, "Locale in Portugal !", Toast.LENGTH_LONG).show();
                break;

            case R.id.es:
                Locale locale3 = new Locale("es");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(this, "Locale in Spain !", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, AndroidLocalize.class);
        startActivity(refresh);
    }
    */