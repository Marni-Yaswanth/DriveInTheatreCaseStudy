package com.jfs.casestudy.DriveInMovie.MicroService1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.casestudy.DriveInMovie.MicroService1.Main.Movie;
import com.jfs.casestudy.DriveInMovie.MicroService1.Service.MovieCatalogueService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
public class MovieCatalogueController {
	
	@Autowired
	private MovieCatalogueService service;
	
	
	@Operation(summary="This mapping is used to view all the movies")
	@ApiResponses(value= {
	@ApiResponse(responseCode = "200",description = "Fetched all movies and viewed",
					content = {@Content(mediaType = "application/json")}),
	@ApiResponse(responseCode = "404",description = "Error Fetching the movies",content = @Content),
	@ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content)})
	@GetMapping("/viewmovies")
	public List<String> viewAllMovieTitles()
	{
		return service.viewAllMovieTitles();
	}
	
	@GetMapping("/searchmovie/{title}")
	public Movie searchMovieDetailsByTitle(@PathVariable("title") String title)
	{
		return service.searchMovieDetailsByTitle(title);
	}
	
	@PostMapping("/addmovie")
	public void addMovie(@RequestBody Movie movie) 
	{
		service.addMovie(movie);
	}
	
	@PutMapping("/updatemovie/{title}")
	public void updateMovieDetailsByTitle(@PathVariable("title") String title, @RequestBody Movie movie)
	{
		service.updateMovieDetailsByTitle(title, movie);
	}
	
	@DeleteMapping("/deletemovie/{title}")
	public void deleteMovieDetailsByTitle(@PathVariable("title") String title)
	{
		service.deleteMovieDetailsByTitle(title);
	}

}
