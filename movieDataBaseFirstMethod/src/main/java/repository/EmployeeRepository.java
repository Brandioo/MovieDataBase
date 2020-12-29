package repository;

import model.Employee;
import model.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private final Connection conn;

    public EmployeeRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Employee> findAll() throws SQLException {
        Statement stmt = conn.createStatement();

        List<Employee> employees = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("Select * from employees");

        while (rs.next()) {
//            Department department = new Department();
//            department.setDepartmentId(rs.getInt("departmentId"));
//            department.setName(rs.getString("name"));
//            departments.add(department);

//            Department department = new Department(rs.getInt("departmentId"), rs.getString("name"));
//            departments.add(department);

            employees.add(new Employee(rs.getInt("employeeId")
                    , rs.getString("firstName")
                    , rs.getString("lastName")
                    , rs.getDate("dateOfBirth")
                    , rs.getString("phoneNumber")
                    , rs.getString("email")
                    , rs.getInt("salary")
                    , rs.getInt("departmentId")));
        }

        return employees;
    }


    public Employee findById(Integer employeeId) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("Select * from employees where employeeId = ?");

        pstmt.setInt(1, employeeId);

        ResultSet rs = pstmt.executeQuery();


        if (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setFirstName(rs.getString("firstName"));
            employee.setLastName(rs.getString("lastName"));
            employee.setDateOfBirth(rs.getDate("dateOfBirth"));
            employee.setPhoneNumber(rs.getString("phoneNumber"));
            employee.setEmail(rs.getString("email"));
            employee.setSalary(rs.getInt("salary"));
            employee.setDepartmentId(rs.getInt("departmentId"));
            return employee;
        }


        return null;
    }

    public void deleteById(Integer id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Delete from employees where employeeId = ?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }


    public void save(Employee employee) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Insert into employees(firstName) values(?)");

        pstmt.setString(1, employee.getFirstName());

        pstmt.executeUpdate();
    }

    public void update(Employee employee) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update employees set firstName = ? where employeeId = ?");

        pstmt.setString(1, employee.getFirstName());
        pstmt.setInt(2, employee.getEmployeeId());

        pstmt.executeUpdate();
    }

    public void updateColumn(Employee employee) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("UPDATE `humanresources1`.`employees` SET `lastName` = 'Shady', `dateOfBirth` = '1971-10-14', `phoneNumber` = 'no Contact',  `email` = 'shadyIsBack@hotmail.com' WHERE (`employeeId` = '14')");
//
//        pstmt.setInt(1,employee.getEmployeeId());
//        pstmt.setString(2,employee.getLastName());
//        pstmt.setString(3, employee.getEmail());
//        pstmt.setString(2, employee.getLastName());
//
//        pstmt.setString(3, employee.getPhoneNumber());


        pstmt.executeUpdate();
    }

    public Employee findByName(String firstName) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Select * from employees where firstName = ?");

        pstmt.setString(1, firstName);

        ResultSet rs = pstmt.executeQuery();


        if (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setFirstName(rs.getString("firstName"));
            employee.setLastName(rs.getString("lastName"));
            employee.setDateOfBirth(rs.getDate("dateOfBirth"));
            employee.setPhoneNumber(rs.getString("phoneNumber"));
            employee.setEmail(rs.getString("email"));
            employee.setSalary(rs.getInt("salary"));
            employee.setDepartmentId(rs.getInt("departmentId"));
            return employee;
        }
        return null;
    }
}


