package lab.io.rush.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lab.io.rush.model.User;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月24日
 *
 */

public interface UserService {
	User selectUserbyID(int uid);
	User selectUserbyCount(String ucount);
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(@Param("uid")int uid);
	List<User> selectAll();

}
