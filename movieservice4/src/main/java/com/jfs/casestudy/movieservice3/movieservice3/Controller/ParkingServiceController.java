package com.jfs.casestudy.movieservice3.movieservice3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.casestudy.movieservice3.movieservice3.InvalidSeatException;
import com.jfs.casestudy.movieservice3.movieservice3.Main.ParkingDetailsClass;
import com.jfs.casestudy.movieservice3.movieservice3.Service.ParkingService;

@RestController
public class ParkingServiceController {
	@Autowired
	ParkingService parkingService;

	@GetMapping("/checkSlots/{movieTitle}/{time}")
	public List<String> checkSlots(@PathVariable("movieTitle")String movieTitle,@PathVariable("time")String time)
	{
		return parkingService.checkSlots(movieTitle,time);
	}
	@PostMapping("/addDetails")
	public String add(@RequestBody ParkingDetailsClass parkingDetailsClass) throws InvalidSeatException
	{
		 return  parkingService.addDetails(parkingDetailsClass);
	}
	
	@DeleteMapping("/cancel/{id}")
	public void cancelTicket(@PathVariable("id")String id) throws InvalidSeatException
	{
		parkingService.cancelTicket(id);
	}
	
	@ExceptionHandler(InvalidSeatException.class)
	public String handleException(InvalidSeatException ex) 
	{
		return ex.getMessage();
	}
}
