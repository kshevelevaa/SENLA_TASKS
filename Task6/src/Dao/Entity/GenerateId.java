package Dao.Entity;

public class GenerateId {
    long id = 0;

    public long generateId() {
        return ++id;
    }
}
