package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl {
    @Autowired
    private CityRepository cityRepository;

}
