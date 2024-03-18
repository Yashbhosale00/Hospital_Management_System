package com.example.i_hospital.staff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.i_hospital.R;
import com.example.i_hospital.admin.AdminHomeActivity;


public class StaffActivity extends AppCompatActivity {
    LinearLayout layout1, layout2, layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView StaffBackimageView = findViewById(R.id.StaffBackimageView);
        StaffBackimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StaffActivity.this, AdminHomeActivity.class);
                startActivity(intent);
            }
        });
        // Initialize layouts
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
    }
    // Method to navigate to the next page (similar to toggleLayouts)
    // Method to navigate to the next page
    public void nextPage(View view) {
        // Find the currently visible layout
        LinearLayout currentLayout = layout1;
        if (layout2.getVisibility() == View.VISIBLE) {
            currentLayout = layout2;
        } else if (layout3.getVisibility() == View.VISIBLE) {
            currentLayout = layout3;
        }

        // Determine the next layout
        LinearLayout nextLayout = null;
        if (currentLayout == layout1) {
            nextLayout = layout2;
        } else if (currentLayout == layout2) {
            nextLayout = layout3;
        }

        // Show the next layout and hide the current one
        if (nextLayout != null) {
            currentLayout.setVisibility(View.GONE);
            nextLayout.setVisibility(View.VISIBLE);
        } else {
            // Show a toast message when attempting to navigate forward from the last layout
            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
        }
    }


    // Method to navigate to the previous page
    // Method to navigate to the previous page
    public void previousPage(View view) {
        // Find the currently visible layout
        LinearLayout currentLayout = layout1;
        if (layout2.getVisibility() == View.VISIBLE) {
            currentLayout = layout2;
        } else if (layout3.getVisibility() == View.VISIBLE) {
            currentLayout = layout3;
        }

        // Determine the previous layout
        LinearLayout previousLayout = null;
        if (currentLayout == layout2) {
            previousLayout = layout1;
        } else if (currentLayout == layout3) {
            previousLayout = layout2;
        }

        // Show the previous layout and hide the current one
        if (previousLayout != null) {
            currentLayout.setVisibility(View.GONE);
            previousLayout.setVisibility(View.VISIBLE);
        } else {
            // Show a toast message when attempting to navigate back from the first layout
            Toast.makeText(this, "You are already on the first page", Toast.LENGTH_SHORT).show();
        }
    }

}