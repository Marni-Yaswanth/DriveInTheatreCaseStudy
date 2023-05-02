package com.microservices.CaseStudy.DriveInMovie.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.CaseStudy.DriveInMovie.Proxy.MovieScheduleProxy;
import com.microservices.CaseStudy.DriveInMovie.Repository.MovieScheduleRepository;
import com.microservices.CaseStudy.DriveInMovie.exception.InvalidMovieFound;
import com.microservices.CaseStudy.DriveInMovie.movieclass.Movie1;

@Service
public class MovieScheduleService {
	
	@Autowired
    private MovieScheduleRepository movieScheduleRepository;
	
	
	@Autowired
	private MovieScheduleProxy proxy;
	
	List<String> list = new ArrayList<String>();
	
	public String addMovieSchedule(Movie1 movie1) throws InvalidMovieFound{
	
		list = proxy.viewAllMovieTitles();
		
		if(list.contains(movie1.getMovieTitle())) 
		{
			movieScheduleRepository.save(movie1);
			return "successfully scheduled";
		}
		else 
		{

			throw new InvalidMovieFound("No Such movie found");
		}
			
	}    

    public String updateMovieSchedule(String title, Movie1 movie1) throws InvalidMovieFound {
    	list = proxy.viewAllMovieTitles();
    	Optional<Movie1> optional = movieScheduleRepository.findById(title);
    	if(optional.isPresent()) 
		{
    		movieScheduleRepository.delete(optional.get());
    		movieScheduleRepository.save(movie1);
    		return "successfully updated";
		}
    	else {
    		throw new InvalidMovieFound("no movie found to update");
		}
    	
    }

	public Movie1 getMovieSchedule(String title) {
		
		Optional<Movie1> optionalMovieSchedule = movieScheduleRepository.findById(title);
		if(optionalMovieSchedule.isPresent())
		{
			return optionalMovieSchedule.get();
		}
		return null;
	}

	public String deleteMovieSchedule(String title) throws InvalidMovieFound {
		Optional<Movie1> optional = movieScheduleRepository.findById(title);
		if(optional.isPresent())
		{
			movieScheduleRepository.delete(optional.get());
			return "deleted successfully";
		}
		else {
			throw new InvalidMovieFound("no movie found to delete");
		}
		
	}
}

