package view;

import service.AbstractService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public static void checkIdForImport(AbstractService service, long id) {
        File file = service.getFile();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                long idFromFile = Integer.parseInt(words[0]);
                if (idFromFile == id) {
                    String newFile = "";
                    Scanner scanner1 = new Scanner(file);
                    while (scanner1.hasNextLine()) {
                        String tmp = scanner1.nextLine();
                        if (!tmp.equals(line)) {
                            newFile += tmp + "\n";
                        }
                    }
                    FileWriter writer = new FileWriter(file);
                    writer.write(newFile);
                    writer.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long readIdForExport(AbstractService service) {
        File file = service.getFile();
        try (Scanner scanner = new Scanner(file)) {
            Scanner sc1 = new Scanner(file);
            while (sc1.hasNextLine()) {
                System.out.println(sc1.nextLine());
            }
            long id = readInt();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                long idFromFile = Integer.parseInt(words[0]);
                System.out.println(words[0]);
                if (idFromFile == id) {
                    return idFromFile;
                }
            }
            System.out.println("с таким id в файле ничего нет");
            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
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