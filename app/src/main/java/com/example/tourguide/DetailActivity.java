package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView addressView;
    private TextView descriptionView;
    private TextView phoneNumberView;
    private ImageView imageView;
    private RatingBar ratingBar;

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decription);

        mIntent = getIntent();
        getSupportActionBar().setTitle(mIntent.getStringExtra("name"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nameView = findViewById(R.id.description_location_name);
        addressView = findViewById(R.id.description_location_address);
        descriptionView = findViewById(R.id.description_location_description);
        phoneNumberView = findViewById(R.id.description_location_phone);
        imageView = findViewById(R.id.description_image_view);
        ratingBar = findViewById(R.id.description_rating_bar);

        nameView.setText(mIntent.getStringExtra("name"));
        addressView.setText(mIntent.getStringExtra("address"));
        descriptionView.setText(mIntent.getStringExtra("description"));
        phoneNumberView.setText(mIntent.getStringExtra("phone_number"));
        ratingBar.setRating(mIntent.getFloatExtra("rating", (float) 5.0));
        imageView.setImageResource(mIntent.getIntExtra("image", R.drawable.ic_launcher_background));

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
