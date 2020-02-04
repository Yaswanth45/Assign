package com.cts.MP.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;

public class MoviesDaoIOStreamImpl implements IMoviesDao {
	public static final String DATA_STORE_FILE_NAME = "Movies.dat";
	
	private Map<String, Movies> movies;
	
	public MoviesDaoIOStreamImpl() throws MoviesException{
		File file=new File(DATA_STORE_FILE_NAME);
		if (!file.exists()) {
			movies=new TreeMap<>();
		}else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {
				
				Object obj = fin.readObject();
				if (obj instanceof Map) {
					movies = (Map<String, Movies>) obj;
				} else {
					throw new MoviesException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new MoviesException("Loading Data Failed");
			}
		}
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
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(movies);
		} catch (IOException exp) {
			throw new MoviesException("Saving Data Failed");
		}
	}

}
