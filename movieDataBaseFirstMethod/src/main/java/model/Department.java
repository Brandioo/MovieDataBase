package model;

public class Department {
    // variable declaration
    private Integer departmentId;

    private String name;

    // no args constructor

    public Department(){}

    // parametrizied constructor

    public Department(String name){
        this.name = name;
    }

    public Department(Integer departmentId, String name){
        this.departmentId = departmentId;
        this.name = name;
    }

    // getters and setters
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString()
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }
}

