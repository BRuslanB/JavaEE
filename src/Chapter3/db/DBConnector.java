package Chapter3.db;

import Chapter3.model.City;
import Chapter3.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javapro_db","postgres","postgres");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ts.id, ts.name, ts.surname, ts.birthdate, ts.city_id, tc.name AS cityName " +
                    "FROM t_students ts " +
                    "INNER JOIN t_cities tc on ts.city_id = tc.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");

                City city = new City();
                city.setId(resultSet.getLong("city_id"));
                city.setName(resultSet.getString("cityName"));

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSurname(surname);
                student.setBirthdate(birthdate);
                student.setCity(city);

                students.add(student);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public static void addStudent(Student student){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_students (name, surname, birthdate, city_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getBirthdate());
            statement.setLong(4, student.getCity().getId());

            statement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Student getStudent(Long s_id){

        Student student = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ts.id, ts.name, ts.surname, ts.birthdate, ts.city_id, tc.name AS cityName " +
                    "FROM t_students ts " +
                    "INNER JOIN t_cities tc on ts.city_id = tc.id " +
                    "WHERE ts.id = ? LIMIT 1");

            statement.setLong(1, s_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");

                City city = new City();
                city.setId(resultSet.getLong("city_id"));
                city.setName(resultSet.getString("cityName"));

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSurname(surname);
                student.setBirthdate(birthdate);
                student.setCity(city);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    public static void saveStudent(Student student){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_students SET name = ?, surname = ?, birthdate = ?, city_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getBirthdate());
            statement.setLong(4, student.getCity().getId());
            statement.setLong(5,student.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Student student){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_students WHERE id = ?");

            statement.setLong(1, student.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<City> getAllCities(){

        ArrayList<City> cities = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_cities ORDER BY name ASC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));

                cities.add(city);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static City getCity(Long c_id) {
        City city = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_cities WHERE id = ? LIMIT 1");

            statement.setLong(1, c_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return city;
    }
}