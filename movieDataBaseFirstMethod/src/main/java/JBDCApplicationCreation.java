//Brand Citozi SDA Academy
import model.Department;
import model.Employee;
import model.Movies;
import model.Project;
import repository.DepartmentRepository;
import repository.EmployeeRepository;
import repository.MoviesRepository;
import repository.ProjectRepository;
import util.DatabaseUtils;
import util.DatabaseUtilsHomeWorkMovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public class JBDCApplicationCreation {

    public static void main(String[] args) {
//
//        try (
//                Connection conn =
//                        DriverManager.getConnection(
//                                DatabaseUtils.DATABASE_HOST,
//                                DatabaseUtils.DATABASE_USER,
//                                DatabaseUtils.DATABASE_PASSWORD
//                        )
//        ) {
//          DepartmentRepository departmentRepository = new DepartmentRepository(conn);
//
//            List<Department> departments = departmentRepository.findAll();
//
//            departments.forEach(x -> System.out.println(x));
//            System.out.println("-----------------------------------------------");
//            Department department = departmentRepository.findById(1);
//
//            if (department != null) {
//                System.out.println(department);
//            }
//
//            System.out.println("-----------------------------------------------");
//            departments = departmentRepository.findByName("Finance");
//
//            departments.forEach(x -> System.out.println(x));
//
//
//            System.out.println("-----------------------------------------------");
//            departmentRepository.update(new Department(1, "HR"));
//
//            //System.out.println("-----------------------------------------------");
//            departmentRepository.save(new Department("Marketing"));


        //System.out.println("-----------------------------------------------------------------------------------------");

//            System.out.println("-Print All Projects-");
//            ProjectRepository projectRepository = new ProjectRepository(conn);
////
//            List<Project> project = projectRepository.findAll();
//
//            System.out.println(project.toString());
//
//            System.out.println("-----------------------------------------------");
//            System.out.println("-Print Project With Given Id-");
//            Project project1=projectRepository.findById(1);
//
//            if (project1 != null) {
//                System.out.println(project1);
//            }
////
//            System.out.println("-----------------------------------------------");
//            System.out.println("-Print Project With Given Description-");
//            project = projectRepository.findByDescription("Java (Fitness Web App)");
////
//            project.forEach(x -> System.out.println(x));
//
//
//
//            System.out.println("-----------------------------------------------");
//            projectRepository.update(new Project(3, "JavaScript and Spring"));
//
//            project = projectRepository.findAll();
//            System.out.println(project.toString());
////
////            System.out.println("-----------------------------------------------");
////            projectRepository.save(new Project("FrontEnd JAVAScript"));



//System.out.println("-----------------------------------------------------------------------------------------");
//
//            System.out.println("Print All Employees");
//            EmployeeRepository employeeRepository = new EmployeeRepository(conn);
////            //
//
//
//
//            List<Employee> employees = employeeRepository.findAll();
//
//            System.out.println("\n" + employees.toString() + "\n");


//            //
//            System.out.println("-----------------------------------------------");
//            System.out.println("Print Employee With Given Id");
//            Employee employee1 = employeeRepository.findById(2);
//
//            if (employee1 != null) {
//                System.out.println(employee1);
//            }
//////////
//            System.out.println("-----------------------------------------------");
//            System.out.println("Print Employee With Given firstName");
//            Employee employee = employeeRepository.findByName("Brand");
//
//            if (employee != null) {
//                System.out.println(employee);
//            }
////
////
////
////
//            System.out.println("-----------------------------------------------");
//           // employeeRepository.update(new Employee(7,"Endrit"));
////            employeeRepository.deleteById(13);
//////
////            employeeRepository.deleteById(14);
////            employeeRepository.deleteById(15);
////            employeeRepository.deleteById(16);
//
////
//            System.out.println("-----------------------------------------------");
//           // //UPDATE `humanresources1`.`employees` SET `employeeId` = '8', `lastName` = 'Jackson', `dateOfBirth` = '1958-08-12', `phoneNumber` = '088 99 66 555', `email` = 'michaeljck@outlook.com', `salary` = '1000000000', `departmentId` = '2' WHERE (`employeeId` = '10');
//            //employeeRepository.save(new Employee("Eminem"));
//
//
//
//
//
////employeeRepository.updateColumn(new Employee());
//


        //System.out.println("-----------------------------------------------------------------------------------------");

        try (
                Connection conn =
                        DriverManager.getConnection(
                                DatabaseUtilsHomeWorkMovies.DATABASE_HOST,
                                DatabaseUtilsHomeWorkMovies.DATABASE_USER,
                                DatabaseUtilsHomeWorkMovies.DATABASE_PASSWORD
                        )
        ) {
            System.out.println("Print All Movies: ");
            MoviesRepository moviesRepository = new MoviesRepository(conn);

            List<Movies> movies = moviesRepository.findAll();

            System.out.println("\n" + movies.toString() + "\n");

            System.out.println("-----------------------------------------------");
            System.out.println("Print Movie Characteristic With Given Id: " + "\n");
            Movies movies1 = moviesRepository.findById(1);

            if (movies1 != null) {
                System.out.println(movies1);
            }
////
            System.out.println("-----------------------------------------------");
            System.out.println("Print Movie Characteristic With Given Title: " + "\n");
            Movies movies2 = moviesRepository.findByTitle("Elite");

            if (movies2 != null) {
                System.out.println(movies2);
            }

//
            System.out.println("-----------------------------------------------");
            moviesRepository.updateAColumn(new Movies(3," Serial {Season 1{10 videos}, Season 2{20 videos} {30 video DOWNLOADED}" ));
            System.out.println("Print All Movies After Changes Made: " + "\n");



            movies = moviesRepository.findAll();
            System.out.println("\n" + movies.toString() + "\n");

            moviesRepository.updateByTitle(new Movies(2,2019));

            moviesRepository.updateGenre(new Movies(3,"Crime/Mister/Drama"));

            movies = moviesRepository.findAll();
            System.out.println(movies.toString());


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Pati nje problem");
        }
    }
}
