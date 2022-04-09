package Dao.Entity;

public class RandomUtil {
    static long id = 0;

    static public int getMax5() {
        return (int) (Math.random() * (4)) + 1;
    }

    static public int getMax5000() {
        return (int) (Math.random() * (4999)) + 1;
    }

    static public long generateId() {
        return id++;
    }
}
