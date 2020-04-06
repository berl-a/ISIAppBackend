package com.berla.pwrapps.isiapp.rest

import com.berla.pwrapps.isiapp.dto.ClientDto
import com.berla.pwrapps.isiapp.dto.GetCostDto
import com.berla.pwrapps.isiapp.model.Client
import com.berla.pwrapps.isiapp.dto.GetCostReturnDto
import com.berla.pwrapps.isiapp.service.RideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@CrossOrigin("*")
@RestController
@RequestMapping("/rides/")
public class RideControllerV1 {

    @Autowired
    RideService rideService;

    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody ClientDto user) {
        Long addedId = 0L;
        return ResponseEntity.ok("Added with id = " + addedId);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody ClientDto user) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("Client updated successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam("id") Long id) {
        HashMap<String, String> resObj = [:];
        resObj.firstName = "FirstName";
        return ResponseEntity.ok(resObj);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllRides() {
        return ResponseEntity.ok(new LinkedList<>());
    }

    @GetMapping("/getCost")
    public ResponseEntity<GetCostReturnDto> getCost(@RequestBody @Valid GetCostDto getCostDao) {
        GetCostReturnDto getCostReturnDto = rideService.getCost(getCostDao);
        ResponseEntity.ok(getCostReturnDto)
    }
}
