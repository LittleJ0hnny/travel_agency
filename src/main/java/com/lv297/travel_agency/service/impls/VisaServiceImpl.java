package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.repository.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaServiceImpl {
    @Autowired
    private VisaRepository visaRepository;

}
