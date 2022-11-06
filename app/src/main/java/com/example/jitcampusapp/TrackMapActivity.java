package com.example.jitcampusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TrackMapActivity extends AppCompatActivity {

    EditText src,dest;
    Button loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_map);

        src = findViewById(R.id.source);
        dest = findViewById(R.id.destination);
        loc = findViewById(R.id.showLocation);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sSource = src.getText().toString().trim();
                String sDestination = dest.getText().toString().trim();

                if(sSource.equals("")&&sDestination.equals("")){
                    Toast.makeText(TrackMapActivity.this, "ENTER BOTH FIELDS", Toast.LENGTH_SHORT).show();
                }else{
                    DisplayTracker(sSource,sDestination);
                }

            }
        });
    }

    private void DisplayTracker(String sSource, String sDestination) {
        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }catch (ActivityNotFoundException e){

            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

        }

    }
}