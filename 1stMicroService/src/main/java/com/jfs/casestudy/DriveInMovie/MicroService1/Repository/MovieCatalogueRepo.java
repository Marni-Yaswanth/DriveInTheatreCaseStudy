package com.jfs.casestudy.DriveInMovie.MicroService1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.casestudy.DriveInMovie.MicroService1.Main.Movie;


@Repository
public interface MovieCatalogueRepo extends JpaRepository<Movie, String> {

}
