package com.example.i_hospital.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MasterAdmin implements Parcelable {
    private String name;
    private String profession;
    private int profileImage;

    // Constructor
    public MasterAdmin(String name, String profession, int profileImage) {
        this.name = name;
        this.profession = profession;
        this.profileImage = profileImage;
    }

    // Parcelable implementation
    protected MasterAdmin(Parcel in) {
        name = in.readString();
        profession = in.readString();
        profileImage = in.readInt();
    }

    public static final Creator<MasterAdmin> CREATOR = new Creator<MasterAdmin>() {
        @Override
        public MasterAdmin createFromParcel(Parcel in) {
            return new MasterAdmin(in);
        }

        @Override
        public MasterAdmin[] newArray(int size) {
            return new MasterAdmin[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(profession);
        dest.writeInt(profileImage);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
