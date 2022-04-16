package View;

import Service.AbstractService;

import java.util.Scanner;

public class ReadUtil {
    static Scanner scanner = new Scanner(System.in);

    public static long readId(AbstractService service) {
        System.out.println(service.getAll());
        System.out.println("введите необходимы id");
        long id = scanner.nextLong();
        while (service.getById(id) == null) {
            System.out.println("с данным id ничего не найдено\nвведите верный id");
            id = scanner.nextInt();
        }
        return id;
    }

    public static int readInt() {
        int num = 0;
        try {
            num = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("некорректный ввод");
            readInt();
        }
        return num;
    }

    public static String readString() {
        String string = scanner.nextLine();
        string.matches(".*\\d.*");
        while (string.matches(".*\\d.*") == true) {
            System.out.println("некорректный ввод");
            string = scanner.nextLine();
        }
        return string;
    }
}