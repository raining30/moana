package lab.io.rush.model;

import java.io.Serializable;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月23日
 *
 */

public class Film implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fid;
	private String fname;
	private String fdirector;
	private String factor;
	private String fremark;
	private int fcount;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdirector() {
		return fdirector;
	}
	public void setFdirector(String fdirector) {
		this.fdirector = fdirector;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public int getFcount() {
		return fcount;
	}
	public void setFcount(int fcount) {
		this.fcount = fcount;
	}

}
