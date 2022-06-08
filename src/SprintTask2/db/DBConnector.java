package SprintTask2.db;

import SprintTask2.model.Language;
import SprintTask2.model.News;
import SprintTask2.model.Publication;

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
            //statement.setTimestamp(4, news.getPost_date());
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
            //statement.setTimestamp(4, news.getPost_date());
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
}