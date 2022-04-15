package View;

public class MenuController {
    public void run() {
        Builder builder = new Builder();
        builder.buildMenu();
        System.out.println(builder.getMenu());
        Navigator navigator = new Navigator(builder.rootMenu);
        navigator.navigate();
    }
}
