package lab.io.rush.service;

import java.util.List;

import lab.io.rush.dao.PurchaseDao;
import lab.io.rush.model.Purchase;

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
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Cacheable(key="'purchaseID' + #pid", value="default")
	public Purchase selectPurchaseById(int pid){
		return purchaseDao.selectPurchaseById(pid);
	}
	
	@Cacheable(key="'purchaseCount' + #ucount", value="default")
	public List<Purchase> selectByUcount(String ucount){
		return purchaseDao.selectByUcount(ucount);
	}
	
	public int insertPurchase(Purchase purchase){
		return purchaseDao.insertPurchase(purchase);
	}
	
	@CacheEvict(key="'purchaseCount' + #ucount", value="default")
	public int delectPurchase(int pid){
		return purchaseDao.delectPurchase(pid);
	}

}
