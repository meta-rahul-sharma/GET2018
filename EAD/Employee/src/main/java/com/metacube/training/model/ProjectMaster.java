package com.metacube.training.models;

import java.sql.Date;

public class ProjectMaster {
    private int projectId;
    private String description;
    private Date startDate;
    private Date endDate;
    private String projectLogo;
    ProjectMaster(int projectId, String description, Date startDate, Date endDate, String projectLogo) {
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectLogo = projectLogo;
    }
    public int getProjectId() {
        return projectId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getProjectLogo() {
        return projectLogo;
    }
    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }
}
