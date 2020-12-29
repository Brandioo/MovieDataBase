package repository;

import model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private final Connection conn;

    public DepartmentRepository(Connection conn){
        this.conn = conn;
    }

    public List<Department> findAll() throws SQLException {
        Statement stmt = conn.createStatement();

        List<Department> departments = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("Select * from departments");

        while(rs.next()){
//            Department department = new Department();
//            department.setDepartmentId(rs.getInt("departmentId"));
//            department.setName(rs.getString("name"));
//            departments.add(department);

//            Department department = new Department(rs.getInt("departmentId"), rs.getString("name"));
//            departments.add(department);

            departments.add(new Department(rs.getInt("departmentId"), rs.getString("name")));
        }

        return departments;
    }

    public Department findById(Integer id) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("Select * from departments where departmentId = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            Department department = new Department();
            department.setDepartmentId(rs.getInt("departmentId"));
            department.setName(rs.getString("name"));
            return department;
        }

        return null;
    }

    public void deleteById(Integer id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Delete from departments where departmentId = ?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }


    public void save(Department department) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Insert into departments(name) values(?)");

        pstmt.setString(1, department.getName());

        pstmt.executeUpdate();
    }

    public void update(Department department) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update departments set name = ? where departmentId = ?");

        pstmt.setString(1, department.getName());
        pstmt.setInt(2, department.getDepartmentId());

        pstmt.executeUpdate();
    }

    public List<Department> findByName(String name) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Select * from departments where name = ?");

        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        List<Department> departments = new ArrayList<>();

        while (rs.next()){
            Department department = new Department();
            department.setDepartmentId(rs.getInt("departmentId"));
            department.setName(rs.getString("name"));
            departments.add(department);
        }

        return departments;
    }
}
