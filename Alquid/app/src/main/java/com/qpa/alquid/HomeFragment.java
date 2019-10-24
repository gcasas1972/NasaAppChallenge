package com.qpa.alquid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        assert getFragmentManager() != null;
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return root;

        // checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, 100);
    }

    // public void checkPermission(String permission, int requestCode) {
    //     if (ContextCompat.checkSelfPermission(HomeFragment.this, permission) == PackageManager.PERMISSION_DENIED) {
    //         ActivityCompat.requestPermissions(HomeFragment.this, new String[] { permission }, requestCode);
    //     }
    // }

    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        setUpMap();
    }

    private void setUpMap() {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);
    }


}
