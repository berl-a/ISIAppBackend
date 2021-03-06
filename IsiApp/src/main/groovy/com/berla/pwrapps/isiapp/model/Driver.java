package com.berla.pwrapps.isiapp.model;

import com.berla.pwrapps.isiapp.dto.DriverDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drivers")
@Data
public class Driver extends BaseEntity {

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name="car")
    private Car car;

    @OneToMany(mappedBy="driver")
    private List<Ride> rides;

    public Driver() {
    }

    /**
     * Constructor to create Driver object from DriverDto object
     * @param driverDto DriverDto object
     */
    public Driver(DriverDto driverDto) {
        firstName = driverDto.getFirstName();
        lastName = driverDto.getLastName();
    }

    /**
     * Get DriverDto for the current object
     * @return DriverDto containing information from current object
     */
    public DriverDto toDriverDto() {
        DriverDto driverDto = new DriverDto();
        driverDto.setFirstName(getFirstName());
        driverDto.setLastName(getLastName());
        return driverDto;
    }

    //todo check if helps upon removal
    @JsonIgnore
    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Driver{}";
    }

    @JsonIgnore
    public List<Ride> getRides() {
        return rides;
    }
}
