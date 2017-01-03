package lab.io.rush.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lab.io.rush.model.Purchase;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public interface PurchaseDao {
	public Purchase selectPurchaseById(@Param("pid")int pid);
	public List<Purchase> selectByUcount(@Param("ucount")String ucount);
	public int insertPurchase(Purchase purchase);
	public int delectPurchase(@Param("pid")int pid);

}
