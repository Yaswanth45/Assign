package com.cts.MP.Services;

import java.util.Comparator;

import com.cts.MP.model.Movies;

public class MoviesCollectionsComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies m1, Movies m2) {
		return (int) (m1.getCollections()-m2.getCollections());
	}

}
