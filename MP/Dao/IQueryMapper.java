package com.cts.MP.Dao;

public interface IQueryMapper {
	public static final String ADD_MOVIES_QRY=
			"INSERT INTO movies(id,title,hero,collections,releaseDate) values(?,?,?,?,?) ";
	public static final String DEL_MOVIES_QRY=
			"DELETE FROM movies WHERE id=?";
	public static final String GET_ALL_MOVIES_QRY=
			"SELECT * FROM movies";
	public static final String GET_MOVIE_QRY=
			"SELECT * FROM movies WHERE id=?";

}
