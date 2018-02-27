package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.repository.RoomRepository;
import com.lv297.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room updateRoom(Room room) {
        return null;
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room getRoomById(int id) {
        return roomRepository.getOne(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getAllRoomsForHotel(int id) {
        return roomRepository.findByHotel_Id(id);
    }

    @Override
    public List<Room> findFreeRoomInHotelInDateRange(int hotelId, LocalDate dateFrom, LocalDate dateTo) {
        return roomRepository.findFreeRoomInHotelInDateRange(hotelId, dateFrom, dateTo);
    }
}
