package Chapter2.db;

import Chapter2.model.News;
import Chapter2.model.Tasks;

import java.util.ArrayList;

public class DBManager {
    //Task 1
    public static ArrayList<News> news = new ArrayList<>();

    static {
        news.add(new News(1L, "The Crazy Way Falcon And The Winter Soldier Anthony Mackie Learned About " +
                "Captain America 3", "Last Friday, Disney's Tha Falcon and the Winter Soldier concluded its " +
                "six-episode run, and among the major events in the finale was Anthony Mackie's Sam Wilson suiting " +
                "up as Captain America for the first time.", "Adam Holmes", "Cinema"));
        news.add(new News(2L, "Star War's Mark Hamill Addresses Horrifying Theory", "Last Friday, " +
                "Disney's Tha Falcon and the Winter Soldier concluded its six-episode run, and among the major " +
                "events in the finale was Anthony Mackie's Sam Wilson suiting up as Captain America for the first " +
                "time.", "Dirk Libbey", "Cinema"));
        news.add(new News(3L, "Last Man Standing's And The Winter Soldier's Anthony Mackie Learned About " +
                "Captain America 3", "Last Friday, Disney's Tha Falcon and the Winter Soldier concluded " +
                "its six-episode run, and among the major events in the finale was Anthony Mackie's Sam Wilson " +
                "suiting up as Captain America for the first time.", "Adam Holmes", "Culture"));
        news.add(new News(4L, "Mathew McConaughey Reveals And The Winter Soldier's Anthony Mackie Learned " +
                "About Captain America 3", "Last Friday, Disney's Tha Falcon and the Winter Soldier " +
                "concluded its six-episode run, and among the major events in the finale was Anthony Mackie's Sam " +
                "Wilson suiting up as Captain America for the first time.", "Adreon Patterson", "Sport"));
    }
    public static ArrayList<News> getAllNews() { //этот метод возвращает список всех новостей
        return news;
    }

    //Task 2
    public static ArrayList<Tasks> tasks = new ArrayList<>();
    public static Long id = 1L;
    public static boolean status = false;
    public static void addTask(Tasks task) { //этот метод добавляет новую задачу в список
        task.setId(id);
        task.setStatus(status);
        tasks.add(task);
        id++;
    }
    public static Tasks getTask(Long id) { // этот метод возвращает объект задачи по id
        for (Tasks t : tasks)
            if (t.getId() == id)
                return t;
        return null;
    }
    public static ArrayList<Tasks> getAllTasks() { //этот метод возвращает список всех задач
        return tasks;
    }
    public static void saveTask(Long id, Tasks task) { //этот метод сохраняет изменения в задаче
        int i = 0;
        for (Tasks t : tasks) {
            if (t.getId() == id) {
                //out.print("DBManager.set " + i + "\n");
                tasks.set(i, task);
                return;
            }
            i++;
        }
    }
    public static void deleteTask(Long id) { //этот метод удаляет задачу из списка по id
        int i = 0;
        for (Tasks t : tasks) {
            if (t.getId() == id) {
                //out.print("DBManager.remove " + i + "\n");
                tasks.remove(i);
                return;
            }
            i++;
        }
    }
}