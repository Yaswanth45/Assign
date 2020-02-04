package com.cts.MP.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;
import com.cts.MP.util.ConectionProvider;

public class MoviesDaoJDBCImpl implements IMoviesDao {
	
	ConectionProvider conProvider;
	

	public MoviesDaoJDBCImpl() throws MoviesException{
		try {
			conProvider=ConectionProvider.getInstance();
		}catch(ClassNotFoundException | IOException exp) {
			throw new MoviesException("Database is not reachable");
		} 
	}

	@Override
	public String add(Movies movie) throws MoviesException {
		String id = null;
		if (movie != null) {
			try (Connection con = conProvider.getConnection();
					PreparedStatement pInsert = con
							.prepareStatement(IQueryMapper.ADD_MOVIES_QRY)) {

				pInsert.setString(1, movie.getId());
				pInsert.setString(2, movie.getTitle());
				pInsert.setString(3, movie.getHero());
				pInsert.setDouble(4, movie.getCollections());
				pInsert.setDate(5, Date.valueOf(movie.getReleaseDate()));

				int rowCount = pInsert.executeUpdate();

				if (rowCount == 1) {
					id = movie.getId();
				}
			}catch(SQLException e) {
				throw new MoviesException("Movie is not inserted"+e);
			}
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws MoviesException {
		boolean isDone = false;

		try (Connection con = conProvider.getConnection();
				PreparedStatement pDelete = con
						.prepareStatement(IQueryMapper.DEL_MOVIES_QRY)) {

			pDelete.setString(1, id);

			int rowCount = pDelete.executeUpdate();

			if (rowCount == 1) {
				isDone = true;
			}
		} catch (SQLException exp) {
			throw new MoviesException("Movie is not inserted");
		}

		return isDone;
	}

	@Override
	public Movies get(String id) throws MoviesException {
		Movies movie=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_MOVIE_QRY)) {

			pSelect.setString(1, id);

			ResultSet rs = pSelect.executeQuery();
			
			if(rs.next()){
				movie = new Movies();
				movie.setId(rs.getString("id"));
				movie.setTitle(rs.getString("title"));
				movie.setHero(rs.getString("hero"));
				movie.setCollections(rs.getDouble("collections"));
				movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
			}
			
		} catch (SQLException exp) {
			throw new MoviesException("Movie is not available");
		}	
		return movie;
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		List<Movies> movies=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_ALL_MOVIES_QRY)) {

			ResultSet rs = pSelect.executeQuery();
			
			movies = new ArrayList<Movies>();
			
			while(rs.next()){
				Movies movie = new Movies();
				movie.setId(rs.getString("id"));
				movie.setTitle(rs.getString("title"));
				movie.setHero(rs.getString("hero"));
				movie.setCollections(rs.getDouble("collections"));
				movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
				movies.add(movie);
			}
			
		} catch (SQLException exp) {
			
			throw new MoviesException("No Movies are available.");
		}		
		return movies;	
	}

	@Override
	public void persist() throws MoviesException {
		// TODO Auto-generated method stub

	}

}
