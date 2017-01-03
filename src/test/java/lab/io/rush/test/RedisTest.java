package lab.io.rush.test;

import lab.io.rush.base.SpringTestCase;
import lab.io.rush.redis.RedisCache;

import org.junit.Before;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.cache.CacheManager;  


public class RedisTest extends SpringTestCase{
	private RedisCache cache;  

    @Autowired  
    private CacheManager manager;  

      

    @Before  
    public void before() {  
        cache = (RedisCache) manager.getCache("default");  
    }  

      

    @Test  
    public void testAdd() throws Exception {  
        cache.put("test", 1);  
    }  

      

    @Test  
    public void testGet() throws Exception {  
        System.out.println(cache.get("test").get());  
    }  

      

    @Test  
    public void testEvict() throws Exception {  
        cache.evict("test");  
    }  

      

    @Test  
    public void testClear() throws Exception {  
        cache.clear();  
    }  

}
