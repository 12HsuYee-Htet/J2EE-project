package com.example;

public class DoctorDetails {
    private String doctorName;
    private String bachelor;
    private String time;
    private String imageFileName;

    public DoctorDetails(String doctorName, String bachelor, String time, String imageFileName) {
        this.doctorName = doctorName;
        this.bachelor = bachelor;
        this.time = time;
        this.imageFileName = imageFileName;
    }

    // Getters and setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getBachelor() {
        return bachelor;
    }

    public void setBachelor(String bachelor) {
        this.bachelor = bachelor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
