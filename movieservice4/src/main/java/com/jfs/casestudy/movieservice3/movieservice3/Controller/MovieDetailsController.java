package com.jfs.casestudy.movieservice3.movieservice3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.casestudy.movieservice3.movieservice3.InvalidSeatException;
import com.jfs.casestudy.movieservice3.movieservice3.Main.MovieDetails;
import com.jfs.casestudy.movieservice3.movieservice3.Service.ServiceClass;

import feign.template.Literal;

@RestController
public class MovieDetailsController {

	@Autowired
	ServiceClass serviceClass;
	
	@PostMapping("/add")
	public String addParking(@RequestBody MovieDetails movieDetails) 
	{
		return serviceClass.add(movieDetails);
	}
	
	@PostMapping("/addlist")
	public List<MovieDetails> addMoviesList(@RequestBody MovieDetails movieDetails)
	{
		 return serviceClass.addMoviesList(movieDetails);
	}
}
