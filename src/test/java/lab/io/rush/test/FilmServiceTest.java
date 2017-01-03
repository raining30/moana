package lab.io.rush.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lab.io.rush.base.SpringTestCase;
import lab.io.rush.model.Film;
import lab.io.rush.service.FilmService;

public class FilmServiceTest extends SpringTestCase{
	@Autowired
	private FilmService filmService;
	
	//@Test
	public void insertFilmTest() {
		Film film = new Film();
		film.setFname("疯狂动物城");
		film.setFdirector("里奇·摩尔、拜恩·霍华德、杰拉德·布什");
		film.setFactor("金妮弗·古德温，杰森·贝特曼，夏奇拉，"
				+ "伊德里斯·艾尔巴，艾伦·图代克，J·K·西蒙斯 ");
		film.setFremark("一个现代化的动物都市，每种动物在这里都有自己的居所，"
				+ "有沙漠气候的撒哈拉广场、常年严寒的冰川镇等等，"
				+ "它就像一座大熔炉，动物们在这里和平共处——无论是大象还是小老鼠，"
				+ "只要努力，都能闯出一番名堂...");
		film.setFcount(300);
		filmService.insertFilm(film);
		System.out.println("insert succeed!");

	}
	
	//@Test
	public void selectFilmTest(){
		System.out.println("start select...");
		Film film = filmService.selectFilmById(1);
		System.out.println(film.getFname());
		System.out.println(film.getFdirector());
		System.out.println(film.getFactor());
		System.out.println(film.getFremark());
		System.out.println(film.getFcount());
		System.out.println("end...");
	}
	
	//@Test
	public void selectAllTest(){
		System.out.println("start selectAll...");
		List<Film> films = filmService.selectAll();
		for(Film atom : films){
			System.out.println(atom.getFname());
		}
		System.out.println("end...");
	}
	
	@Test
	public void updateCountTest(){
		System.out.println("start update...");
		filmService.updateFilmCount(1, 300);
		selectFilmTest();
		System.out.println("end...");
	}
	
	//@Test
	public void delectFilmTest(){
		System.out.println("start delete...");
		//insertFilmTest();
		filmService.delectFilm(2);
		selectAllTest();
		System.out.println("end...");
	}

}
