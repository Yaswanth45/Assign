package com.cts.MP.Services;

import java.util.Comparator;

import com.cts.MP.model.Movies;

public  class MoviesTitleComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies m1, Movies m2) {
		return m1.getTitle().compareTo(m2.getTitle());
	}

}
