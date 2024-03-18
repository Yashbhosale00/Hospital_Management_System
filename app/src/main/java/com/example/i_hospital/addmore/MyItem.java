package com.example.i_hospital.addmore;

public class MyItem {
    private String role;
    private String buttonText;

    public MyItem(String role, String buttonText) {
        this.role = role;
        this.buttonText = buttonText;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
