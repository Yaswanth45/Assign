package com.cts.MP.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.cts.MP.Services.IMoviesServices;
import com.cts.MP.Services.MovieServices;
import com.cts.MP.Services.MoviesCollectionsComparator;
import com.cts.MP.Services.MoviesHeroComparator;
import com.cts.MP.Services.MoviesReleaseComparator;
import com.cts.MP.Services.MoviesTitleComparator;
import com.cts.MP.exception.MoviesException;
import com.cts.MP.model.Movies;
import com.cts.MP.model.MoviesAppMenu;

public class MoviesManagement {
	private static IMoviesServices movieService;
	private static Scanner scan;
	private static DateTimeFormatter dtFormater;
	private static List<Movies> movies;
	public MoviesManagement() {
		movies =new ArrayList<>();
	}

	public static void main(String[] args) {
		try {
			movieService = new MovieServices();
		} catch (MoviesException e) {
			e.printStackTrace();
		}
		
		scan = new Scanner(System.in);
		dtFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		MoviesAppMenu menu=null;
		
		while(menu !=MoviesAppMenu.QUIT) {
			System.out.println("Choice\tMenu Item");
			System.out.println("===========================");
			for (MoviesAppMenu m : MoviesAppMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			int choice = -1;
			if (scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Pleae choose a choice displayed");
				continue;
			}
			if (choice < 0 || choice >= MoviesAppMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = MoviesAppMenu.values()[choice];
				switch (menu) {
				case ADD:
					doadd();
					break;
				case SHOW:
					doShow();
					break;
				case SEARCH:
					doSearch();
					break;
				case DELETE:
					doRemove();
					break;
				case MOVIES_TITLEWISE:
					doTitle();
					break;
				case MOVIES_HEROWISE:
					doHero();
					break;
				case MOVIES_RELEASE_DATEWISE:
					doDate();
					break;
				case COLLECTIONSWISE:
					doCollection();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
		}
	}
		scan.close();
		try {
			movieService.persist();
		} catch (MoviesException e) {
			e.printStackTrace();
		}

	}
	private static void doadd() {
		try {
			Movies movie = new Movies();
			System.out.print("Id: ");
			movie.setId(scan.next());
			System.out.print("Title: ");
			movie.setTitle(scan.next());
			System.out.println("Hero Name:");
			movie.setHero(scan.next());
			System.out.print("ReleaseDate(dd-MM-yyyy): ");
			String releaseDate = scan.next();

			try {
				movie.setReleaseDate(LocalDate.parse(releaseDate, dtFormater));
			} catch (DateTimeException exp) {
				throw new MoviesException(
						"Date must be in the format day(dd)-month(MM)-year(yyyy)");
			}
			System.out.print("Collections: ");
			if (scan.hasNextDouble())
				movie.setCollections(scan.nextDouble());
			else {
				scan.next();
				throw new MoviesException("Collections is a number");
			}

			String id = movieService.add(movie);
			System.out.println("Movie is Added with code: " + id);
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doShow() {
		List<Movies> movie;
		try {
			movie = movieService.getAll();
			if (movie.size() == 0) {
				System.out.println("No Movies To display");
			} else {
				for (Movies b : movie)
					System.out.println(b);
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doSearch() {
		System.out.print("Id: ");
		String id = scan.next();

		try {
			Movies movie = movieService.get(id);
			if (movie != null) {
				System.out.println(movie);
			} else {
				System.out.println("No Such Movie");
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doRemove() {
		System.out.print("Id: ");
		String id = scan.next();
		try {
			boolean isDone = movieService.delete(id);
			if (isDone) {
				System.out.println("Movie is Deleted");
			} else {
				System.out.println("No Such Movie");
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doTitle() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
					Collections.sort( movies,new MoviesTitleComparator());
					System.out.println("Movie list sorted according to their Titles:");
					for(Movies m: movies)
						System.out.println(m);
					System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doHero() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
					Collections.sort(movies, new MoviesHeroComparator());
					for(Movies m : movies) {
						System.out.println(m);
					}
					System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doDate() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
				Collections.sort(movies, new MoviesReleaseComparator());
				for(Movies movie : movies) {
					System.out.println(movie);
				}
				System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doCollection() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
		Collections.sort(movies, new MoviesCollectionsComparator());
		for(Movies movie : movies) {
			System.out.println(movie);
			}
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
	}
	}
}
