package Dao.Entity;

public abstract class AbstractEntity {
    Long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
