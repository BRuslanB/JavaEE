package Chapter1.db;

import Chapter1.model.Footballer;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Footballer> footballers = new ArrayList<>();
    public static Long id = 4L;
    static {
        footballers.add(new Footballer(1L, "Ivan", "Ivanov", 65000, "Real", 80000));
        footballers.add(new Footballer(2L, "Petr", "Petrov", 75000, "Real", 90000));
        footballers.add(new Footballer(3L, "Akhmet", "Akhmetov", 85000, "Real", 100000));
    }
    public static void addFootballer(Footballer footballer) { //этот метод добавляет нового футболиста в список
        footballer.setId(id);
        footballers.add(footballer);
        id++;
    }
    public static ArrayList<Footballer> getAllFootballers() { //этот метод возвращает список всех футболистов
        return footballers;
    }
}