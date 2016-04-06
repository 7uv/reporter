package com.sayantan.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sayantan.ActionForm.Gui2FormVars;
import com.sayantan.DAO.ConnectionManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AccessDeptDetails extends ActionSupport implements
		ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = -7012445214549281834L;
	private Gui2FormVars appFormVars;
	private static final Logger logger = Logger
			.getLogger(AccessDataDetails.class);
	Connection conn1 = null;
	Statement stmt1 = null;
	ResultSet rsDeptDataSet = null;

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
		logger.info("RUNNING AccessDeptDetails");
		Gui2FormVars
				.setDoneRFile(String.valueOf(System.currentTimeMillis()));
		logger.info("seed value: " + Gui2FormVars.getDoneRFile());
		Map<String, Object> session = ActionContext.getContext().getSession();
		HashMap<Integer, String> a = new HashMap<Integer, String>();
		
		// queries
		String deptQuery = "select distinct dept from stock_inventory where lob_head = '" + Gui2FormVars.getLlobList().get(
				Integer.parseInt(appFormVars.getLlob())) + "' order by dept";

		// Retrieve the result set
		conn1 = ConnectionManager.getConnection();
		stmt1 = conn1.createStatement();
		
		rsDeptDataSet = stmt1.executeQuery(deptQuery);

		// create result lists
		int i = 1;
		a.put(0, "All");

		while(rsDeptDataSet.next())
		{
			a.put(i, rsDeptDataSet.getString(1));
			i++;
		}

		//Gui2FormVars.setDeptList(a);
		Gui2FormVars.setSn(appFormVars.getDept());
		
		session.put("deptNo", appFormVars.getDept());
		session.put("userSeed", Gui2FormVars.getDoneRFile());

		return SUCCESS;
	}
}
