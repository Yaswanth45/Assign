package com.cts.MP.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;

public class MovieDaoCollectionsImpl implements IMoviesDao {
	
	private Map<String, Movies> movies;
	public MovieDaoCollectionsImpl() {
		movies =new TreeMap<>();
	}
	
	
	@Override
	public String add(Movies movie) throws MoviesException {
		String id = null;
		if (movie != null) {
			id = movie.getId();
			movies.put(id, movie);	
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws MoviesException {
		boolean isDone = false;
		if (id != null) {
			movies.remove(id);
			isDone = true;
		}
		return isDone;
	}

	@Override
	public Movies get(String id) throws MoviesException {

		return movies.get(id);
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		return new ArrayList<>(movies.values());
	}

	@Override
	public void persist() throws MoviesException {
		// TODO Auto-generated method stub

	}
}
