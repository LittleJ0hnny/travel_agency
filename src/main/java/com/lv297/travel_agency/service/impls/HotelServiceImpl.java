package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.dto.HotelDTO;
import com.lv297.travel_agency.repository.HotelRepository;
import com.lv297.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    @Transactional
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    @Transactional
    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    @Transactional
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
    public List<Hotel> getAllHotelsForCity(int id) {
        return hotelRepository.findByCity_Id(id);
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(int cityId, LocalDate dateFrom, LocalDate dateTo) {
        return hotelRepository.findFreeHotelInDateRange(cityId, dateFrom, dateTo);
    }

    @Override
    public List<HotelDTO> hotelsStatistic() {
        List<HotelDTO> hotelsStatistic = new ArrayList<>();
        List<Hotel> hotels = hotelRepository.findAll();
        HotelDTO hotelDTO;
        for (Hotel hotel : hotels) {
            hotelDTO = new HotelDTO(hotel);
            hotelDTO.setNumberClient(hotelRepository.numberClients(hotel.getId()));
            hotelDTO.setAverageBookingTime(hotelRepository.averageBookingTime(hotel.getId()));
            hotelsStatistic.add(hotelDTO);
        }
        return hotelsStatistic;
    }


}
