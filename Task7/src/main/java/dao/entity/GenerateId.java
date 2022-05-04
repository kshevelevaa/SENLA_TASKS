package dao.entity;

public class GenerateId {
    long id = 0;

    public long generateId() {
        return ++id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
