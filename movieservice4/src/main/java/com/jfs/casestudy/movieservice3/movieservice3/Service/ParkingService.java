package com.jfs.casestudy.movieservice3.movieservice3.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.casestudy.movieservice3.movieservice3.InvalidSeatException;
import com.jfs.casestudy.movieservice3.movieservice3.Main.MovieDetails;
import com.jfs.casestudy.movieservice3.movieservice3.Main.ParkingDetailsClass;
import com.jfs.casestudy.movieservice3.movieservice3.Repository.MovieDetailsRepository;
import com.jfs.casestudy.movieservice3.movieservice3.Repository.ParkingDetailsClassRepository;

@Service
public class ParkingService {
	
	@Autowired
	MovieDetailsRepository movieDetailsRepository;
	@Autowired
	ParkingDetailsClassRepository parkingDetailsClassRepository;
	
	
	List<MovieDetails> list = new ArrayList<>();
	
	List<String> list1 = new ArrayList<String>();
	
	public List<String> checkSlots(String movieTitle,String time) {
		// TODO Auto-generated method stub
		
		list = movieDetailsRepository.findByMovieTitleAndTime(movieTitle,time);
		for (MovieDetails m : list)
		{
			list1.add(m.getParkingSlots());
		}
		//parkingDetailsList.setList1(list1);
		return list1;
	}
	
	
	public String addDetails(ParkingDetailsClass parkingDetailsClass) throws InvalidSeatException
	{
		String slotString = parkingDetailsClass.getParkingSlotNumber();
//		MovieDetails movieDetails = new MovieDetails();
		MovieDetails movieDetails1 = movieDetailsRepository.findByMovieTitleAndTimeAndParkingSlots(parkingDetailsClass.getMovieTitle(),
				parkingDetailsClass.getPlayTime(),parkingDetailsClass.getParkingSlotNumber());
		if(movieDetails1==null)
		{
			throw new InvalidSeatException("no seat avaialble");
		}
		if(movieDetails1.getStatus().equals("Available"))
		{
			for (String string :list1)
			{
				if(string.equals(slotString))
				{
					MovieDetails movieDetails2 = movieDetailsRepository.findByMovieTitleAndTimeAndParkingSlots(parkingDetailsClass.getMovieTitle(),
										parkingDetailsClass.getPlayTime(),parkingDetailsClass.getParkingSlotNumber());
					movieDetails1.setStatus("Booked");
					movieDetailsRepository.save(movieDetails2);
					UUID uuid = UUID.randomUUID();
					String id = uuid.toString().substring(0, 7);
					parkingDetailsClass.setConfirmationId(id);
					parkingDetailsClassRepository.save(parkingDetailsClass);
					
					return ("successfully booked with id: "+id);
				}
			}
		}
//		else
//		{
//			return "no seat avaialble";
//			throw new InvalidSeatException("no seat avaialble");
//		}
		return null;
	}
			
		public void cancelTicket(String id) throws InvalidSeatException
		{
			
			ParkingDetailsClass parkingDetailsClass2 = parkingDetailsClassRepository.findByConfirmationId(id);
			if(parkingDetailsClass2==null)
			{
				throw new InvalidSeatException("Invalid Confirmation ID");
			}
			String movieTitleString = parkingDetailsClass2.getMovieTitle();
			String parkingslotString = parkingDetailsClass2.getParkingSlotNumber();
			String timeString = parkingDetailsClass2.getPlayTime();
			MovieDetails movieDetails3 = movieDetailsRepository.findByMovieTitleAndTimeAndParkingSlots(movieTitleString,timeString,parkingslotString);
			if(movieDetails3.getParkingSlots().equals(parkingslotString))
			{
				movieDetails3.setStatus("Available");
				movieDetailsRepository.save(movieDetails3);
				parkingDetailsClassRepository.delete(parkingDetailsClass2);
			}
			
			
			
		}
		
			
		
	}

