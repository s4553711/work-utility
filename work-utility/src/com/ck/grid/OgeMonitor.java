package com.ck.grid;

import java.util.ArrayList;

import com.ck.util.ConfigHelper;
import com.ck.util.GridInfo;
import com.ck.util.RemoteTool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OgeMonitor {
	private RemoteTool cmd;
	private String ssh_option = "-o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no";
	Logger logger = LoggerFactory.getLogger("app.remote_tool");
	
	public OgeMonitor() {
		cmd = new RemoteTool();
	}

	public void testCMD() {
		String cmdline = "ls -al";
		logger.debug(cmdline);
		//for(String line: cmd.exec(cmdline).split("\n")){
		//	System.out.println("> "+line);
		//}
	}
	
	public ArrayList<GridInfo> testCmdExist() {
		ArrayList<GridInfo> result = new ArrayList<GridInfo>();
		String node_range = ConfigHelper.getProperty("grid_list");
		String cmdline = "for i in {"+node_range+"}; do echo $(ssh "+ssh_option+" node${i}.gp.bioinfo \"which qstat &> /dev/null; echo -n \"${i}:\"$?;"+
							"echo -n $(df -h |grep '"+ConfigHelper.getProperty("grid_storage1")+"'|wc -l);"+
							"echo -n $(df -h |grep '"+ConfigHelper.getProperty("grid_storage2")+"'|wc -l);"+
							"echo -n $(df -h |grep '"+ConfigHelper.getProperty("grid_storage3")+"'|wc -l);\"); done;";

		logger.debug(cmdline);
		for(String line: cmd.exec(cmdline).split("\n") ) {
			if (line.equals("")){
				logger.warn("The status message is empty");
			} else {
				result.add(checkCmd(line));
			}
		}
		return result;
	}
	
	private GridInfo checkCmd(String s) {
		logger.debug(s);
		String[] col = s.split(":");
	
		GridInfo tmp = new GridInfo();
		tmp.setNode(col[0]);
		tmp.setStor3_status(col[1].substring(col[1].length()-1,col[1].length()));
		tmp.setStor2_status(col[1].substring(col[1].length()-2,col[1].length()-1));
		tmp.setStor1_status(col[1].substring(col[1].length()-3,col[1].length()-2));
		tmp.setCmd_status(col[1].substring(col[1].length()-4,col[1].length()-3));
		
		return tmp;
	}
}
