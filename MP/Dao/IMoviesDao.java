package com.cts.MP.Dao;

import java.util.List;

import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;

public interface IMoviesDao {
	String add(Movies movie) throws MoviesException;
	boolean delete(String id) throws MoviesException;
	Movies get(String id) throws MoviesException;
	List<Movies> getAll() throws MoviesException;
	void persist()throws MoviesException;
}