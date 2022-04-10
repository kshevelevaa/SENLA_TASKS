package View;

import Dao.AbstractDao;
import Dao.Entity.AbstractEntity;
import Service.AbstractService;

import java.util.Scanner;

public class ReadUtil<T extends AbstractService> {

    public int readId(T service) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(service.getAll());
        System.out.println("введите необходимы id");
        int id = scanner.nextInt();
        while (service.getById(id) == null) {
            System.out.println("с данным id ничего не найдено\nвведите верный id");
            id = scanner.nextInt();
        }
        return id;
    }
}