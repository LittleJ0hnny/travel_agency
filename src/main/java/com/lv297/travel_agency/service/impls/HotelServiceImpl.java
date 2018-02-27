package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.repository.HotelRepository;
import com.lv297.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Hotel> getAllHotelsForCity(int id) {
        return hotelRepository.findByCity_Id(id);
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(int cityId, LocalDate dateFrom, LocalDate dateTo) {
        return hotelRepository.findFreeHotelInDateRange(cityId, dateFrom, dateTo);
    }

    @Override
    public List<Object[]> hotelsStatistic() {
        List<Object[]> hotelsStatistic = new ArrayList<>();
        List<Hotel> hotels = hotelRepository.findAll();
        for (Hotel hotel : hotels) {
            double averageTime = 0;
            LocalDate dateTo;
            LocalDate dateFrom;
            List<Object> averageTimes = hotelRepository.averageBookingTime(hotel.getId());
            if (!averageTimes.isEmpty()) {
                for (Object o : averageTimes) {
                    Object[] objects = (Object[]) o;
                    dateTo = LocalDate.parse( objects[0].toString());
                    dateFrom = LocalDate.parse(objects[1].toString());
                    averageTime += dateTo.toEpochDay() - dateFrom.toEpochDay();
                }
                averageTime = averageTime / averageTimes.size();
            }
            hotelsStatistic.add(new Object[]{hotel,hotelRepository.numberClients(hotel.getId()),averageTime});
        }
        return hotelsStatistic;
    }


}
