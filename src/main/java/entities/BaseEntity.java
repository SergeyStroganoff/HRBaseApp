package entities;

import java.util.Objects;

public abstract class BaseEntity {

    int ID;

    public BaseEntity(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return getID() == that.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }
}
