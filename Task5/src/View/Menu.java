package View;

import java.util.List;

public class Menu {
    String name;
    List<MenuItem> menuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {

        return menuItems;
    }

    public String printMenuItems() {
        String output = "";
        for (int i = 0; i < menuItems.size(); i++) {
            output += menuItems.get(i).getTitle() + "\n";
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < menuItems.size(); i++) {
            output += menuItems.get(i).getTitle() + "\n";
        }
        return output;
    }


    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
