package com.digital.parking.app.repository;

import com.digital.parking.app.model.ParkingStatus;
import org.springframework.data.repository.CrudRepository;

public interface ParkingStatusRepository extends CrudRepository<ParkingStatus, String> {
}