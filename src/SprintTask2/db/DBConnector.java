package SprintTask2.db;

import SprintTask2.model.*;

import java.sql.*;
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
    public static ArrayList<News> getAllNews(Language lang, Publication publ){

        ArrayList<News> array_news = new ArrayList<>();

        try {
            PreparedStatement statement;

            if (lang != null) {

                if (publ != null) {

                    statement = connection.prepareStatement("" +
                            "SELECT tn.id, tn.title, tn.short_content, tn.content, tn.post_date, " +
                            "        tn.picture_url, tn.language_id, tl.code, tn.publication_id, tp.name " +
                            "FROM t_news tn " +
                            "INNER JOIN t_languages tl on tn.language_id = tl.id " +
                            "INNER JOIN t_publications tp on tn.publication_id = tp.id " +
                            "WHERE tn.language_id = ? AND tn.publication_id = ? " +
                            "ORDER BY tn.post_date DESC");

                    statement.setLong(1, lang.getId());
                    statement.setLong(2, publ.getId());

                } else {

                    statement = connection.prepareStatement("" +
                            "SELECT tn.id, tn.title, tn.short_content, tn.content, tn.post_date, " +
                            "        tn.picture_url, tn.language_id, tl.code, tn.publication_id, tp.name " +
                            "FROM t_news tn " +
                            "INNER JOIN t_languages tl on tn.language_id = tl.id " +
                            "INNER JOIN t_publications tp on tn.publication_id = tp.id " +
                            "WHERE tn.language_id = ? " +
                            "ORDER BY tn.post_date DESC");

                    statement.setLong(1, lang.getId());
                }

            } else {

                if (publ != null) {

                    statement = connection.prepareStatement("" +
                            "SELECT tn.id, tn.title, tn.short_content, tn.content, tn.post_date, " +
                            "        tn.picture_url, tn.language_id, tl.code, tn.publication_id, tp.name " +
                            "FROM t_news tn " +
                            "INNER JOIN t_languages tl on tn.language_id = tl.id " +
                            "INNER JOIN t_publications tp on tn.publication_id = tp.id " +
                            "WHERE tn.publication_id = ? " +
                            "ORDER BY tn.post_date DESC");

                    statement.setLong(1, publ.getId());

                } else {

                    statement = connection.prepareStatement("" +
                            "SELECT tn.id, tn.title, tn.short_content, tn.content, tn.post_date, " +
                            "        tn.picture_url, tn.language_id, tl.code, tn.publication_id, tp.name " +
                            "FROM t_news tn " +
                            "INNER JOIN t_languages tl on tn.language_id = tl.id " +
                            "INNER JOIN t_publications tp on tn.publication_id = tp.id " +
                            "ORDER BY tn.id");
                }
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String short_content = resultSet.getString("short_content");
                String content = resultSet.getString("content");
                Timestamp post_date = resultSet.getTimestamp("post_date");
                String picture_url = resultSet.getString("picture_url");

                Language language = new Language();
                language.setId(resultSet.getLong("language_id"));
                language.setCode(resultSet.getString("code"));

                Publication publication = new Publication();
                publication.setId(resultSet.getLong("publication_id"));
                publication.setName(resultSet.getString("name"));

                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setShort_content(short_content);
                news.setContent(content);
                news.setPost_date(post_date);
                news.setPicture_url(picture_url);
                news.setLanguage(language);
                news.setPublication(publication);

                array_news.add(news);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return array_news;
    }

    public static News getNews(Long id){

        News news = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tn.id, tn.title, tn.short_content, tn.content, tn.post_date, " +
                    "        tn.picture_url, tn.language_id, tl.code, tn.publication_id, tp.name " +
                    "FROM t_news tn " +
                    "INNER JOIN t_languages tl on tn.language_id = tl.id " +
                    "INNER JOIN t_publications tp on tn.publication_id = tp.id " +
                    "WHERE tn.id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String short_content = resultSet.getString("short_content");
                String content = resultSet.getString("content");
                Timestamp post_date = resultSet.getTimestamp("post_date");
                String picture_url = resultSet.getString("picture_url");

                Language language = new Language();
                language.setId(resultSet.getLong("language_id"));
                language.setCode(resultSet.getString("code"));

                Publication publication = new Publication();
                publication.setId(resultSet.getLong("publication_id"));
                publication.setName(resultSet.getString("name"));

                news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setShort_content(short_content);
                news.setContent(content);
                news.setPost_date(post_date);
                news.setPicture_url(picture_url);
                news.setLanguage(language);
                news.setPublication(publication);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addNews(News news){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_news (title, short_content, content, post_date, picture_url, " +
                        "language_id, publication_id) " +
                    "VALUES (?, ?, ?, now(), ?, ?, ?)");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getShort_content());
            statement.setString(3, news.getContent());
            statement.setString(4, news.getPicture_url());
            statement.setLong(5, news.getLanguage().getId());
            statement.setLong(6, news.getPublication().getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveNews(News news){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_news SET title = ?, short_content = ?, content = ?, picture_url = ? " +
                        "language_id = ?, publication_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getShort_content());
            statement.setString(3, news.getContent());
            statement.setString(4, news.getPicture_url());
            statement.setLong(5, news.getLanguage().getId());
            statement.setLong(6, news.getPublication().getId());
            statement.setLong(7, news.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNews(News news){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_news WHERE id = ?");

            statement.setLong(1, news.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Language> getAllLanguage(){

        ArrayList<Language> languages = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_languages ORDER BY id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");

                Language language = new Language();
                language.setId(id);
                language.setName(name);
                language.setCode(code);

                languages.add(language);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return languages;
    }

    public static Language getLanguage(Long id){

        Language language = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_languages WHERE id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");

                language = new Language();
                language.setId(id);
                language.setName(name);
                language.setCode(code);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return language;
    }

    public static void addLanguage(Language language){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_languages (name, code) " +
                    "VALUES (?, ?)");

            statement.setString(1, language.getName());
            statement.setString(2, language.getCode());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveLanguage(Language language){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_languages SET name = ?, code = ? " +
                    "WHERE id = ?");

            statement.setString(1, language.getName());
            statement.setString(2, language.getCode());
            statement.setLong(3, language.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteLanguage(Language language){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_languages WHERE id = ?");

            statement.setLong(1, language.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Publication> getAllPublication(String sort_field, String sort_type){

        ArrayList<Publication> publications = new ArrayList<>();

        try {

            PreparedStatement statement;

            if (sort_field != null && sort_type != null) {
                statement = connection.prepareStatement("" +
                        "SELECT * FROM t_publications ORDER BY " + sort_field + " " + sort_type);
            } else {
                statement = connection.prepareStatement("" +
                        "SELECT * FROM t_publications ORDER BY id");
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double rating = resultSet.getDouble("rating");

                Publication publication = new Publication();
                publication.setId(id);
                publication.setName(name);
                publication.setDescription(description);
                publication.setRating(rating);

                publications.add(publication);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return publications;
    }

    public static Publication getPublication(Long id){

        Publication publication = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_publications WHERE id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double rating = resultSet.getDouble("rating");

                publication = new Publication();
                publication.setId(id);
                publication.setName(name);
                publication.setDescription(description);
                publication.setRating(rating);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return publication;
    }

    public static void addPublication(Publication publication){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_publications (name, description, rating) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, publication.getName());
            statement.setString(2, publication.getDescription());
            statement.setDouble(3, publication.getRating());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void savePublication(Publication publication){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_publications SET name = ?, description = ?, rating = ? " +
                    "WHERE id = ?");

            statement.setString(1, publication.getName());
            statement.setString(2, publication.getDescription());
            statement.setDouble(3, publication.getRating());
            statement.setLong(4, publication.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePublication(Publication publication){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_publications WHERE id = ?");

            statement.setLong(1, publication.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Role> getAllRole(){

        ArrayList<Role> roles = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_roles ORDER BY id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                Role role = new Role();
                role.setId(id);
                role.setName(name);
                role.setDescription(description);

                roles.add(role);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    public static Role getRole(Long id){

        Role role = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM t_roles WHERE id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                role = new Role();
                role.setId(id);
                role.setName(name);
                role.setDescription(description);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public static void addRole(Role role){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_roles (name, description) " +
                    "VALUES (?, ?)");

            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRole(Role role){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_roles SET name = ?, description = ? " +
                    "WHERE id = ?");

            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());
            statement.setLong(3, role.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRole(Role role){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_roles WHERE id = ?");

            statement.setLong(1, role.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<User> getAllUser(){

        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tu.id, tu.email, tu.password, tu.full_name, tu.role_id, tr.name " +
                    "FROM t_users tu " +
                    "INNER JOIN t_roles tr on tu.role_id = tr.id " +
                    "ORDER BY tu.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");
                Long role_id = resultSet.getLong("role_id");
                String name = resultSet.getString("name");

                Role role = new Role();
                role.setId(role_id);
                role.setName(name);

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setFull_name(full_name);
                user.setRole(role);

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
                    "SELECT tu.email, tu.full_name, tu.role_id, tr.name " +
                    "FROM t_users tu " +
                    "INNER JOIN t_roles tr on tu.role_id = tr.id " +
                    "WHERE tu.id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String full_name = resultSet.getString("full_name");
                Long role_id = resultSet.getLong("role_id");
                String name = resultSet.getString("name");

                Role role = new Role();
                role.setId(role_id);
                role.setName(name);

                user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setFull_name(full_name);
                user.setRole(role);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(String email){

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tu.full_name, tu.password, tu.role_id " +
                    "FROM t_users tu " +
                    "INNER JOIN t_roles tr on tu.role_id = tr.id " +
                    "WHERE tu.email = ? LIMIT 1");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String full_name = resultSet.getString("full_name");
                String password = resultSet.getString("password");
                Long role_id = resultSet.getLong("role_id");

                Role role = new Role();
                role.setId(role_id);

                user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setFull_name(full_name);
                user.setRole(role);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_users (email, password, full_name, role_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setLong(4, user.getRole().getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUser(User user){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_users SET email = ?, full_name = ?, role_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFull_name());
            statement.setLong(3, user.getRole().getId());
            statement.setLong(4, user.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(User user){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_users WHERE id = ?");

            statement.setLong(1, user.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getAllComment(){

        ArrayList<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tc.id, tc.user_id, tu.full_name, tc.news_id, tn.title, " +
                            "tc.comment, tc.post_date, tc.verified " +
                    "FROM t_comments tc " +
                    "INNER JOIN t_users tu on tc.user_id = tu.id " +
                    "INNER JOIN t_news tn on tc.news_id = tn.id " +
                    "ORDER BY tc.id DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long user_id = resultSet.getLong("user_id");
                String full_name = resultSet.getString("full_name");
                Long news_id = resultSet.getLong("news_id");
                String title = resultSet.getString("title");
                String comm = resultSet.getString("comment");
                Timestamp post_date = resultSet.getTimestamp("post_date");
                boolean verified = resultSet.getBoolean("verified");

                User user = new User();
                user.setId(user_id);
                user.setFull_name(full_name);

                News news = new News();
                news.setId(news_id);
                news.setTitle(title);

                Comment comment = new Comment();
                comment.setId(id);
                comment.setUser(user);
                comment.setNews(news);
                comment.setComment(comm);
                comment.setPost_date(post_date);
                comment.setVerified(verified);

                comments.add(comment);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static ArrayList<Comment> getAllComment(News news){

        ArrayList<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tc.id, tc.user_id, tu.full_name, tc.comment, tc.post_date " +
                    "FROM t_comments tc " +
                    "INNER JOIN t_users tu on tc.user_id = tu.id " +
                    "INNER JOIN t_news tn on tc.news_id = tn.id " +
                    "WHERE tc.verified = true AND tc.news_id = ? " +
                    "ORDER BY tc.post_date DESC");

            statement.setLong(1, news.getId());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long user_id = resultSet.getLong("user_id");
                String full_name = resultSet.getString("full_name");
                String comm = resultSet.getString("comment");
                Timestamp post_date = resultSet.getTimestamp("post_date");

                User user = new User();
                user.setId(user_id);
                user.setFull_name(full_name);

                Comment comment = new Comment();
                comment.setId(id);
                comment.setUser(user);
                comment.setNews(news);
                comment.setComment(comm);
                comment.setPost_date(post_date);

                comments.add(comment);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static Comment getComment(Long id){

        Comment comment = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT tc.id, tc.user_id, tu.full_name, tc.news_id, tn.title, tc.comment, tc.verified " +
                    "FROM t_comments tc " +
                    "INNER JOIN t_users tu on tc.user_id = tu.id " +
                    "INNER JOIN t_news tn on tc.news_id = tn.id " +
                    "WHERE tc.id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long user_id = resultSet.getLong("user_id");
                String full_name = resultSet.getString("full_name");
                Long news_id = resultSet.getLong("news_id");
                String title = resultSet.getString("title");
                String comm = resultSet.getString("comment");
                boolean verified = resultSet.getBoolean("verified");

                User user = new User();
                user.setId(user_id);
                user.setFull_name(full_name);

                News news = new News();
                news.setId(news_id);
                news.setTitle(title);

                comment = new Comment();
                comment.setId(id);
                comment.setUser(user);
                comment.setNews(news);
                comment.setComment(comm);
                comment.setVerified(verified);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    public static boolean addComment(Comment comment){

        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_comments (user_id, news_id, comment, post_date, verified) " +
                    "VALUES (?, ?, ?, NOW(), false)");

            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getNews().getId());
            statement.setString(3, comment.getComment());

            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static void saveComment(Comment comment){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_comments SET comment = ?, verified = ? " +
                    "WHERE id = ?");

            statement.setString(1, comment.getComment());
            statement.setBoolean(2, comment.isVerified());
            statement.setLong(3, comment.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteComment(Comment comment){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_comments WHERE id = ?");

            statement.setLong(1, comment.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}