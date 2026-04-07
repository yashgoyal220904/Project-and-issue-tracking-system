package com.example.PaITS.project.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequestDTO {

    @NotBlank(message = "Project Key is required")
    private String projectKey; 

    @NotBlank(message = "Project name is required")
    private String name; 

    private String description;
    private boolean isActive; 

    public ProjectRequestDTO() {
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}