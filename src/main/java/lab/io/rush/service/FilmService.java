package lab.io.rush.service;

import java.util.List;

import lab.io.rush.model.Film;


/***
 * 
 * @author jd.zeng
 * @create date 2016年12月24日
 *
 */

public interface FilmService {
	public Film selectFilmById(int fid);
	public List<Film> selectAll();
	public int insertFilm(Film film);
	public int updateFilmCount(int fid, int fcount);
	public int delectFilm(int fid);

}
