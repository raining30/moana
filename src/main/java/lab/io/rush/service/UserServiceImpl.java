package lab.io.rush.service;

import java.util.List;

import lab.io.rush.dao.UserDao;
import lab.io.rush.model.User;

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
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Cacheable(key="'userID' + #uid", value="default")
	public User selectUserbyID(int uid){
		return userDao.selectUserById(uid);
	}
	
	@Cacheable(key="'userCount' + #ucount", value="default")
	public User selectUserbyCount(String ucount){
		return userDao.selectUserByCount(ucount);
	}
	
	public int insertUser(User user){
		return userDao.insertUser(user);
	}
	
	@CacheEvict(key="'userCount' + #ucount", value="default")
	public int updateUser(User user){
		return userDao.updateUser(user);
	}
	
	@CacheEvict(key="'userID' + #uid", value="default")
	public int deleteUser(int uid){
		return userDao.deleteUser(uid);
	}
	
	@Cacheable(key="'allUser'", value="default")
	public List<User> selectAll(){
		return userDao.selectAll();
	}

}
