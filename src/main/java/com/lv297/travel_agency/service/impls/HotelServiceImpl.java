package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.repository.HotelRepository;
import com.lv297.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelRepository.getOne(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Room> findFreeRoomInHotelInDate(Hotel hotel, LocalDate date) {
        return hotelRepository.findFreeRoomInHotelInDate(hotel, date);
    }

    @Override
    public List<Room> findFreeRoomInHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo) {
        return hotelRepository.findFreeRoomInHotelInDateRange(hotel, dateFrom, dateTo);
    }

}
