package com.cts.MP.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.cts.MP.Dao.IMoviesDao;
import com.cts.MP.Dao.MovieDaoCollectionsImpl;
import com.cts.MP.Dao.MoviesDaoIOStreamImpl;
import com.cts.MP.Dao.MoviesDaoJDBCImpl;
import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;

public class MovieServices implements IMoviesServices {

	private IMoviesDao movieDao;

	public IMoviesDao getDAO(){
		return movieDao;
	}
	
	public MovieServices() throws MoviesException{
		 //movieDao = new MovieDaoCollectionsImpl();
		//movieDao = new MoviesDaoIOStreamImpl();
		movieDao =new MoviesDaoJDBCImpl();
	}
	
	public boolean isValidId(String id){
		
		/*
		 * First letter must be a digit
		 * Followed by three digits
		 */
		Pattern idPattern = Pattern.compile("[1-9]\\d{3}");
		Matcher idMatcher = idPattern.matcher(id);
		
		return idMatcher.matches();
	}
	
	public boolean isValidTitle(String title){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern titlePattern = Pattern.compile("[A-Z]\\w{3,10}");
		Matcher titleMatcher = titlePattern.matcher(title);
		
		return titleMatcher.matches();
	}
	
	public boolean isValidHero(String hero){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 15 chars.		
		 */
		Pattern heroPattern = Pattern.compile("[A-Z]\\w{3,15}");
		Matcher heroMatcher = heroPattern.matcher(hero);
		
		return heroMatcher.matches();
	}
	public boolean isValidCollections(double Collections){
		/*
		 * Price is between 100000 and 5000000
		 */
		return Collections>=100000 && Collections<=500000;
	}
	
	public boolean isValidReleaseDate(LocalDate releaseDate){
		/*
		 * publish date should not be greater than the current day.
		 */
		LocalDate today = LocalDate.now();
		//return publishDate.isBefore(today) || publishDate.equals(today);
		return today.isAfter(releaseDate) || releaseDate.equals(today);
	}
	
	public boolean isValidMovie(Movies movie) throws MoviesException{
		boolean isValid=false;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(!isValidId(movie.getId()))
			errMsgs.add("id should start with a digit followed by 3 digits");
		
		if(!isValidTitle(movie.getTitle()))
			errMsgs.add("Title must start with capital and must be in between 4 to 10 chars in length");
		
		if(!isValidHero(movie.getHero()))
			errMsgs.add("Hero name Should start with capital and must be in between 4 to 15 chars in length");
		
		if(!isValidCollections(movie.getCollections()))
			errMsgs.add("Collections must be between INR.100000 and INR.5000000");
		
		if(!isValidReleaseDate(movie.getReleaseDate()))
			errMsgs.add("Release Date should not be a future date");
		
		if(errMsgs.size()==0)
			isValid=true;
		else
			throw new MoviesException(errMsgs.toString());
		
		return isValid;
	}
	@Override
	public String add(Movies movie) throws MoviesException {
		String id=null;
		if(movie!=null && isValidMovie(movie)){
			id=movieDao.add(movie);
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws MoviesException {
			boolean isDone=false;
			if(id!=null && isValidId(id)){
				movieDao.delete(id);
				isDone = true;
			}else{
				throw new MoviesException("id will be 4 digits");
			}
			return isDone;
	}
	
	@Override
	public Movies get(String id) throws MoviesException {
		return movieDao.get(id);
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		return movieDao.getAll();
	}
	@Override
	public void persist() throws MoviesException {
		movieDao.persist();

	}


}
