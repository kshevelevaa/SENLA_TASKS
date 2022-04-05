package View;

import Dao.ClientsDao;
import Dao.CurrentClientsRepository;
import Service.HotelRoomServiceImpl;


public interface IAction {
    HotelRoomServiceImpl hotelRoomService = new HotelRoomServiceImpl();
    ClientsDao currentClients = hotelRoomService.getCurrentClients();
    CurrentClientsRepository clientsRepository = new CurrentClientsRepository();

    void doAction();
}
