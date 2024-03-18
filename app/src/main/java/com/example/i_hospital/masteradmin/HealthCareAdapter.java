package com.example.i_hospital.masteradmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_hospital.R;
import com.example.i_hospital.models.Staff;
import com.example.i_hospital.models.Admin;
import com.example.i_hospital.models.MasterAdmin;

import java.util.List;

public class HealthCareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_MASTER_ADMIN = 1;
    private static final int VIEW_TYPE_STAFF = 2;
    private static final int VIEW_TYPE_ADMIN = 3;

    private List<Object> healthcareitems;

    public HealthCareAdapter(List<Object> healthcareitems) {
        this.healthcareitems = healthcareitems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_MASTER_ADMIN:
                view = inflater.inflate(R.layout.view_healthcare_sample_layout, parent, false);
                viewHolder = new MasterAdminViewHolder(view);
                break;
            case VIEW_TYPE_STAFF:
                view = inflater.inflate(R.layout.staffsample, parent, false);
                viewHolder = new StaffViewHolder(view);
                break;
            case VIEW_TYPE_ADMIN:
                view = inflater.inflate(R.layout.adminsample, parent, false);
                viewHolder = new AdminViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object item = healthcareitems.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MASTER_ADMIN:
                MasterAdmin masterAdmin = (MasterAdmin) item;
                ((MasterAdminViewHolder) holder).bind(masterAdmin);
                break;
            case VIEW_TYPE_STAFF:
                Staff staff = (Staff) item;
                ((StaffViewHolder) holder).bind(staff);
                break;
            case VIEW_TYPE_ADMIN:
                Admin admin = (Admin) item;
                ((AdminViewHolder) holder).bind(admin);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return healthcareitems.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = healthcareitems.get(position);
        if (item instanceof MasterAdmin) {
            return VIEW_TYPE_MASTER_ADMIN;
        } else if (item instanceof Staff) {
            return VIEW_TYPE_STAFF;
        } else if (item instanceof Admin) {
            return VIEW_TYPE_ADMIN;
        }
        return super.getItemViewType(position);
    }

    private static class MasterAdminViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;
        private TextView nameTextView;
        private TextView professionTextView;
        public MasterAdminViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.dummyDoctorone);
            nameTextView = itemView.findViewById(R.id.MasterDoctorNameone);
            professionTextView = itemView.findViewById(R.id.DoctorProfesiondoctorOne);
        }

        public void bind(MasterAdmin masterAdmin) {
            profileImageView.setImageResource(masterAdmin.getProfileImage());
            nameTextView.setText(masterAdmin.getName());
            professionTextView.setText(masterAdmin.getProfession());
        }
    }

    private static class StaffViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;
        private TextView nameTextView;
        private TextView professionTextView;
        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.dummyDoctorTwo);
            nameTextView = itemView.findViewById(R.id.RegisterdStafffName);
            professionTextView = itemView.findViewById(R.id.StaffProfessiondoctorOne);
        }

        public void bind(Staff staff) {
            profileImageView.setImageResource(staff.getProfileImage());
            nameTextView.setText(staff.getName());
            professionTextView.setText(staff.getProfession());
        }
    }

    private static class AdminViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;
        private TextView nameTextView;
        private TextView professionTextView;
        public AdminViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.dummyDoctorThree);
            nameTextView = itemView.findViewById(R.id.RegistedAdminNamen);
            professionTextView = itemView.findViewById(R.id.AdminProfesiondoctorOnen);
        }

        public void bind(Admin admin) {
            profileImageView.setImageResource(admin.getProfileImage());
            nameTextView.setText(admin.getName());
            professionTextView.setText(admin.getProfession());
        }
    }
}
