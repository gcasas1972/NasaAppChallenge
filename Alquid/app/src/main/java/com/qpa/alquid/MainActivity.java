package com.qpa.alquid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    PermissionManager permissionManager;
    TextView txtDenied,txtGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGranted=(TextView)findViewById(R.id.txtGranted);
        txtDenied=(TextView)findViewById(R.id.txtDenied);
        permissionManager = new PermissionManager() {
        };
        permissionManager.checkAndRequestPermissions(this);


        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        androidx.navigation.ui.AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_camera, R.id.navigation_weather, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

      // if (savedInstanceState == null) {
      //     getSupportFragmentManager().beginTransaction()
      //             .replace(R.id.container, new CameraFragment())
      //             .commit();
      // }




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);

        ArrayList<String> granted = permissionManager.getStatus().get(0).granted;
        ArrayList<String> denied = permissionManager.getStatus().get(0).denied;

        for (String item:granted)
            txtGranted.setText(txtGranted.getText()+"\n"+item);
        for (String item:denied)
            txtDenied.setText(txtDenied.getText()+"\n"+item);
    }


    @Override
    public void onClick(View v) {

    }
}