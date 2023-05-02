package com.microservices.CaseStudy.DriveInMovie.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.CaseStudy.DriveInMovie.Service.MovieScheduleService;
import com.microservices.CaseStudy.DriveInMovie.exception.InvalidMovieFound;
import com.microservices.CaseStudy.DriveInMovie.movieclass.Movie1;

@RestController

public class MovieScheduleController {

    @Autowired
    private MovieScheduleService movieScheduleService;

   
    @PostMapping("/add")
    public String addMovieSchedule1(@RequestBody Movie1 movie1) throws InvalidMovieFound {
        return movieScheduleService.addMovieSchedule(movie1);
    }


  
    @PutMapping("/update/{title}")
    public String updateMovieSchedule(@PathVariable("title") String title, 
                                                       @RequestBody Movie1 movie1)throws InvalidMovieFound {
    	return movieScheduleService.updateMovieSchedule(title, movie1); 
    }

    
    @GetMapping("/get/{title}")
    public Movie1 getMovieSchedule(@PathVariable("title")  String title) {
        return movieScheduleService.getMovieSchedule(title);
    }


    @DeleteMapping("/delete/{title}")
    public String removeMovieSchedule(@PathVariable("title") String title) throws InvalidMovieFound{
        return movieScheduleService.deleteMovieSchedule(title);
       
    }
    
//    @GetMapping("/getdetails")
//    public List<Movie1> getMovieSchedules() {
//        return movieScheduleService.getMovieSchedules();
//    }
    
    
}
