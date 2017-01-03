package lab.io.rush.service;

import java.util.List;

import lab.io.rush.model.Purchase;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月24日
 *
 */

public interface PurchaseService {
	public Purchase selectPurchaseById(int pid);
	public List<Purchase> selectByUcount(String ucount);
	public int insertPurchase(Purchase purchase);
	public int delectPurchase(int pid);

}
