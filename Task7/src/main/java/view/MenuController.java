package view;

public class MenuController {
    Builder builder;
    Navigator navigator;

    public MenuController(Builder builder, Navigator navigator){
        this.builder=builder;
        this.navigator=navigator;
    }
    public void run() {
        builder.buildMenu();
        System.out.println(builder.getMenu());
        navigator.navigate();

    }
}
