package lab.io.rush.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lab.io.rush.model.Film;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public interface FilmDao {
	public Film selectFilmById(@Param("fid")int fid);
	public List<Film> selectAll();
	public int insertFilm(Film film);
	public int updateFilmCount(@Param("fid")int fid, 
			@Param("fcount")int fcount);
	public int delectFilm(@Param("fid")int fid);

}
