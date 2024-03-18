package com.example.i_hospital.masteradmin;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.i_hospital.notification.NotificationFragment;
import com.example.i_hospital.R;
import com.example.i_hospital.addmore.SettingsFragment;
import com.example.i_hospital.expense.UsersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;



public class MasterAdminDashBoard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    UsersFragment usersFragment = new UsersFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    NotificationFragment notificationFragment = new NotificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_master_admin_dash_board);

        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.expenses) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation, usersFragment).commit();
                    return true;
                } else if (itemId == R.id.moreview) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation, settingsFragment).commit();
                    return true;
                } else if (itemId ==R.id.Notification) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation,notificationFragment).commit();
                }
                return false;
            }
        });

    }
}
