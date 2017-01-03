package lab.io.rush.service;

import java.util.List;

import lab.io.rush.dao.FilmDao;
import lab.io.rush.model.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月24日
 *
 */

@Service
public class FilmServiceImpl implements FilmService{
	@Autowired
	private FilmDao filmDao;
	
	@Cacheable(key="'filmID' + #fid", value="default")
	public Film selectFilmById(int fid){
		Film film = filmDao.selectFilmById(fid);
		return film;
	}
	
	@Cacheable(key="'selectAllFilm'", value="default")
	public List<Film> selectAll(){
		return filmDao.selectAll();
	}
	
	@CacheEvict(key="'selectAllFilm'", value="default")
	public int insertFilm(Film film){
		return filmDao.insertFilm(film);
	}
	
	@CacheEvict(key="'selectAllFilm'", value="default", allEntries = true)
	public int updateFilmCount(int fid, int fcount){
		return filmDao.updateFilmCount(fid, fcount);
	}
	
	@CacheEvict(key="'filmID' + #fid", value="default", allEntries = true)
	public int delectFilm(int fid){
		return filmDao.delectFilm(fid);
	}

}
