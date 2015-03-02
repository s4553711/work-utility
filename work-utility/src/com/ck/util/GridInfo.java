package com.ck.util;

public class GridInfo {

	private String node;
	private String cmd_status;
	private String storage1_status;
	private String storage2_status;
	private String storage3_status;
	
	public GridInfo(){
	}
	
	public GridInfo(String inode, String i_cmd_status, String s1) {
		node = inode;
		cmd_status = i_cmd_status;
		storage1_status = s1;
	}
	
	public String getStor2_status() {
		return storage2_status;
	}

	public void setStor2_status(String s2) {
		if (s2.equals("1")){
			this.storage2_status = "ok";
		} else {
			this.storage2_status = "fail";
		}
	}

	public String getStor3_status() {
		return storage3_status;
	}

	public void setStor3_status(String s3) {
		if (s3.equals("1")){
			this.storage3_status = "ok";
		} else {
			this.storage3_status = "fail";
		}
	}

	public String getStor1_status() {
		return storage1_status;
	}

	public void setStor1_status(String s1) {
		if (s1.equals("1")){
			this.storage1_status = "ok";
		} else {
			this.storage1_status = "fail";
		}
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getCmd_status() {
		return cmd_status;
	}

	public void setCmd_status(String cmd_status) {
		if (cmd_status == "1"){
			this.cmd_status = "fail";
		} else {
			this.cmd_status = "ok";
		}
	}
}
