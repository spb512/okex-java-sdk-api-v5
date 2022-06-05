package com.okex.open.api.bean.sub.account.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:01:45
 *
 */
public class CreateSubAccountApikey {
	private String pwd;
	private String subAcct;
	private String label;
	private String passphrase;
	private String perm;
	private String ip;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSubAcct() {
		return subAcct;
	}

	public void setSubAcct(String subAcct) {
		this.subAcct = subAcct;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "CreateSubAccountApikey{" + "pwd='" + pwd + '\'' + ", subAcct='" + subAcct + '\'' + ", label='" + label
				+ '\'' + ", passphrase='" + passphrase + '\'' + ", perm='" + perm + '\'' + ", ip='" + ip + '\'' + '}';
	}
}
