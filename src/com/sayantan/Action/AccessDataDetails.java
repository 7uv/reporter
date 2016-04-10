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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccessDataDetails extends ActionSupport implements
		ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = -7012445214546281834L;
	Map<String, Object> session = ActionContext.getContext().getSession();
    ArrayList<Double> lcp = new ArrayList<Double>();

	private Gui2FormVars appFormVars;
	private static final Logger logger = Logger
			.getLogger(AccessDataDetails.class);
	ArrayList<String> securityValuesq = new ArrayList<String>();

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
		logger.info("RUNNING AccessDataDetails");

		// Create the query
		// user filters
		String dataDetailsQuery = " ";

		// table list
		dataDetailsQuery += "select * from reports.stock_inventory rsi ";

		if(!appFormVars.getDept().equals("All")) {
            dataDetailsQuery += "WHERE rsi.dept = '" + appFormVars.getDept() + "'";
        }

		// output limit
		dataDetailsQuery += " limit 100 ";

		logger.info("data Access Query: " + dataDetailsQuery);

		// test query
		String testQuery = "select * from stock_inventory where dept = 'IT' limit 100";

		// Retrieve the result set
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsDataSet = null;

		conn = ConnectionManager.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		// rsDataSet = stmt.executeQuery(dataDetailsQuery);
		rsDataSet = stmt.executeQuery(dataDetailsQuery);

		// create result lists
		int i = 0;
		
		HashMap<Integer, Integer> id = new HashMap<>();
		HashMap<Integer, Date> fromDate = new HashMap<>();
		HashMap<Integer, Date> toDate = new HashMap<>();
		HashMap<Integer, String> dept = new HashMap<>();
		HashMap<Integer, String> lobHead = new HashMap<>();
		HashMap<Integer, String> itemType = new HashMap<>();
		HashMap<Integer, String> itemForm = new HashMap<>();
		HashMap<Integer, String> isbn = new HashMap<>();

		HashMap<Integer, Double> price = new HashMap<>();
		HashMap<Integer, String> curr = new HashMap<>();
		HashMap<Integer, Integer> qnty = new HashMap<>();

		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<String> secLink = new ArrayList<String>();
		ArrayList<Double> lcp = new ArrayList<Double>();
		ArrayList<AccessDataDetails> stockValues = new ArrayList<AccessDataDetails>();

		ResultSetMetaData rsmd = rsDataSet.getMetaData();
		int numColumns = rsmd.getColumnCount();

		// Get the column names; column indices start from 1
		for (int ia = 0; ia < numColumns; ia++)
			columnName.add(rsmd.getColumnName(ia + 1));
		// System.out.println(columnName.get(3));

		while (rsDataSet.next()) {
			id.put(i, rsDataSet.getInt(1));
            fromDate.put(i, rsDataSet.getDate(2));

			++i;
		}

        rsDataSet.beforeFirst();

        while (rsDataSet.next()) {
            secLink.add(rsDataSet.getString(1));

            lcp.add(Double.parseDouble(rsDataSet.getString(1)));
        }

		Gui2FormVars.setIdMap(id);
        Gui2FormVars.setFromDateMap(fromDate);
        Gui2FormVars.setToDateMap(toDate);
        Gui2FormVars.setDeptMap(dept);
        Gui2FormVars.setLlobMap(lobHead);
        Gui2FormVars.setItemTypeMap(itemType);
        Gui2FormVars.setItemFormMap(itemForm);
        Gui2FormVars.setIsbnMap(isbn);
        Gui2FormVars.setPriceMap(price);
        Gui2FormVars.setCurrMap(curr);
        Gui2FormVars.setQntyMap(qnty);

		System.out.println("list size: " + appFormVars.getIdMap().size());
		// securityValues.addAll(security.values());
        appFormVars.setSecLink(secLink);
        appFormVars.setLcp(lcp);

        System.out.println("list size: " + appFormVars.getSecLink().size());
        // securityValues.addAll(security.values());
        session.put("secVal", secLink);
        session.put("sec", id);
		session.put("serial", serialVersionUID);
		return SUCCESS;
	}

}
