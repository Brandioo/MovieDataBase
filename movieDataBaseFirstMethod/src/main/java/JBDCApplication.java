//Brand Citozi SDA Academy
import util.DatabaseUtils;

import java.sql.*;
import java.time.LocalDate;

public class JBDCApplication {
    public static void main(String[] args) {
        System.out.println("Hello World");

        try {

            //DriverManager.getConnection("jdbc:mysql://localhost:3306/humanResources1?user==root&&password=bapinjo123");
            Connection conn = DriverManager.getConnection(
                    DatabaseUtils.DATABASE_HOST,
                    DatabaseUtils.DATABASE_USER,
                    DatabaseUtils.DATABASE_PASSWORD);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
            System.out.println("-Print Departments-");
            while (rs.next()) {
                Integer deptId = rs.getInt("departmentId");
                String deptName = rs.getString("name");
                System.out.println(deptId + " " + deptName);
            }

            System.out.println("-----------------------------------------");

            ResultSet rs1 = stmt.executeQuery("SELECT * FROM project");
            System.out.println("-Print All- ");
            while (rs1.next()) {
                Integer projectID = rs1.getInt("projectId");
                String description = rs1.getString("description");
                System.out.println(projectID + " " + description);
            }
            System.out.println("-----------------------------------------");
            ResultSet rs2 = stmt.executeQuery("SELECT employeeId, firstName, lastName, dateOfBirth FROM employees");
            System.out.println("-Print-");
            iterateEmployees(rs2);
//            while (rs2.next()) {
//                Integer employeeId = rs2.getInt("employeeId");
//                String firstName = rs2.getString("firstName");
//                String lastName = rs2.getString("lastName");
//                LocalDate dateOfBirth = rs2.getDate("dateOfBirth").toLocalDate();
//                System.out.println(employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);
//            }
            System.out.println("-----------------------------------------");
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM employees where firstName like 'B%'");
            System.out.println("-Print Employees that his/her name starts with 'B'-");
//            iterateEmployees(rs3);
            while (rs3.next()) {
                Integer employeeId = rs3.getInt("employeeId");
                String firstName = rs3.getString("firstName");
                String lastName = rs3.getString("lastName");
                LocalDate dateOfBirth = rs3.getDate("dateOfBirth").toLocalDate();
                System.out.println(employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);
            }
            System.out.println("-----------------------------------------");
            System.out.println("-Print Employees that doesn't have department-");
            ResultSet rs4 = stmt.executeQuery(" SELECT * FROM employees left join departments on departments.departmentId=employees.departmentId where employees.departmentId is null");
            iterateEmployees(rs4);
//            while (rs4.next()) {
//                Integer employeeId = rs4.getInt("employeeId");
//                String firstName = rs4.getString("firstName");
//                String lastName = rs4.getString("lastName");
//                LocalDate dateOfBirth = rs4.getDate("dateOfBirth").toLocalDate();
//                System.out.println(employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);
//            }
            System.out.println("-----------------------------------------");
            ResultSet rs5 = stmt.executeQuery(" SELECT * FROM employees left join departments on departments.departmentId=employees.departmentId where employees.departmentId is not null");
            System.out.println("-Print Employees included in departments-");
            iterateEmployees(rs5, true);
//            while (rs5.next()) {
//                Integer employeeId = rs5.getInt("employeeId");
//                String firstName = rs5.getString("firstName");
//                String lastName = rs5.getString("lastName");
//                LocalDate dateOfBirth = rs5.getDate("dateOfBirth").toLocalDate();
//                String depName = rs5.getString("Name");
//                System.out.println(employeeId + " " + firstName + " " + lastName + " " + dateOfBirth+" "+depName);
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Pati nje problem");
        }


    }
    private static void iterateEmployees(ResultSet rs) throws SQLException {
        iterateEmployees(rs, false);
    }
    private static void iterateEmployees(ResultSet rs, boolean join) throws SQLException {
        while (rs.next()) {
            Integer employeeId = rs.getInt("employeeId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            LocalDate dob = rs.getDate("dateOfBirth").toLocalDate();
            String departmentName = "";
            if(join) {
                departmentName = rs.getString("name");
            }
            System.out.println(employeeId + " " + firstName + " " + lastName + " " + dob + "-" +departmentName);
        }
    }

}
