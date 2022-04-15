package View;

import java.util.Scanner;

public class Navigator {
    Menu currentMenu;
    Menu previousCurrentMenu;

    public Navigator(Menu menu) {
        currentMenu = menu;
    }

    public void navigate() {
        Scanner scanner = new Scanner(System.in);
        int enter = -1;
        while (enter != 0) {
            enter = scanner.nextInt();
            while (enter < 0 || enter > currentMenu.getMenuItems().size()) {
                System.out.println("!!!некорректный ввод!!!\nвведите еще раз");
                enter = scanner.nextInt();
            }
            try {
                if (currentMenu.menuItems.get(enter - 1).nextMenu != null) {
                    {

                        System.out.println(currentMenu.menuItems.get(enter - 1).nextMenu.printMenuItems());
                        previousCurrentMenu = currentMenu;
                        currentMenu = currentMenu.menuItems.get(enter - 1).nextMenu;
                    }
                } else {
                    currentMenu.menuItems.get(enter - 1).doAction();
                    currentMenu = previousCurrentMenu;
                    System.out.println(currentMenu.printMenuItems());
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
    }
}
