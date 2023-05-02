package com.jfs.casestudy.movieservice3.movieservice3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.casestudy.movieservice3.movieservice3.Main.ParkingDetailsClass;

@Repository
public interface ParkingDetailsClassRepository extends JpaRepository<ParkingDetailsClass, String> {

	ParkingDetailsClass findByConfirmationId(String confirmationId);
}
