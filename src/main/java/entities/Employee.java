package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends BaseEntity {

   private String surname;
   private String firstName;
   private String secondName;
   private LocalDate birthDate;
   private Position position;
   private Department department;
   private Boolean accessSecret;

    public Employee(int ID, String surname, String firstName, String secondName, LocalDate birthDate,
                    Position position, Department department, Boolean accessSecret) {
        super(ID);
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.position = position;
        this.department = department;
        this.accessSecret = accessSecret;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", Surname='" + surname + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", SecondName='" + secondName + '\'' +
                ", BirthDate=" + birthDate +
                ", position=" + position +
                ", department=" + department +
                ", accessSecret=" + accessSecret +
                '}';
    }
}
