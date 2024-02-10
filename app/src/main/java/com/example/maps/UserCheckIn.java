package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;
import java.util.Map;

public class UserCheckIn extends AppCompatActivity {
    EditText etComments;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    String latAsString,lngAsString,user_name, user_email;

    RequestQueue queue;
    final String URL = "https://remote-api-arep.000webhostapp.com/api.php";

    String[] perms = {"android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.INTERNET",
            "android.permission.ACCESS_NETWORK_STATE"};
    private FusedLocationProviderClient fusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

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

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            user_name = acct.getDisplayName();
            user_email = acct.getEmail();
        }


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, perms, 200);

            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    double lng = location.getLongitude();
                    double lat = location.getLatitude();

                    latAsString = String.valueOf(lat);
                    lngAsString = String.valueOf(lng);

                    // Now you can use latAsString and lngAsString in your request
                } else {
                    // Handle the case where location is null
                    Toast.makeText(UserCheckIn.this, "Unable to retrieve location", Toast.LENGTH_SHORT).show();
                }
            }
        });


        queue = Volley.newRequestQueue(getApplicationContext());
        etComments = (EditText) findViewById(R.id.etComments);

        Button button = (Button) findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volley call
                makeRequest();
            }
        });
    }
    public void makeRequest(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response, Toast.LENGTH_LONG).show();

            }
        }, errorListener){
            @Override
            protected Map<String,String> getParams(){
                Map <String, String> params = new HashMap<>();
                params.put("name",user_name);
                params.put("email",user_email);
                params.put("comments",etComments.getText().toString());
                params.put("lat", latAsString);
                params.put("lng", lngAsString);
                return params;
            }
        };
        queue.add(stringRequest);
    }
    public Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
        }
    };

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