
package repository;

import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private final Connection conn;

    public ProjectRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Project> findAll() throws SQLException {
        Statement stmt = conn.createStatement();

        List<Project> project = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM project");

        while (rs.next()) {
//            Department department = new Department();
//            department.setDepartmentId(rs.getInt("departmentId"));
//            department.setName(rs.getString("name"));
//            departments.add(department);

//            Department department = new Department(rs.getInt("departmentId"), rs.getString("name"));
//            departments.add(department);

            project.add(new Project(rs.getInt("projectId"), rs.getString("description")));
        }

        return project;
    }

    public Project findById(Integer id) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM project WHERE projectId = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Project projects = new Project("Java(Advanced)");
            projects.setProjectId(rs.getInt("projectId"));
            projects.setDescription(rs.getString("description"));
            return projects;
        }

        return null;
    }

    public void deleteById(Integer id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM project WHERE projectId = ?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }


    public void save(Project projects) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO project(description) VALUES (?)");

        pstmt.setString(1, projects.getDescription());

        pstmt.executeUpdate();
    }

    public void update(Project projects) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update project set description = ? where projectId = ?");

        pstmt.setString(1, projects.getDescription());
        pstmt.setInt(2, projects.getProjectId());

        pstmt.executeUpdate();
    }

    public List<Project> findByDescription(String description) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM project WHERE description = ?");

        pstmt.setString(1, description);

        ResultSet rs = pstmt.executeQuery();

        List<Project> project = new ArrayList<>();

        while (rs.next()) {
            Project projects = new Project();
            projects.setProjectId(rs.getInt("projectId"));
            projects.setDescription(rs.getString("description"));
            project.add(projects);
//            Department department=new Department();
//            department.add(department);
        }

        return project;
    }
}

