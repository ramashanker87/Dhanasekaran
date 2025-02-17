package com.vehicle.app.controller;

import com.vehicle.app.model.Owner;
import com.vehicle.app.model.Registration;
import com.vehicle.app.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerEndPoint {
    private static final Logger logger = LoggerFactory.getLogger(ControllerEndPoint.class);
    private Map<String, Registration> registrationMap = new HashMap<>();

    @PostMapping("/register/vehicle")
    public String registerVehicle(@RequestBody Registration register) {
        Vehicle vehicle = register.getVehicle();
        Owner owner = register.getOwner();

        Registration registration = new Registration(owner, vehicle);

        registrationMap.put(vehicle.getVehicleNumber(), registration);
        logger.info("Vehicle Registered: VehicleNumber {} VehicleType {} FuelType {}", vehicle.getVehicleNumber(), vehicle.getVehicleType(), vehicle.getFuelType());
        logger.debug("Owner Registered with Vehicle: Name {} Address {} Age {}", owner.getName(), owner.getAddress(), owner.getAge());
        return "Motor Vehicle Registered Successfully";
    }

    @GetMapping("/retrieve/vehicle")
    public ResponseEntity<?> getVehicle(@RequestParam String vehicleNumber) {
        Registration registration = registrationMap.get(vehicleNumber);
        logger.debug("Vehicle Number Retrieved {} ", vehicleNumber);
        return ResponseEntity.ok(registration);
        }

    @DeleteMapping("/deregister/vehicle")
    public String deleteVehicle(@RequestParam String vehicleNumber) {
        Registration registration = registrationMap.remove(vehicleNumber);
        logger.warn("Vehicle de-registered: VehicleNumber {}", vehicleNumber);
        return "Vehicle Removed Successfully";
    }
}
