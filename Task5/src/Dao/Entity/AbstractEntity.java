package Dao.Entity;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractEntity {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
