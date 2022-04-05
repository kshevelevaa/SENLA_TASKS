package View;

import View.implAction.*;

import java.util.ArrayList;
import java.util.List;


public class Builder {
    Menu rootMenu = new Menu();

    public void buildMenu() {
        rootMenu.setName("Главное меню");

        List<MenuItems> menuItems = new ArrayList<>();
        menuItems.add(new MenuItems("1.Клиенты", new PrintThreePreviousClientsInHotelRoom()));
        menuItems.add(new MenuItems("2.Комнаты", new PrintThreePreviousClientsInHotelRoom()));
        menuItems.add(new MenuItems("3.Сортирвоки", new PrintThreePreviousClientsInHotelRoom()));
        menuItems.add(new MenuItems("0.Выйти", new PrintThreePreviousClientsInHotelRoom()));
        rootMenu.menuItems = menuItems;


        List<MenuItems> nextMenu0 = new ArrayList<>();
        nextMenu0.add(new MenuItems("1.Поселить", new Settle()));
        nextMenu0.add(new MenuItems("2.Выселить", new Evict()));
        nextMenu0.add(new MenuItems("3.Напечатать общее число постояльцев", new PrintCountOfClients()));
        nextMenu0.add(new MenuItems("4.Общая цена для клиента, включая стоимость номера и услуг сервиса", new PrintTotalCostForClient()));
        nextMenu0.add(new MenuItems("5.Добавить услугу", new AddMaintenance()));
        nextMenu0.add(new MenuItems("0.Выйти", new PrintThreePreviousClientsInHotelRoom()));
        Menu clientMenu = new Menu();
        clientMenu.setName("Клиенты");
        clientMenu.menuItems = nextMenu0;
        rootMenu.menuItems.get(0).nextMenu = clientMenu;

        List<MenuItems> nextMenu1 = new ArrayList<>();
        nextMenu1.add(new MenuItems("1.Добавить комнату", new AddHotelRoom()));
        nextMenu1.add(new MenuItems("2.Изменить цену комнаты", new ChangePriceOfHotelRoom()));
        nextMenu1.add(new MenuItems("3.Изменить статус номера на ремонтируемый", new ChangeStatusOfHotelRoomOnRepair()));
        nextMenu1.add(new MenuItems("4.Напечатать количество свободных номеров", new PrintCountOfFreeHotelRooms()));
        nextMenu1.add(new MenuItems("5.Напечатать детали номера", new PrintDetailOfHotelRoom()));
        nextMenu1.add(new MenuItems("6.Напечатать номера, свободные к конкретной дате", new PrintHotelRoomsToBeFreeToDate()));
        nextMenu1.add(new MenuItems("7.Напечатать прошлых клиентов номера", new PrintThreePreviousClientsInHotelRoom()));
        nextMenu1.add(new MenuItems("0.Выйти", new PrintThreePreviousClientsInHotelRoom()));
        Menu HotelRoomMenu = new Menu();
        HotelRoomMenu.setName("Комнаты");
        HotelRoomMenu.menuItems = nextMenu1;
        rootMenu.menuItems.get(1).nextMenu = HotelRoomMenu;

        List<MenuItems> nextMenu2 = new ArrayList<>();
        nextMenu2.add(new MenuItems("1.Сортировать клиентов по алфавиту", new SortClientsByAlphabet()));
        nextMenu2.add(new MenuItems("2.Сортировать клиентов по дате выезда", new SortClientsByDateCheckOut()));
        nextMenu2.add(new MenuItems("3.Сортировать свободные номера по вместимости", new SortFreeHotelRoomsByCountOfPeople()));
        nextMenu2.add(new MenuItems("4.Сортировать свободные номера по количеству звезд", new SortFreeHotelRoomsByCountOfStars()));
        nextMenu2.add(new MenuItems("5.Сортировать свободные номера по цене", new SortFreeHotelRoomsByPrice()));
        nextMenu2.add(new MenuItems("6.Сортировать номера по вместимости", new SortHotelRoomsByCountOfPeople()));
        nextMenu2.add(new MenuItems("7.Сортировать номера по количеству звезд", new SortHotelRoomsByCountOfStars()));
        nextMenu2.add(new MenuItems("8.Сортировать номера по цене", new SortHotelRoomsByPrice()));
        nextMenu2.add(new MenuItems("9.Сортировать услуги сервиса клиента по дате", new SortServiceByDate()));
        nextMenu2.add(new MenuItems("10.Сортировать услуги сервиса клиента по цене", new SortServiceByPrice()));
        nextMenu2.add(new MenuItems("0.Выйти", new PrintThreePreviousClientsInHotelRoom()));
        Menu SortingMenu = new Menu();
        SortingMenu.setName("Комнаты");
        SortingMenu.menuItems = nextMenu2;
        rootMenu.menuItems.get(2).nextMenu = SortingMenu;


    }

    ;

    public Menu getMenu() {
        return rootMenu;
    }
}
