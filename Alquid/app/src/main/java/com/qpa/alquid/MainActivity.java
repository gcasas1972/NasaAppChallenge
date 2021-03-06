package com.qpa.alquid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.graphics.Color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
        //Fullscreen
     // requestWindowFeature(Window.FEATURE_NO_TITLE);
     // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

      // if (savedInstanceState == null) {
      //     getSupportFragmentManager().beginTransaction()
      //             .replace(R.id.container, new CameraFragment())
      //             .commit();
      // }
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, true);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

   // <item name="windowNoTitle">true</item>
   //     <item name="windowActionBar">false</item>
   //     <item name="android:windowTranslucentStatus">false</item>
   //     <item name="android:windowTranslucentNavigation">false</item>
//
   //     <item name="android:windowDrawsSystemBarBackgrounds">true</item>
   //     <item name="android:statusBarColor">@android:color/transparent</item>

    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
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