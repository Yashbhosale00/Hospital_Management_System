package com.example.i_hospital.shiftSgedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.i_hospital.R;
import com.example.i_hospital.admin.AdminHomeActivity;

public class ShiftSheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shift_shedule);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button ShiftSheduleSubmit =findViewById(R.id.ShiftSheduleSubmit);
        ShiftSheduleSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShiftSheduleActivity.this, "Submit", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView ShiftsheduleimageView = findViewById(R.id.ShiftsheduleimageView);
        ShiftsheduleimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShiftSheduleActivity.this, AdminHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}