package lab.io.rush.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lab.io.rush.base.SpringTestCase;
import lab.io.rush.model.Purchase;
import lab.io.rush.service.PurchaseService;

public class PurchaseServiceTest extends SpringTestCase{
	@Autowired
	private PurchaseService purchaseService;
	
	//@Test
	public void insertPurchaseTest(){
		System.out.println("insert start...");
		Purchase purchase = new Purchase();
		purchase.setFid(1);
		purchase.setUcount("rain");
		purchaseService.insertPurchase(purchase);
		System.out.println("insert end...");
	}
	
	@Test
	public void selectIDTest(){
		System.out.println("select by id start...");
		Purchase purchase = purchaseService.selectPurchaseById(1);
		System.out.println("fid: " + purchase.getFid());
		System.out.println("ucount: " + purchase.getUcount());
		System.out.println("select id end...");
	}
	
	@Test
	public void selectCountTest(){
		System.out.println("select count start...");
		List<Purchase> purchases = purchaseService.selectByUcount("rain");
		for(Purchase atom : purchases){
			System.out.println(atom.getUcount() + "\t" + atom.getFid());
		}
		System.out.println("select count end...");
	}
	
	@Test
	public void deletePurchaseTest(){
		System.out.println("delete start...");
		System.out.println("delect end...");
	}

}
