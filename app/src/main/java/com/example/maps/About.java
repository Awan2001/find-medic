package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the home button (back button)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set a click listener for the home button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the back button click
                onBackPressed();
            }
        });

        TextView urlGithub = findViewById(R.id.linkGithub);
        urlGithub.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void openUrl(View view) {
        String url = ((TextView) view).getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the home button click (back button)
            onBackPressed();
            return true;
        }
        if (item.getItemId() == R.id.item_share) {
            // Share functionality
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hi, this is Find Medic, Try our new application - https://github.com/Awan2001/find-medic");
            startActivity(Intent.createChooser(shareIntent, null));
            return true;
        } else if (item.getItemId() == R.id.item_about) {
            // About functionality
            Intent aboutIntent = new Intent(this, About.class);
            startActivity(aboutIntent);
            return true;
        } else if (item.getItemId() == R.id.item_logout) {
            // Logout functionality
            startActivity(new Intent(this, MainActivity.class));
            finish(); // optional, depending on your requirements
            return true;
        }
        return false;
    }
}