package com.example.i_hospital.expense;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.i_hospital.R;
import com.example.i_hospital.models.Expense;

import java.util.ArrayList;
import java.util.List;


public class UsersFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExpenseAdapter expenseAdapter;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_users, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        // Create and set adapter with hardcoded data
        expenseAdapter = new ExpenseAdapter(getExpenseList());
        recyclerView.setAdapter(expenseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private List<Expense> getExpenseList() {
        // Create and return hardcoded data list
        List<Expense> expenseList = new ArrayList<>();
        // Add your hardcoded Expense objects here

        Expense expense1 = new Expense();
        expense1.setBillNo("1");
        expense1.setBillDate("01-03-2024");
        expense1.setCategory("Category 1");
        expense1.setMedicine("Medicine 1");
        expense1.setSupplierName("Supplier 1");
        expense1.setStatus("UnPaid");
        expense1.setAmount("2000.00");
        expense1.setPaid("2000.00");
        expense1.setBalance("0.00");
        expenseList.add(expense1);

        Expense expense2 = new Expense();
        expense2.setBillNo("2");
        expense2.setBillDate("02-03-2024");
        expense2.setCategory("Category 2");
        expense2.setMedicine("Medicine 2");
        expense2.setSupplierName("Supplier 2");
        expense2.setStatus("Paid");
        expense2.setAmount("2500.00");
        expense2.setPaid("2500.00");
        expense2.setBalance("0.00");
        expenseList.add(expense2);

        return expenseList;
    }

}



