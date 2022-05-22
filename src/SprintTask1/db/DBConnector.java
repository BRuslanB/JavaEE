package SprintTask1.db;

import SprintTask1.model.Item;
import SprintTask1.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javapro_db",
                    "postgres","postgres");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Item> getAllItem(){

        ArrayList<Item> items = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_items");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);

                items.add(item);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static ArrayList<Item> getAllItemTop(){

        ArrayList<Item> items = new ArrayList<>();
        int count_item = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_items ORDER BY price DESC");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next() && count_item <= 2) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);

                items.add(item);
                count_item++;
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Item item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_items (name, description, price) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveItem(Item item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_items SET name = ?, description = ?, price = ? " +
                    "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItem(Item item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_items WHERE id = ?");

            statement.setLong(1, item.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Item getItem(Long id){

        Item item = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_items WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setDescription(desc);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static ArrayList<User> getAllUser(){

        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(full_name);

                users.add(user);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static User getUser(Long id){

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_items WHERE id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");

                user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(full_name);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}