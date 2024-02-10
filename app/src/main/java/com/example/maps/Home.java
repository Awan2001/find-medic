package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Home extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email;
    Button mapButton, userCheckInButton, aboutButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mapButton = findViewById(R.id.mapButton);
        userCheckInButton = findViewById(R.id.userCheckInButton);
        aboutButton = findViewById(R.id.aboutButton);
        logoutButton = findViewById(R.id.logoutButton);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();

            name.setText(personName);
            email.setText(personEmail);
        }

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Map activity
                startActivity(new Intent(Home.this, MapsActivity.class));
            }
        });

        userCheckInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Map activity
                startActivity(new Intent(Home.this, UserCheckIn.class));
            }
        });

        /*userCheckInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the User Check-In activity
                startActivity(new Intent(Home.this, UserCheckInActivity.class)); Notes to palan : tukar nama UserCheckInActivity tu ke nama file checkin yg betul
            }
        });*/

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the About activity
                startActivity(new Intent(Home.this, About.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform logout and redirect to the Login activity
                gsc.signOut();
                startActivity(new Intent(Home.this, MainActivity.class));
                finish(); // Close the current activity
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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