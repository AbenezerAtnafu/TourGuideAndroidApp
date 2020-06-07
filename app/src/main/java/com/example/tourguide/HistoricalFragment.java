package com.example.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalFragment extends Fragment {

    public HistoricalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View locationRootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location(0, getString(R.string.abay_name),
                getString(R.string.abay_address),
                getString(R.string.abay_description),
                4.5, "-", R.drawable.abay));
        locations.add(new Location(1, getString(R.string.gondar_name),
                getString(R.string.gondadr_address),
                getString(R.string.gondar_description),
                5, "-", R.drawable.gondar));
        locations.add(new Location(2, getString(R.string.axum_name),
                getString(R.string.axum_address),
                getString(R.string.abay_description),
                4.5, "-", R.drawable.axum));
        locations.add(new Location(3, getString(R.string.lalibela_name),
                getString(R.string.lalibela_address),
                getString(R.string.lalibela_description),
                4, "-", R.drawable.lalibela));
        locations.add(new Location(4, getString(R.string.tiya_name),
                getString(R.string.tiya_address),
                getString(R.string.tiya_description),
                4.5, "-", R.drawable.tiya));

        ListView listView = (ListView) locationRootView.findViewById(R.id.location_list);

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locations);
        listView.setAdapter(locationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Location selectedLocation = (Location) parent.getItemAtPosition(position);
                Intent locationIntent = new Intent(getActivity(), DetailActivity.class);
                locationIntent.putExtra("name", selectedLocation.getName());
                locationIntent.putExtra("address", selectedLocation.getAddress());
                locationIntent.putExtra("phone_number", selectedLocation.getPhoneNumber());
                locationIntent.putExtra("description", selectedLocation.getDescription());
                locationIntent.putExtra("rating", selectedLocation.getRating());
                locationIntent.putExtra("image", selectedLocation.getName());
                if (selectedLocation.hasImage()) {
                    locationIntent.putExtra("image", selectedLocation.getImageResourceId());
                } else {
                    locationIntent.putExtra("image", R.drawable.ic_launcher_background);
                }

                startActivity(locationIntent);
            }
        });
        return locationRootView;
    }
}
