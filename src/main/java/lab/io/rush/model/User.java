package lab.io.rush.model;

import java.io.Serializable;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7686167352273997762L;
	private int uid;
	private String ucount;
	private String upassword;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUcount() {
		return ucount;
	}
	public void setUcount(String ucount) {
		this.ucount = ucount;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
}
