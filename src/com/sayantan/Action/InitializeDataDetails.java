package com.sayantan.Action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sayantan.ActionForm.Gui2FormVars;
import com.sayantan.DAO.ConnectionManager;

public class InitializeDataDetails extends ActionSupport implements
		ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = -7012445214549281834L;
	private Gui2FormVars appFormVars;
	private static final Logger logger = Logger
			.getLogger(InitializeDataDetails.class);
	Connection conn1 = null;
	Connection conn2 = null;
	Statement stmt1 = null;
	Statement stmt2 = null;
	ResultSet rsSectorDataSet = null;
	ResultSet rsEntryDataSet = null;

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		appFormVars = new Gui2FormVars();
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return appFormVars;
	}
	
	@Override
	public String execute() throws Exception {
		// Set seed
		logger.info("RUNNING InitializeDataDetails");
		Gui2FormVars
				.setDoneRFile(String.valueOf(System.currentTimeMillis()));
		logger.info("seed value: " + Gui2FormVars.getDoneRFile());
		Map<String, Object> session = ActionContext.getContext().getSession();
		ArrayList<String> a = new ArrayList<String>();
		String latestEntry = "";

		// queries
		String sectorQuery = "select distinct security from stock_prices order by security";
		String latestEntryQuery = "select date from stock_prices order by date desc limit 1";
		appFormVars.setFlag(0);
		// Retrieve the result set

		conn1 = ConnectionManager.getConnection();
		stmt1 = conn1.createStatement();
		stmt2 = conn1.createStatement();
		
		rsSectorDataSet = stmt1.executeQuery(sectorQuery);
		rsEntryDataSet = stmt2.executeQuery(latestEntryQuery);
		
		// create result lists
		int i = 0;

		while(rsSectorDataSet.next())
		{
			a.add(i, rsSectorDataSet.getString(1));
			i++;
		}
		i=0;
		while(rsEntryDataSet.next())
			latestEntry = rsEntryDataSet.getString(1);
		Collections.sort(a);
		Gui2FormVars.setSecurityList(a);
		Collections.sort(Gui2FormVars.getSecurityList());
		Gui2FormVars.setLatestEntry(latestEntry);
		//session.put("userSeed", Gui2FormVars.getDoneRFile());
		
		return SUCCESS;
	}
}
