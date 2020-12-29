package model;

public class Project {
    private Integer projectId;
    private String description;

    public Project() {
        this.projectId = projectId;
        this.description = description;
    }

    public Project(Integer projectId, String description) {
        this.projectId = projectId;
        this.description = description;
    }

    public Project(String description) {
        this.description = description;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
