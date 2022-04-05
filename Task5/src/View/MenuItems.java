package View;

public class MenuItems {
    String title;
    Menu nextMenu;
    IAction action;

    public MenuItems(String title, IAction action) {

        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    @Override
    public String toString() {
        return title + "\n";
    }


    public void doAction() {
        action.doAction();
    }
}
