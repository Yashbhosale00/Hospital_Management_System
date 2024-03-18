package com.example.i_hospital.masteradmin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_hospital.Bill.BillEntryeExpenseAdd;
import com.example.i_hospital.R;
import com.example.i_hospital.models.LogsModal;
import com.example.i_hospital.models.Staff;
//import com.example.i_hospital.retrofitinstance.RetrofitInstance;
import com.example.i_hospital.staff.StaffActivity;
import com.example.i_hospital.expense.ViewHealthCareTeam;
import com.example.i_hospital.models.Admin;
import com.example.i_hospital.doctor.DoctorActivity;
import com.example.i_hospital.models.Item;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeItemAdapter adapter;
    private List<Item> itemList;
    private List<LogsModal>LogsList;

    List<Object> healthcareitems ;
    private HealthCareAdapter healthCareAdapter;
    private RecyclerView HealthCareRecyclerView;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

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
        healthcareitems.add(new Staff("Sushma Tirkude", "Staff", R.drawable.dummydoctor));
        healthcareitems.add(new Admin("Dr. Nirmal Shinde", "Admin", R.drawable.dummydoctor));

        healthCareAdapter = new HealthCareAdapter(healthcareitems);
        HealthCareRecyclerView.setAdapter(healthCareAdapter);


        ImageView addMasterAdminImageView = view.findViewById(R.id.AddMasterAdmin);
        addMasterAdminImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MasterAdmin_BottomSheet.class);
                startActivity(intent);
            }
        });

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
        ImageView SortList = view.findViewById(R.id.SortList);
        SortList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MasterLoginActivity.class);
                startActivity(intent);
            }
        });

        TextView ViewAllDetail = view.findViewById(R.id.ViewAllDetail);
        ViewAllDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewHealthCareTeam.class);
//                intent.putParcelableArrayListExtra("healthcare_items", new ArrayList<>(healthcareitems));
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

        return view;
    }



//    void getLog(Context context){
//        RetrofitInterface retrofitInterface = RetrofitInstance.getSeviceData();
//    }
//
//
//
//
//    void getDailyLogsTiming(Context context) {
//
//
//        RetrofitInterface retrofitInterface = RetrofitInstance.getSeviceData();
//        retrofitInterface.GetLogTiming("Employee", EmpId).enqueue(new Callback<List<DailyLogTimingModel>>() {
//            @Override
//            public void onResponse(Call<List<DailyLogTimingModel>> call, Response<List<DailyLogTimingModel>> response) {
//
//                if (response.isSuccessful()) {
//                    List<DailyLogTimingModel> list = response.body();
//                    Log.d("Response", "" + response);
//                    if (list != null && list.size() > 0) {
//                        for (int i = 0; i < list.size(); i++) {
//                            DailyLogTimingModel timingModel = list.get(i);
//                            parseTime2(timingModel.getEnd_Time());
//
//
//                            /* Date endTime = */
//                            //StartAlarm(endTime);
//
//                            /*SimpleDateFormat originalFormat = new SimpleDateFormat("hh:mma", Locale.getDefault());
//                            Date date;
//                            try {
//                                date = originalFormat.parse(timingModel.getEnd_Time());
//                                SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
//                                String convertedTime = newFormat.format(date);
//                                Log.d("MainActivity", "Converted Time: " + convertedTime);
//                            } catch (ParseException e) {
//                                e.printStackTrace();
//                            }*/
//
//
//
//                        }
//                    }
//
//                    Log.d("ForegroundService", "getDailyLogsTiming: Web service call successful, list size: " + list.size());
//
//                } else {
//                    Log.d("Response unsuccessful", "Response unsuccessful");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<DailyLogTimingModel>> call, Throwable t) {
//                Log.e("API Call Failure", "API call failed", t);
//            }
//        });
//    }
}
