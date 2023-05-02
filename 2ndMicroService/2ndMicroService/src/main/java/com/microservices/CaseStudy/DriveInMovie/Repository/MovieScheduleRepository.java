package com.microservices.CaseStudy.DriveInMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.CaseStudy.DriveInMovie.movieclass.Movie1;

@Repository
public interface MovieScheduleRepository extends JpaRepository<Movie1, String>  {

}
