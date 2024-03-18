package com.example.i_hospital.models;

public class Staff {
    private String name;
    private String profession;
    private int profileImage;

    public Staff(String name, String profession, int profileImage) {
        this.name = name;
        this.profession = profession;
        this.profileImage = profileImage;
    }

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
