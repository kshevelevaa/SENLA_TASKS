package View;

import java.util.Scanner;

public class MenuController {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.buildMenu();
        System.out.println(builder.getMenu());
        Navigator navigator = new Navigator(builder.rootMenu);
        navigator.navigate();
    }
}
