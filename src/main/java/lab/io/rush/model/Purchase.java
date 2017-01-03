package lab.io.rush.model;

import java.io.Serializable;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public class Purchase implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1076678917799854461L;
	private int pid;
	private String ucount;
	private int fid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUcount() {
		return ucount;
	}
	public void setUcount(String ucount) {
		this.ucount = ucount;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}

}
