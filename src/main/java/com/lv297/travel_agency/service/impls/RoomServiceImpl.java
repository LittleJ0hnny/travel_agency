package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl {
    @Autowired
    private RoomRepository roomRepository;

}
