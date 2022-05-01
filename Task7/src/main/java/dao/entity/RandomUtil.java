package dao.entity;

public class RandomUtil {

    static public int getMax5() {
        return (int) (Math.random() * (4)) + 1;
    }

    static public int getMax5000() {
        return (int) (Math.random() * (4999)) + 1;
    }

}
