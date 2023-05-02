package com.jfs.casestudy.movieservice3.movieservice3.Proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jfs.casestudy.movieservice3.movieservice3.Main.MovieDetails;


@FeignClient(name = "Movie-Schedule", url = "http://localhost:8001")
public interface MovieDetailsProxy {
	
	 @GetMapping("/getdetails")
	 public List<MovieDetails> getMovieSchedules();
	
 
}







	
	