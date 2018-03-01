package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.dto.RoomDTO;
import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.repository.RoomRepository;
import com.lv297.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    @Transactional
    public Room updateRoom(Room room) {
        return null;
    }

    @Override
    @Transactional
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    @Override
    @Transactional
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

    @Override
    public List<RoomDTO> getRoomsStatistics(int hotelId, LocalDate dateFrom, LocalDate dateTo) {
        List<RoomDTO> roomStatistic = new ArrayList<>();
        List<Room> rooms = roomRepository.findByHotel_Id(hotelId);
        int i=1;
        Integer sum;
        for (Room room : rooms) {
            sum = roomRepository.getRoomsStatistic(room.getId(),hotelId,dateFrom,dateTo);
            roomStatistic.add(new RoomDTO(room,i++,sum==null?0:sum));
        }
        return roomStatistic;
    }
}
