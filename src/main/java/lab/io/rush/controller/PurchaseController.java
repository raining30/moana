package lab.io.rush.controller;

import java.util.List;

import lab.io.rush.mail.SendMail;
import lab.io.rush.model.Film;
import lab.io.rush.model.Purchase;
import lab.io.rush.service.FilmService;
import lab.io.rush.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月26日
 *
 */
@Controller
public class PurchaseController {
	@Autowired
	private FilmService filmService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private SendMail sendMail;
	
	@RequestMapping("/selectallfilm")
	@ResponseBody
	public List<Film> selectAllFilm(){
		return filmService.selectAll();
	}
	
	@RequestMapping("/selectfilmbyid")
	@ResponseBody
	public Film selectFilmByID(int fid){
		Film film = filmService.selectFilmById(Integer.valueOf(fid));
		return film;
		//return selectFilmByID(fid);
	}
	
	@RequestMapping("/purchase")
	@ResponseBody
	public 	synchronized int insertPurchase(Purchase purchase){
		int count = selectFilmCount(purchase.getUcount());
		if(count >= 2){
			return 0;
		}else{
			Film film = filmService.selectFilmById(purchase.getFid());
			filmService.updateFilmCount(purchase.getFid(), film.getFcount()-1);
			int result = purchaseService.insertPurchase(purchase);
			sendMail.sendMail(purchase.getUcount());
			return result;
		}
		
	}
	
	private int selectFilmCount(String ucount){
		int count = 0;
		List<Purchase> pList = purchaseService.selectByUcount(ucount);
		count = pList.size();
		return count;
	}

}
