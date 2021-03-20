package entities;

import java.util.Objects;

public class Position extends BaseEntity {

   private String NamePosition;
   private float salary;


    public Position(int ID, String namePosition, float salary) {
        super(ID);
        NamePosition = namePosition;
        this.salary = salary;
    }

    public String getNamePosition() {
        return NamePosition;
    }

    public void setNamePosition(String namePosition) {
        NamePosition = namePosition;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Position position = (Position) o;
        return Float.compare(position.getSalary(), getSalary()) == 0 && getNamePosition().equals(position.getNamePosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNamePosition(), getSalary());
    }

    @Override
    public String toString() {
        return "Position{" +
                "ID=" + ID +
                ", NamePosition='" + NamePosition + '\'' +
                ", salary=" + salary +
                '}';
    }
}
