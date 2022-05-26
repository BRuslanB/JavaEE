package SprintTask1.db;

import SprintTask1.model.Brand;
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
                    "SELECT ti.id, ti.name, ti.price, ti.description, ti.brand_id, " +
                    "tb.name AS brandName, tb.country AS brandCountry " +
                    "FROM t_items ti " +
                    "INNER JOIN t_brands tb on ti.brand_id = tb.id "+
                    "ORDER BY ti.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Brand brand = new Brand();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brandName"));
                brand.setCountry(resultSet.getString("brandCountry"));

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                item.setBrand(brand);

                items.add(item);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItem(Long id){

        Item item = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ti.id, ti.name, ti.price, ti.description, ti.brand_id, " +
                    "tb.name AS brandName, tb.country AS brandCountry " +
                    "FROM t_items ti " +
                    "INNER JOIN t_brands tb on ti.brand_id = tb.id " +
                    "WHERE ti.id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Brand brand = new Brand();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brandName"));
                brand.setCountry(resultSet.getString("brandCountry"));

                item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setDescription(desc);
                item.setBrand(brand);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static ArrayList<Item> getAllItemTop(){

        ArrayList<Item> items = new ArrayList<>();
        int count_item = 1; //количество товаров в топ листе

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ti.id, ti.name, ti.price, ti.description, ti.brand_id, " +
                    "tb.name AS brandName, tb.country AS brandCountry " +
                    "FROM t_items ti " +
                    "INNER JOIN t_brands tb on ti.brand_id = tb.id " +
                    "ORDER BY ti.price DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next() && count_item <= 3) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Brand brand = new Brand();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brandName"));
                brand.setCountry(resultSet.getString("brandCountry"));

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setDescription(description);
                item.setBrand(brand);

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
                    "INSERT INTO t_items (name, description, price, brand_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getBrand().getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveItem(Item item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_items SET name = ?, description = ?, price = ?, brand_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getBrand().getId());
            statement.setLong(5, item.getId());

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

    public static ArrayList<Brand> getAllBrand(){

        ArrayList<Brand> brands = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_brands ORDER BY name");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                Brand brand = new Brand();
                brand.setId(id);
                brand.setName(name);
                brand.setCountry(country);

                brands.add(brand);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return brands;
    }

    public static Brand getBrand(Long id){

        Brand brand = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_brands WHERE id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                brand = new Brand();
                brand.setId(id);
                brand.setName(name);
                brand.setCountry(country);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    public static void addBrand(Brand brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_brands (name, country) " +
                    "VALUES (?, ?)");

            statement.setString(1, brand.getName());
            statement.setString(2, brand.getCountry());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveBrand(Brand brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_brands SET name = ?, country = ? " +
                    "WHERE id = ?");

            statement.setString(1, brand.getName());
            statement.setString(2, brand.getCountry());
            statement.setLong(3, brand.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBrand(Brand brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_brands WHERE id = ?");

            statement.setLong(1, brand.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<User> getAllUser(){

        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_users ORDER BY id");
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
                    "SELECT * FROM t_items WHERE id = ? LIMIT 1");

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