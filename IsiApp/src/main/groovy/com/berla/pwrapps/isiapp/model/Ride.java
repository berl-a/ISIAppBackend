package com.berla.pwrapps.isiapp.model;

import com.berla.pwrapps.isiapp.dto.RideDtoFull;
import com.berla.pwrapps.isiapp.dto.RideDtoWithoutLinks;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rides")
@Data
public class Ride extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="driver")
    Driver driver;

    @ManyToOne
    @JoinColumn(name="car")
    Car car;

    @ManyToOne
    @JoinColumn(name="client")
    Client client;

    double originLat;
    double originLon;
    double destinationLat;
    double destinationLon;
    double price;

    public Ride() {
    }

    /**
     * Constructor to create Ride object from RideDtoWithoutReferences object
     * @param rideDto RideDtoWithoutReferences object
     */
    public Ride(RideDtoWithoutLinks rideDto) {
//        driver = rideDto.getDriver();
//        car = rideDto.getCar();
//        client = rideDto.getClient();
        originLat = rideDto.getOriginLat();
        originLon = rideDto.getOriginLon();
        destinationLat = rideDto.getDestinationLat();
        destinationLon = rideDto.getDestinationLon();
        price = rideDto.getPrice();
    }

    /**
     * Constructor to create Ride object from RideDtoFull object
     * @param rideDto RideDtoFull object
     */
    public Ride(RideDtoFull rideDto) {
        driver = rideDto.getDriver();
        car = rideDto.getCar();
        client = rideDto.getClient();
        originLat = rideDto.getOriginLat();
        originLon = rideDto.getOriginLon();
        destinationLat = rideDto.getDestinationLat();
        destinationLon = rideDto.getDestinationLon();
        price = rideDto.getPrice();
    }

    /**
     * Get RideDto for the current object
     * @return RideDto containing information from current object
     */
    public RideDtoWithoutLinks toRideDto() {
        RideDtoFull rideDto = new RideDtoFull();
        rideDto.setDriver(driver);
        rideDto.setCar(car);
        rideDto.setClient(client);
        rideDto.setOriginLat(originLat);
        rideDto.setOriginLon(originLon);
        rideDto.setDestinationLat(destinationLat);
        rideDto.setDestinationLon(destinationLon);
        rideDto.setPrice(price);
        return rideDto;
    }
}
