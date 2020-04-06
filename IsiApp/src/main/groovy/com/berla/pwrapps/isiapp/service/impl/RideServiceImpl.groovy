package com.berla.pwrapps.isiapp.service.impl

import com.berla.pwrapps.isiapp.dto.GetCostDto
import com.berla.pwrapps.isiapp.dto.RideDto
import com.berla.pwrapps.isiapp.model.Ride
import com.berla.pwrapps.isiapp.dto.GetCostReturnDto
import com.berla.pwrapps.isiapp.service.GoogleMapsApiService
import com.berla.pwrapps.isiapp.service.RideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RideServiceImpl implements RideService {

    private static final double PRICE_PER_KM = 1.2

    @Autowired
    GoogleMapsApiService googleMapsApiService;

    @Override
    Long save(Ride ride) {
        return null
    }

    @Override
    Long save(RideDto rideDto) {
        return null
    }

    @Override
    RideDto findById(long id) {
        return null
    }

    @Override
    List<Ride> findAll() {
        return null
    }

    @Override
    void deleteById(long id) {

    }

    @Override
    void update(Long id, RideDto ride) {

    }

    @Override
    GetCostReturnDto getCost(GetCostDto getCostDto) {
        GetCostReturnDto costReturnDto = googleMapsApiService.getDistanceBetweenPoints(
                getCostDto.getOrigin(),
                getCostDto.getDestination()
        )
        int numberOfMeters = -1;
        if(costReturnDto.getDistance().contains("km")) {
            numberOfMeters = Integer.parseInt(costReturnDto.getDistance().split(" ")[0]) * 1000
        } else if (costReturnDto.getDistance().contains("m")) {
            numberOfMeters = Integer.parseInt(costReturnDto.getDistance().split(" ")[0])
        }
        double price = PRICE_PER_KM * ((double) numberOfMeters) / 1000.0;
        costReturnDto.setPrice(price)
        costReturnDto
    }
}
