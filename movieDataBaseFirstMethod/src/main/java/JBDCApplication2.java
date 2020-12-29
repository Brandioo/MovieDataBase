//Brand Citozi SDA Academy
import util.DatabaseUtils;

import java.sql.*;
import java.time.LocalDate;

public class JBDCApplication2 {
    public static void main(String[] args) {
        try (
                //DriverManager.getConnection("jdbc:mysql://localhost:3306/humanResources1?user==root&&password=bapinjo123");
                Connection conn = DriverManager.getConnection(
                        DatabaseUtils.DATABASE_HOST,
                        DatabaseUtils.DATABASE_USER,
                        DatabaseUtils.DATABASE_PASSWORD);

                Statement stmt = conn.createStatement();
        ) {
            //try with success
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM departments")) {
                while (rs.next()) {
                    Integer deptId = rs.getInt("departmentId");
                    String deptName = rs.getString("name");
                    System.out.println(deptId + " " + deptName);
                }
            }
            System.out.println("-----------------------------------------");
            try (ResultSet rs1 = stmt.executeQuery("SELECT * FROM project")) {
                while (rs1.next()) {
                    Integer projectID = rs1.getInt("projectId");
                    String description = rs1.getString("description");
                    System.out.println(projectID + " " + description);
                }
            }
            System.out.println("-----------------------------------------");
            try (ResultSet rs2 = stmt.executeQuery("SELECT employeeId, firstName, lastName, dateOfBirth FROM employees")) {
                iterateEmployees(rs2);
            }
            System.out.println("-----------------------------------------");
            try (ResultSet rs3 = stmt.executeQuery("SELECT * FROM employees where firstName like 'B%'")) {
                iterateEmployees(rs3);
            }
            System.out.println("-----------------------------------------");
            try (ResultSet rs4 = stmt.executeQuery(" SELECT * FROM employees left join departments on departments.departmentId=employees.departmentId where employees.departmentId is null")) {
                iterateEmployees(rs4);
            }
            System.out.println("-----------------------------------------");
            try (ResultSet rs5 = stmt.executeQuery("SELECT * FROM employees left join departments on departments.departmentId=employees.departmentId where employees.departmentId is not null")) {
                iterateEmployees(rs5);
            }
            System.out.println("-----------------------------------------");
            System.out.println("Set HumanResources where HR");
            Integer affectedRows=stmt.executeUpdate("UPDATE departments SET name='HumanResources' where departmentId=1");
            System.out.println(affectedRows + " number of affected rows");
            if(affectedRows==1)
            {
                System.out.println("Update u be me sukses");
            }else{
                System.out.println("Pati nje problem");
            }
            System.out.println("-----------------------------------------");
            System.out.println("Insertion- (Prepared Statement)");
            String insertionIntoEmployees="INSERT INTO employees(firstname,"+
                    "lastname,dateOfBirth,phoneNumber,email,salary)values(?,?,?,?,?,?)";
            PreparedStatement stmt1= conn.prepareStatement(insertionIntoEmployees);
            stmt1.setString(1,"Kevin");
            stmt1.setString(2,"Smith");
            stmt1.setDate(3,Date.valueOf("1980-10-10"));
            stmt1.setString(4,"0698877989");
            stmt1.setString(5,"kevinsmith@hotmail.com");
            stmt1.setInt(6,300000);

            affectedRows=stmt1.executeUpdate();
            System.out.println("Insert Completed-"+affectedRows+"-rows affected");

            stmt1.setString(1,"Endrit");
            stmt1.setString(2,"Abdiaj");
            stmt1.setDate(3,Date.valueOf("1980-11-11"));
            stmt1.setString(4,"0697788567");
            stmt1.setString(5,"eabdiaj@yahoo.com");
            stmt1.setInt(6,30000);

            affectedRows=stmt1.executeUpdate();
            System.out.println("Insert Completed-"+affectedRows+"-rows affected");

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
            if (join) {
                departmentName = rs.getString("name");
            }
            System.out.println(employeeId + " " + firstName + " " + lastName + " " + dob + departmentName);
        }
    }
}


