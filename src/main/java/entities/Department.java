package entities;

import java.util.Objects;

public class Department extends BaseEntity {
    private String departmentName;
    private int countPerson;
    private String email;
    private String phoneNumber;

    public Department(int ID, String departmentName, int countPerson, String email, String phoneNumber) {
        super(ID);
        this.departmentName = departmentName;
        this.countPerson = countPerson;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getCountPerson() {
        return countPerson;
    }

    public void setCountPerson(int countPerson) {
        this.countPerson = countPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getID() == that.getID() && getCountPerson() == that.getCountPerson() && getDepartmentName().equals(that.getDepartmentName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getDepartmentName(), getCountPerson());
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID=" + ID +
                ", departmentName='" + departmentName + '\'' +
                ", countPerson=" + countPerson +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
