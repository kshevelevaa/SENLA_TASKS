package View;

import java.util.Scanner;

public class Navigator {
    Menu currentMenu;
    Menu previousCurrentMenu;

    public Navigator(Menu menu) {
        currentMenu = menu;
    }

    public void navigate(Integer index) {

        while (index < 0 || index > currentMenu.getMenuItems().size()) {
            System.out.println("!!!некорректный ввод!!!\nвведите еще раз");
            Scanner scanner = new Scanner(System.in);
            index = scanner.nextInt();
        }
        try {
            if (currentMenu.menuItems.get(index - 1).nextMenu != null) {
                {
                    System.out.println(currentMenu.menuItems.get(index - 1).nextMenu.printMenuItems());
                    previousCurrentMenu = currentMenu;
                    currentMenu = currentMenu.menuItems.get(index - 1).nextMenu;
                }
            } else {
                currentMenu.menuItems.get(index - 1).doAction();
                currentMenu = previousCurrentMenu;
                System.out.println(currentMenu.printMenuItems());
            }
        } catch (RuntimeException e) {
            System.out.println("что-то пошло не по плану\nпопробуйте другое действие");
        }

    }
}
