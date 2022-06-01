package Chapter6.model;

public class Client {
    String name;
    String surname;
    int age;
    String country;
    String gender;
    String credit_card;

    public Client() {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.country = "";
        this.gender = "";
        this.credit_card = "";
    }

    public Client(String name, String surname, int age, String country, String gender, String credit_card) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.credit_card = credit_card;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }
}