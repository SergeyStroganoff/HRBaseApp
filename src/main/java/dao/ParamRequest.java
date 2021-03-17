package dao;

public class ParamRequest {

   private Integer ID;
   private String Surname;
   private String FirstName;
   private String SecondName;

    public ParamRequest(int ID) {
        this.ID = ID;
    }

    public ParamRequest(String surname) {
        Surname = surname;
    }

    public   ParamRequest(String surname, String firstName) {
        Surname = surname;
        FirstName = firstName;
    }

    public Integer getID() {
        return ID;
    }

    public String getSurname() {
        return Surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }
}
