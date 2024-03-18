package com.example.i_hospital.Bill;

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

import com.example.i_hospital.admin.AdminHomeActivity;
import com.example.i_hospital.masteradmin.MasterAdminDashBoard;
import com.example.i_hospital.R;

public class BillEntryeExpenseAdd extends AppCompatActivity {
    LinearLayout layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bill_entrye_expense_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView BillentryBackimageView = findViewById(R.id.BillentryBackimageView);
        BillentryBackimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillEntryeExpenseAdd.this, AdminHomeActivity.class);
                startActivity(intent);
            }
        });
        // Initialize layouts
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
    }
    public void nextPage(View view) {
        // Find the currently visible layout
        LinearLayout currentLayout = layout1;
        if (layout2.getVisibility() == View.VISIBLE) {
            currentLayout = layout2;
        }


        // Determine the next layout
        LinearLayout nextLayout = null;
        if (currentLayout == layout1) {
            nextLayout = layout2;
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
        }

        // Determine the previous layout
        LinearLayout previousLayout = null;
        if (currentLayout == layout2) {
            previousLayout = layout1;
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