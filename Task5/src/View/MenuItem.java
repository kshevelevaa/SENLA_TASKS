package View;

public class MenuItem {
    String title;
    Menu nextMenu;
    AbstractAction action;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, AbstractAction action) {

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
