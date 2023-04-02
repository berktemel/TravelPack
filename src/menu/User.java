package menu;

public class User {

    //properties
    String name;
    String surname;
    String mail;
    String phone;
    String country;
    String city;
    String fullAddress;
    String password;
    //String passwordAgain;

    //constructor;
    public User() {
        name = "";
        surname = "";
        mail = "";
        phone = "";
        country = "";
        city = "";
        fullAddress = "";
        password = "";
        //passwordAgain = "";
    }

    //constructor #2
    public User( String name, String surname, String mail, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        //this.passwordAgain = passwordAgain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {

    }

    public boolean checkPassword()
    {
        if ( this.getPassword().equals(this.getPasswordAgain()))
        {
            return true;
        }
        else
        {
            System.out.println("Passwords are not the same!");
            return false;
        }
    }
     */

    /*
    public static boolean isLocationAuto()
    {
        //TODO
    }

     */
}