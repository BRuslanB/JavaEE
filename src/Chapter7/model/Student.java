package Chapter7.model;

public class Student {
    String name;
    String surname;
    int age;
    String city;
    String address;
    String phone;
    String university;
    String faculty;
    String group;

    public Student() {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.city = "";
        this.address = "";
        this.phone = "";
        this.university = "";
        this.faculty = "";
        this.group = "";
    }

    public Student(String name, String surname, int age, String city, String address, String phone, String university, String faculty, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.university = university;
        this.faculty = faculty;
        this.group = group;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}