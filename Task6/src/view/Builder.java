package view;

import view.implAction.AddMaintenance;
import view.implAction.ChangePriceOfHotelRoom;
import view.implAction.ChangeStatusOfHotelRoomOnRepair;
import view.implAction.CreateHotelRoom;
import view.implAction.Evict;
import view.implAction.ExportClientFromFile;
import view.implAction.ExportHotelRoomFRomFile;
import view.implAction.ExportMaintenanceFromFile;
import view.implAction.ImportClientToFile;
import view.implAction.ImportHotelRoomToFile;
import view.implAction.ImportMaintenanceToFile;
import view.implAction.PrintCountOfClients;
import view.implAction.PrintCountOfFreeHotelRooms;
import view.implAction.PrintDetailOfHotelRoom;
import view.implAction.PrintHotelRoomsToBeFreeToDate;
import view.implAction.PrintPreviousClientsInHotelRoom;
import view.implAction.PrintTotalCostForClient;
import view.implAction.Settle;
import view.implAction.SortClientsByAlphabet;
import view.implAction.SortClientsByDateCheckOut;
import view.implAction.SortFreeHotelRoomsByCountOfPeople;
import view.implAction.SortFreeHotelRoomsByCountOfStars;
import view.implAction.SortFreeHotelRoomsByPrice;
import view.implAction.SortHotelRoomsByCountOfPeople;
import view.implAction.SortHotelRoomsByCountOfStars;
import view.implAction.SortHotelRoomsByPrice;
import view.implAction.SortServiceByDateForClient;
import view.implAction.SortServiceByPriceForClient;

import java.util.ArrayList;
import java.util.List;


public class Builder {
    Menu rootMenu = new Menu();

    public void buildMenu() {
        rootMenu.setName("Главное меню");
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("1.Клиенты"));
        menuItems.add(new MenuItem("2.Комнаты и услуги"));
        menuItems.add(new MenuItem("3.Сортирвоки"));
        menuItems.add(new MenuItem("0.Выйти"));
        rootMenu.setMenuItems(menuItems);
        List<MenuItem> clientMenuItems = new ArrayList<>();
        clientMenuItems.add(new MenuItem("1.Поселить", new Settle()));
        clientMenuItems.add(new MenuItem("2.Выселить", new Evict()));
        clientMenuItems.add(new MenuItem("3.Напечатать общее число постояльцев", new PrintCountOfClients()));
        clientMenuItems.add(new MenuItem("4.Общая цена для клиента, включая стоимость номера и услуг сервиса", new PrintTotalCostForClient()));
        clientMenuItems.add(new MenuItem("5.Добавить услугу", new AddMaintenance()));
        clientMenuItems.add(new MenuItem("6.Импорт клиента в файл по id", new ImportClientToFile()));
        clientMenuItems.add(new MenuItem("7.Экспорт клиента из файла по id", new ExportClientFromFile()));
        clientMenuItems.add(new MenuItem("0.Выйти"));
        Menu clientMenu = new Menu();
        clientMenu.setName("Клиенты");
        clientMenu.setMenuItems(clientMenuItems);
        rootMenu.menuItems.get(0).setNextMenu(clientMenu);
        List<MenuItem> HotelRoomMenuItems = new ArrayList<>();
        HotelRoomMenuItems.add(new MenuItem("1.Добавить комнату", new CreateHotelRoom()));
        HotelRoomMenuItems.add(new MenuItem("2.Изменить цену комнаты", new ChangePriceOfHotelRoom()));
        HotelRoomMenuItems.add(new MenuItem("3.Изменить статус номера на ремонтируемый", new ChangeStatusOfHotelRoomOnRepair()));
        HotelRoomMenuItems.add(new MenuItem("4.Напечатать количество свободных номеров", new PrintCountOfFreeHotelRooms()));
        HotelRoomMenuItems.add(new MenuItem("5.Напечатать детали номера", new PrintDetailOfHotelRoom()));
        HotelRoomMenuItems.add(new MenuItem("6.Напечатать номера, свободные к конкретной дате", new PrintHotelRoomsToBeFreeToDate()));
        HotelRoomMenuItems.add(new MenuItem("7.Напечатать прошлых клиентов номера", new PrintPreviousClientsInHotelRoom()));
        HotelRoomMenuItems.add(new MenuItem("8.Импортировать комнату в файл по id", new ImportHotelRoomToFile()));
        HotelRoomMenuItems.add(new MenuItem("9.Экспортировать комнату из файла по id", new ExportHotelRoomFRomFile()));
        HotelRoomMenuItems.add(new MenuItem("10.Импортировать усулуг в файл по id", new ImportMaintenanceToFile()));
        HotelRoomMenuItems.add(new MenuItem("11.Экспортировать услугу из файла по id", new ExportMaintenanceFromFile()));
        HotelRoomMenuItems.add(new MenuItem("0.Выйти"));
        Menu HotelRoomMenu = new Menu();
        HotelRoomMenu.setName("Комнаты");
        HotelRoomMenu.setMenuItems(HotelRoomMenuItems);
        rootMenu.menuItems.get(1).setNextMenu(HotelRoomMenu);
        List<MenuItem> SortingsMenuItems = new ArrayList<>();
        SortingsMenuItems.add(new MenuItem("1.Сортировать клиентов по алфавиту", new SortClientsByAlphabet()));
        SortingsMenuItems.add(new MenuItem("2.Сортировать клиентов по дате выезда", new SortClientsByDateCheckOut()));
        SortingsMenuItems.add(new MenuItem("3.Сортировать свободные номера по вместимости", new SortFreeHotelRoomsByCountOfPeople()));
        SortingsMenuItems.add(new MenuItem("4.Сортировать свободные номера по количеству звезд", new SortFreeHotelRoomsByCountOfStars()));
        SortingsMenuItems.add(new MenuItem("5.Сортировать свободные номера по цене", new SortFreeHotelRoomsByPrice()));
        SortingsMenuItems.add(new MenuItem("6.Сортировать номера по вместимости", new SortHotelRoomsByCountOfPeople()));
        SortingsMenuItems.add(new MenuItem("7.Сортировать номера по количеству звезд", new SortHotelRoomsByCountOfStars()));
        SortingsMenuItems.add(new MenuItem("8.Сортировать номера по цене", new SortHotelRoomsByPrice()));
        SortingsMenuItems.add(new MenuItem("9.Сортировать услуги сервиса клиента по дате", new SortServiceByDateForClient()));
        SortingsMenuItems.add(new MenuItem("10.Сортировать услуги сервиса клиента по цене", new SortServiceByPriceForClient()));
        SortingsMenuItems.add(new MenuItem("0.Выйти"));
        Menu SortingMenu = new Menu();
        SortingMenu.setName("Комнаты");
        SortingMenu.setMenuItems(SortingsMenuItems);
        rootMenu.menuItems.get(2).setNextMenu(SortingMenu);
    }

    public Menu getMenu() {
        return rootMenu;
    }
}
