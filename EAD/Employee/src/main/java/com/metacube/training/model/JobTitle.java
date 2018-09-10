package com.metacube.training.model;

public class JobTitle {
    private int jobCode;
    private String jobTitle;
    JobTitle(int jobCode, String jobTitle) {
        this.jobCode = jobCode;
        this.jobTitle = jobTitle;
    }
    public int getJobCode() {
        return jobCode;
    } 
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
