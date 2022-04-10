package Dao.Entity;

public class GenerateId {
    static long id = 0;

    static public long generateId() {
        return id++;
    }
}
