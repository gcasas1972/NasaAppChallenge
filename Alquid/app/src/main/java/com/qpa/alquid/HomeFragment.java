package com.qpa.alquid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


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


        //Algas
        LatLng varese = new LatLng(-38.0143778,-57.5303842);
        map.addMarker(new MarkerOptions().position(varese).title("Playa Varese").snippet("Presencia de algas").icon(BitmapDescriptorFactory.fromResource(R.drawable.alga)));
        LatLng madryn = new LatLng(-42.77276898064731,-65.02568900310722);
        map.addMarker(new MarkerOptions().position(madryn).title("Puerto Madryn").snippet("Presencia de algas").icon(BitmapDescriptorFactory.fromResource(R.drawable.alga)));
        LatLng Gesell = new LatLng(-37.257048403173016,-56.9636822843061);
        map.addMarker(new MarkerOptions().position(Gesell).title("Villa Gesell").snippet("Presencia de Algas").icon(BitmapDescriptorFactory.fromResource(R.drawable.alga)));
        LatLng quilmes = new LatLng(-34.718437,-58.212129);
        map.addMarker(new MarkerOptions().position(quilmes).title("Quilmes").snippet("Presencia de Algas").icon(BitmapDescriptorFactory.fromResource(R.drawable.alga)));




        //Medusas
        LatLng santaclara = new LatLng(-37.8370360585572,-57.496207634599244);
        map.addMarker(new MarkerOptions().position(santaclara).title("Santa Clara del Mar").snippet("Presencia de Medusas").icon(BitmapDescriptorFactory.fromResource(R.drawable.medusa)));


        //Pesca
        LatLng GolfoSJ = new LatLng(-46,-67);
        map.addMarker(new MarkerOptions().position(GolfoSJ).title("Golfo San Jorge").snippet("Buena Actividad Pesquera").icon(BitmapDescriptorFactory.fromResource(R.drawable.pesca)));
        LatLng BahiaBlanca = new LatLng(-38.81243509046627,-62.22479452345115);
        map.addMarker(new MarkerOptions().position(BahiaBlanca).title("Bahia Blanca").snippet("Buena Actividad Pesquera").icon(BitmapDescriptorFactory.fromResource(R.drawable.pesca)));
        LatLng ushuaia = new LatLng(-54.861120,-68.188360);
        map.addMarker(new MarkerOptions().position(ushuaia).title("Canal de Beagle").snippet("Buena Actividad Pesquera").icon(BitmapDescriptorFactory.fromResource(R.drawable.pesca)));



        //Playita
        LatLng SanBer = new LatLng(-36.6908679162591,-56.67550733100174);
        map.addMarker(new MarkerOptions().position(SanBer).title("San Bernardo").snippet("Precaucion en el Baño").icon(BitmapDescriptorFactory.fromResource(R.drawable.amarillo)));
        LatLng Pinamar = new LatLng(-37.11276260366418,-56.850013440952225);
        map.addMarker(new MarkerOptions().position(Pinamar).title("Pinamar").snippet("Baño Permitido con Buenas Condiciones").icon(BitmapDescriptorFactory.fromResource(R.drawable.verde)));




        //Setup
        setUpMap();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(varese, 15));
    }

    private void setUpMap() {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);
    }


}
