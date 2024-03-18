package com.example.i_hospital.admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_hospital.Bill.BillEntryeExpenseAdd;
import com.example.i_hospital.doctor.DoctorActivity;
import com.example.i_hospital.masteradmin.HealthCareAdapter;
import com.example.i_hospital.masteradmin.HomeItemAdapter;
import com.example.i_hospital.models.Admin;
import com.example.i_hospital.models.Item;
import com.example.i_hospital.models.MasterAdmin;
import com.example.i_hospital.patients.PatientsActivity;
import com.example.i_hospital.R;
import com.example.i_hospital.shiftSgedule.ShiftSheduleActivity;
import com.example.i_hospital.models.Staff;
import com.example.i_hospital.staff.StaffActivity;
import com.example.i_hospital.expense.ViewHealthCareTeam;

import java.util.ArrayList;
import java.util.List;

public class AdminHomeFragment extends Fragment {
    private RecyclerView recyclerView;

    private HomeItemAdapter adapter;
    private List<Item> itemList;

    List<Object> healthcareitems ;
    private HealthCareAdapter healthCareAdapter;
    private RecyclerView HealthCareRecyclerView;

    public AdminHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize item list
        itemList = new ArrayList<>();
        itemList.add(new Item("Total Staff", "0000", "12 Mar 2012"));
        itemList.add(new Item("Today's Appointments", "0000", "12 Mar 2012"));
        itemList.add(new Item("Total Patients", "0000", "12 Mar 2012"));
        itemList.add(new Item("Total Appointments", "0000", "12 Mar 2012"));


        adapter = new HomeItemAdapter(getContext(), itemList);
        recyclerView.setAdapter(adapter);


           // 2nd recycler view
        HealthCareRecyclerView = view.findViewById(R.id.HealthCareRecyclerView);
        HealthCareRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Sample data of different professions
        healthcareitems = new ArrayList<>();
        healthcareitems.add(new MasterAdmin("Dr. John Doe", "Master Admin", R.drawable.dummydoctor));
        healthcareitems.add(new Staff("Sushma Tirkude", "Staff", R.drawable.dummydoctor));
        healthcareitems.add(new Admin("Dr. Nirmal Shinde", "Admin", R.drawable.dummydoctor));

        healthCareAdapter = new HealthCareAdapter(healthcareitems);
        HealthCareRecyclerView.setAdapter(healthCareAdapter);

        ImageView AddStaffs = view.findViewById(R.id.AddStaffs);
        AddStaffs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StaffActivity.class);
                startActivity(intent);
            }
        });

        ImageView AddDoctors = view.findViewById(R.id.AddDoctors);
        AddDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoctorActivity.class);
                startActivity(intent);
            }
        });

        ImageView AddBillExpense = view.findViewById(R.id.AddBillExpense);
        AddBillExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BillEntryeExpenseAdd.class);
                startActivity(intent);
            }
        });
        ImageView SortListAdmin = view.findViewById(R.id.SortListAdmin);
        SortListAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdminLagout.class);
                startActivity(intent);
            }
        });

        ImageView PatientsAdmin = view.findViewById(R.id.PatientsAdmin);
        PatientsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PatientsActivity.class);
                startActivity(intent);
            }
        });
        ImageView ShiftSheduleadd = view.findViewById(R.id.ShiftSheduleadd);
        ShiftSheduleadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShiftSheduleActivity.class);
                startActivity(intent);
            }
        });
        TextView ViewAllDetail = view.findViewById(R.id.ViewAllDetail);
        ViewAllDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewHealthCareTeam.class);
                // Convert List<Object> to List<MasterAdmin>
                List<MasterAdmin> masterAdminList = new ArrayList<>();
                for (Object obj : healthcareitems) {
                    if (obj instanceof MasterAdmin) {
                        masterAdminList.add((MasterAdmin) obj);
                    }
                }
                intent.putParcelableArrayListExtra("healthcare_items", new ArrayList<>(masterAdminList));
                startActivity(intent);
            }
        });
        return view;
    }
}