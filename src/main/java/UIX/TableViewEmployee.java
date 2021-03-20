package UIX;

import entities.Employee;

import java.time.LocalDate;

public class TableViewEmployee {

    private final int ID;
    private final String surname;
    private final String firstName;
    private final String secondName;
    private final LocalDate birthDate;
    private final String departmentName;
    private final String namePosition;
    private final float salary;
    private final Boolean accessSecret;
    private final String phoneNumber;
    private final String email;

    public TableViewEmployee(Employee employee) {
        this.ID = employee.getID();
        this.surname = employee.getSurname();
        this.firstName = employee.getFirstName();
        this.secondName = employee.getSecondName();
        this.birthDate = employee.getBirthDate();
        this.departmentName = employee.getDepartment().getDepartmentName();
        this.namePosition = employee.getPosition().getNamePosition();
        this.accessSecret = employee.getAccessSecret();
        this.phoneNumber = employee.getDepartment().getPhoneNumber();
        this.email = employee.getDepartment().getEmail();
        this.salary = employee.getPosition().getSalary();
    }

    public int getID() {
        return ID;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public String getSalary() {
        return String.valueOf(salary);
    }

    public String getAccessSecret() {
        return accessSecret ? "Оформлен" : "Не оформлен";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
