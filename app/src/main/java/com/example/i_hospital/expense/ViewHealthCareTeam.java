package com.example.i_hospital.expense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_hospital.R;
import com.example.i_hospital.masteradmin.HealthCareAdapter;
import com.example.i_hospital.masteradmin.MasterAdminDashBoard;
import com.example.i_hospital.models.MasterAdmin;

import java.util.ArrayList;
import java.util.List;

public class ViewHealthCareTeam extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HealthCareAdapter adapter;
    private List<Object> healthCareList;
    private static final int VIEW_TYPE_MASTER_ADMIN = 1;
    private static final int VIEW_TYPE_STAFF = 2;
    private static final int VIEW_TYPE_ADMIN = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_health_care_team);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.healthCareRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Retrieve data from intent
        ArrayList<MasterAdmin> masterAdminList = getIntent().getParcelableArrayListExtra("healthcare_items");


        // Initialize list if not null
        if (masterAdminList != null) {
            healthCareList = new ArrayList<>(masterAdminList);
        } else {
            healthCareList = new ArrayList<>();
        }

        // Set up adapter
        adapter = new HealthCareAdapter(healthCareList);
        recyclerView.setAdapter(adapter);

        ImageView FilterImageViewAll = findViewById(R.id.FilterImageViewAll);
        FilterImageViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewHealthCareTeam.this, "Apply Filter", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView ViewAllBackArrow = findViewById(R.id.ViewAllBackArrow);
        ViewAllBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHealthCareTeam.this, MasterAdminDashBoard.class);
                startActivity(intent);
            }
        });
    }
}
