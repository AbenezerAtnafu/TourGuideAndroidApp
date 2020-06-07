package com.example.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter {

    public LocationAdapter(Activity activity, ArrayList<Location> locations) {
        super(activity, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View locationItemView = convertView;

        if (locationItemView == null) {
            locationItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.location_item, parent, false);
        }
        Location currentLocation = (Location) getItem(position);
        TextView locationName = locationItemView.findViewById(R.id.location_name);
        TextView locationAddress = locationItemView.findViewById(R.id.location_address);
        RatingBar locationRatingBar = locationItemView.findViewById(R.id.description_rating_bar);
        TextView locationRatingView = locationItemView.findViewById(R.id.rating_text_view);

        locationName.setText(currentLocation.getName());
        locationAddress.setText(currentLocation.getAddress());
        locationRatingBar.setRating(currentLocation.getRating());
        locationRatingView.setText(currentLocation.getRating() + "");
        if (currentLocation.hasImage()) {
            ImageView locationImageView = locationItemView.findViewById(R.id.location_image);
            locationImageView.setImageResource(currentLocation.getImageResourceId());
            locationImageView.setVisibility(View.VISIBLE);
        } else {
            ImageView locationImageView = locationItemView.findViewById(R.id.location_image);
            locationImageView.setImageResource(R.drawable.ic_launcher_background);
            locationImageView.setVisibility(View.VISIBLE);
        }

        return locationItemView;
    }
}
