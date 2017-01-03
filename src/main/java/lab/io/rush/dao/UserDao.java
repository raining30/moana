package lab.io.rush.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lab.io.rush.model.User;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public interface UserDao {
	
	/***
	 * 
	 * @param uid
	 * @return User
	 */
	public User selectUserById(Integer uid);
	
	/***
	 * 
	 * @param ucount
	 * @return User
	 */
	public User selectUserByCount(@Param("ucount")String ucount);
	
	/***
	 * 
	 * @param ucount
	 * @param upassword
	 * @return int
	 */
	public int insertUser(User user);
	
	/***
	 * 
	 * @param user
	 * @return int
	 */
	public int updateUser(User user);
	
	/***
	 * 
	 * @param uid
	 * @return int
	 */
	public int deleteUser(@Param("uid")int uid);
	
	/***
	 * 
	 * @return list<User>
	 */
	public List<User> selectAll();

}
