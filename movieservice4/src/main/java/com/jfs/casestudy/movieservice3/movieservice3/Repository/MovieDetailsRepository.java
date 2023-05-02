package com.jfs.casestudy.movieservice3.movieservice3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.casestudy.movieservice3.movieservice3.Main.MovieDetails;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails,Integer>{

	List<MovieDetails> findByMovieTitleAndTime(String movieTitle, String time);
	MovieDetails findByMovieTitleAndTimeAndParkingSlots(String movieTitle, String time,String parkingSlots);
	
}
