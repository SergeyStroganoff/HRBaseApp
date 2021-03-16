package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends BaseEntity{

    String Surname;
    String FirstName;
    String SecondName;
    LocalDate BirthDate;
    Position position;
    Department department;
    Boolean accessSecret;

    public Employee(int ID, String surname, String firstName, String secondName, LocalDate birthDate,
                    Position position, Department department, Boolean accessSecret) {
        super(ID);
        Surname = surname;
        FirstName = firstName;
        SecondName = secondName;
        BirthDate = birthDate;
        this.position = position;
        this.department = department;
        this.accessSecret = accessSecret;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Boolean getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(Boolean accessSecret) {
        this.accessSecret = accessSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return getSurname().equals(employee.getSurname()) && getFirstName().equals(employee.getFirstName()) && getSecondName().equals(employee.getSecondName()) && getBirthDate().equals(employee.getBirthDate()) && getPosition().equals(employee.getPosition()) && getDepartment().equals(employee.getDepartment()) && Objects.equals(getAccessSecret(), employee.getAccessSecret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSurname(), getFirstName(), getSecondName(), getBirthDate(), getPosition(), getDepartment(), getAccessSecret());
    }
}
