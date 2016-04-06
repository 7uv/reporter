package com.sayantan.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sayantan.ActionForm.Gui2FormVars;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;

public class CopyOfAccessDataDetails extends ActionSupport implements
		ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = -7012445214546281834L;
	Map<String, Object> session = ActionContext.getContext().getSession();

	private Gui2FormVars appFormVars;
	private static final Logger logger = Logger
			.getLogger(CopyOfAccessDataDetails.class);
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
/*

		// Create the query
		// user filters
		String dataDetailsQuery = " ";
		dataDetailsQuery += "select distinct sm.security, sp.close, sm.market_cap ";
		if (appFormVars.isHv1())
			dataDetailsQuery += ",hv.hv10 ";
		if (appFormVars.isHv2())
			dataDetailsQuery += ",hv.hv20 ";
		if (appFormVars.isHv3())
			dataDetailsQuery += ",hv.hv60 ";
		if (appFormVars.isHv4())
			dataDetailsQuery += ",hv.hv120 ";
		if (appFormVars.isHv5())
			dataDetailsQuery += ",hv.hv250 ";

		if (appFormVars.isBd1())
			dataDetailsQuery += ",db.betadaily20 ";
		if (appFormVars.isBd2())
			dataDetailsQuery += ",db.betadaily60 ";
		if (appFormVars.isBd3())
			dataDetailsQuery += ",db.betadaily120 ";
		if (appFormVars.isBd4())
			dataDetailsQuery += ",db.betadaily250 ";

		if (appFormVars.isBdu1())
			dataDetailsQuery += ",db.betadaily60up ";
		if (appFormVars.isBdu2())
			dataDetailsQuery += ",db.betadaily120up ";
		if (appFormVars.isBdu3())
			dataDetailsQuery += ",db.betadaily250up ";

		if (appFormVars.isBdd1())
			dataDetailsQuery += ",db.betadaily60down ";
		if (appFormVars.isBdd2())
			dataDetailsQuery += ",db.betadaily120down ";
		if (appFormVars.isBdd3())
			dataDetailsQuery += ",db.betadaily250down ";

		if (appFormVars.isCor1())
			dataDetailsQuery += ",db.corr10 ";
		if (appFormVars.isCor2())
			dataDetailsQuery += ",db.corr20 ";
		if (appFormVars.isCor3())
			dataDetailsQuery += ",db.corr40 ";
		if (appFormVars.isCor4())
			dataDetailsQuery += ",db.corr60 ";
		if (appFormVars.isCor5())
			dataDetailsQuery += ",db.corr120 ";
		if (appFormVars.isCor6())
			dataDetailsQuery += ",db.corr250 ";

		if (appFormVars.isWb1())
			dataDetailsQuery += ",wb.betaweekly20 ";
		if (appFormVars.isWb2())
			dataDetailsQuery += ",wb.betaweekly60 ";
		if (appFormVars.isWb3())
			dataDetailsQuery += ",wb.betaweekly120 ";
		if (appFormVars.isWb4())
			dataDetailsQuery += ",wb.betaweekly250 ";

		if (appFormVars.isBwu1())
			dataDetailsQuery += ",wb.betaweekly60up ";
		if (appFormVars.isBwu2())
			dataDetailsQuery += ",wb.betaweekly120up ";
		if (appFormVars.isBwu3())
			dataDetailsQuery += ",wb.betaweekly250up ";

		if (appFormVars.isBwd1())
			dataDetailsQuery += ",wb.betaweekly60down ";
		if (appFormVars.isBwd2())
			dataDetailsQuery += ",wb.betaweekly120down ";
		if (appFormVars.isBwd3())
			dataDetailsQuery += ",wb.betaweekly250down ";

		if (appFormVars.isBm1())
			dataDetailsQuery += ",mb.betamonthly60 ";
		if (appFormVars.isBm2())
			dataDetailsQuery += ",mb.betamonthly120 ";
		if (appFormVars.isBm3())
			dataDetailsQuery += ",mb.betamonthly250 ";

		if (appFormVars.isBmu1())
			dataDetailsQuery += ",mb.betamonthly60up ";
		if (appFormVars.isBmu2())
			dataDetailsQuery += ",mb.betamonthly120up ";
		if (appFormVars.isBmu3())
			dataDetailsQuery += ",mb.betamonthly250up ";

		if (appFormVars.isBmd1())
			dataDetailsQuery += ",mb.betamonthly60down ";
		if (appFormVars.isBmd2())
			dataDetailsQuery += ",mb.betamonthly120down ";
		if (appFormVars.isBmd3())
			dataDetailsQuery += ",mb.betamonthly250down ";
		// table list
		dataDetailsQuery += " from security_master sm, stock_prices sp, historical_volatility hv, daily_beta db, weekly_beta wb, monthly_beta mb ";

		dataDetailsQuery += "WHERE ";
		// basic where clause
		dataDetailsQuery += "sm.security=sp.security and sm.security=hv.security and sm.security=db.security and sm.security=wb.security and sm.security=mb.security ";
		// user params
		dataDetailsQuery += " and sm.sector='"
				+ TradeAppFormVars.getSectorList().get(
						Integer.parseInt(appFormVars.getSector()))
				+ "' and sm.sub_sector='" 
				+ TradeAppFormVars.getSubSectorList().get(
						Integer.parseInt(appFormVars.getSubSector()))
				+ "' and sm.market_cap between '" + appFormVars.getMarketcap1()
				+ "' and '" + appFormVars.getMarketcap2() + "' and sp.date = '"
				+ appFormVars.getFromDate() + "' and hv.date = '"
				+ appFormVars.getFromDate() + "' and db.date = '"
				+ appFormVars.getFromDate() + "' and wb.date = '"
				+ appFormVars.getFromDate() + "' and mb.date = '"
				+ appFormVars.getFromDate() + "'";
		*/
/*
		 * if(appFormVars.isFno()) dataDetailsQuery +=
		 * " and sm.indices='FUTSTK' "; if(appFormVars.isNstocks())
		 * dataDetailsQuery += " and sm.indices=' ' ";
		 *//*

		// output limit
		// dataDetailsQuery += " limit 100 ";

		System.out.println("data Access Query: " + dataDetailsQuery);
		logger.info("data Access Query: " + dataDetailsQuery);

		// test query
		String testQuery = "select distinct sm.security, sp.close, sm.market_cap from security_master sm, stock_prices sp, historical_volatility hv WHERE sm.security=sp.security and sm.security=hv.security   and sm.sector='Metals' and sm.sub_sector='Mining & Minerals' and sm.market_cap between '10' and '110' and sp.date = '2012-01-03' limit 100";

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
		HashMap<Integer, String> security = new HashMap<Integer, String>();
		HashMap<Integer, Double> lastClosePrice = new HashMap<Integer, Double>();
		HashMap<Integer, String> mc = new HashMap<Integer, String>();
		HashMap<Integer, String> hv1list = new HashMap<Integer, String>();
		HashMap<Integer, String> hv2list = new HashMap<Integer, String>();
		HashMap<Integer, String> hv3list = new HashMap<Integer, String>();
		HashMap<Integer, String> hv4list = new HashMap<Integer, String>();
		HashMap<Integer, String> hv5list = new HashMap<Integer, String>();

		HashMap<Integer, String> bd1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bd2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bd3list = new HashMap<Integer, String>();
		HashMap<Integer, String> bd4list = new HashMap<Integer, String>();

		HashMap<Integer, String> bdu1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bdu2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bdu3list = new HashMap<Integer, String>();

		HashMap<Integer, String> bdd1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bdd2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bdd3list = new HashMap<Integer, String>();

		HashMap<Integer, String> corr1list = new HashMap<Integer, String>();
		HashMap<Integer, String> corr2list = new HashMap<Integer, String>();
		HashMap<Integer, String> corr3list = new HashMap<Integer, String>();
		HashMap<Integer, String> corr4list = new HashMap<Integer, String>();
		HashMap<Integer, String> corr5list = new HashMap<Integer, String>();
		HashMap<Integer, String> corr6list = new HashMap<Integer, String>();

		HashMap<Integer, String> wb1list = new HashMap<Integer, String>();
		HashMap<Integer, String> wb2list = new HashMap<Integer, String>();
		HashMap<Integer, String> wb3list = new HashMap<Integer, String>();
		HashMap<Integer, String> wb4list = new HashMap<Integer, String>();

		HashMap<Integer, String> bwu1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bwu2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bwu3list = new HashMap<Integer, String>();

		HashMap<Integer, String> bwd1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bwd2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bwd3list = new HashMap<Integer, String>();

		HashMap<Integer, String> bm1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bm2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bm3list = new HashMap<Integer, String>();

		HashMap<Integer, String> bmu1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bmu2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bmu3list = new HashMap<Integer, String>();

		HashMap<Integer, String> bmd1list = new HashMap<Integer, String>();
		HashMap<Integer, String> bmd2list = new HashMap<Integer, String>();
		HashMap<Integer, String> bmd3list = new HashMap<Integer, String>();

		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<String> security12 = new ArrayList<String>();
		ArrayList<Double> lcp = new ArrayList<Double>();
		ArrayList<CopyOfAccessDataDetails> securityValues = new ArrayList<CopyOfAccessDataDetails>();

		ResultSetMetaData rsmd = rsDataSet.getMetaData();
		int numColumns = rsmd.getColumnCount();

		// Get the column names; column indices start from 1
		for (int ia = 0; ia < numColumns; ia++)
			columnName.add(rsmd.getColumnName(ia + 1));
		// System.out.println(columnName.get(3));

		while (rsDataSet.next()) {
			security.put(i, rsDataSet.getString(1));

			// System.out.println("this is a: " + a.values() + i);
			if (columnName.contains("close")) {
				lastClosePrice.put(i, Double.parseDouble(rsDataSet.getString("close")));
			}
			if (columnName.contains("market_cap")) {
				mc.put(i, rsDataSet.getString("market_cap"));
			}
			if (columnName.contains("hv10")) {
				hv1list.put(i, rsDataSet.getString("hv10"));
			}
			if (columnName.contains("hv20")) {
				hv2list.put(i, rsDataSet.getString("hv20"));
			}
			if (columnName.contains("hv60")) {
				hv3list.put(i, rsDataSet.getString("hv60"));
			}
			if (columnName.contains("hv120")) {
				hv4list.put(i, rsDataSet.getString("hv120"));
			}
			if (columnName.contains("hv250")) {
				hv5list.put(i, rsDataSet.getString("hv250"));
			}
			if (columnName.contains("betadaily20")) {
				bd1list.put(i, rsDataSet.getString("betadaily20"));
			}
			if (columnName.contains("betadaily60")) {
				bd2list.put(i, rsDataSet.getString("betadaily60"));
			}
			if (columnName.contains("betadaily120")) {
				bd3list.put(i, rsDataSet.getString("betadaily120"));
			}
			if (columnName.contains("betadaily250")) {
				bd4list.put(i, rsDataSet.getString("betadaily250"));
			}
			if (columnName.contains("betadaily60up")) {
				bdu1list.put(i, rsDataSet.getString("betadaily60up"));
			}
			if (columnName.contains("betadaily120up")) {
				bdu2list.put(i, rsDataSet.getString("betadaily120up"));
			}
			if (columnName.contains("betadaily250up")) {
				bdu3list.put(i, rsDataSet.getString("betadaily250up"));
			}
			if (columnName.contains("betadaily60down")) {
				bdd1list.put(i, rsDataSet.getString("betadaily60down"));
			}
			if (columnName.contains("betadaily120down")) {
				bdd2list.put(i, rsDataSet.getString("betadaily120down"));
			}
			if (columnName.contains("betadaily250down")) {
				bdd3list.put(i, rsDataSet.getString("betadaily250down"));
			}
			if (columnName.contains("corr10")) {
				corr1list.put(i, rsDataSet.getString("corr10"));
			}
			if (columnName.contains("corr20")) {
				corr2list.put(i, rsDataSet.getString("corr20"));
			}
			if (columnName.contains("corr40")) {
				corr3list.put(i, rsDataSet.getString("corr40"));
			}
			if (columnName.contains("corr60")) {
				corr4list.put(i, rsDataSet.getString("corr60"));
			}
			if (columnName.contains("corr120")) {
				corr5list.put(i, rsDataSet.getString("corr120"));
			}
			if (columnName.contains("corr250")) {
				corr6list.put(i, rsDataSet.getString("corr250"));
			}
			if (columnName.contains("betaweekly20")) {
				wb1list.put(i, rsDataSet.getString("betaweekly20"));
			}
			if (columnName.contains("betaweekly60")) {
				wb2list.put(i, rsDataSet.getString("betaweekly60"));
			}
			if (columnName.contains("betaweekly120")) {
				wb3list.put(i, rsDataSet.getString("betaweekly120"));
			}
			if (columnName.contains("betaweekly250")) {
				wb4list.put(i, rsDataSet.getString("betaweekly250"));
			}
			if (columnName.contains("betaweekly60up")) {
				bwu1list.put(i, rsDataSet.getString("betaweekly60up"));
			}
			if (columnName.contains("betaweekly120up")) {
				bwu2list.put(i, rsDataSet.getString("betaweekly120up"));
			}
			if (columnName.contains("betaweekly250up")) {
				bwu3list.put(i, rsDataSet.getString("betaweekly250up"));
			}
			if (columnName.contains("betaweekly60down")) {
				bwd1list.put(i, rsDataSet.getString("betaweekly60down"));
			}
			if (columnName.contains("betaweekly120down")) {
				bwd2list.put(i, rsDataSet.getString("betaweekly120down"));
			}
			if (columnName.contains("betaweekly250down")) {
				bwd3list.put(i, rsDataSet.getString("betaweekly250down"));
			}
			if (columnName.contains("betamonthly60")) {
				bm1list.put(i, rsDataSet.getString("betamonthly60"));
			}
			if (columnName.contains("betamonthly120")) {
				bm2list.put(i, rsDataSet.getString("betamonthly120"));
			}
			if (columnName.contains("betamonthly250")) {
				bm3list.put(i, rsDataSet.getString("betamonthly250"));
			}
			if (columnName.contains("betamonthly60up")) {
				bmu1list.put(i, rsDataSet.getString("betamonthly60up"));
			}
			if (columnName.contains("betamonthly120up")) {
				bmu2list.put(i, rsDataSet.getString("betamonthly120up"));
			}
			if (columnName.contains("betamonthly250up")) {
				bmu3list.put(i, rsDataSet.getString("betamonthly250up"));
			}
			if (columnName.contains("betamonthly60down")) {
				bmd1list.put(i, rsDataSet.getString("betamonthly60down"));
			}
			if (columnName.contains("betamonthly120down")) {
				bmd2list.put(i, rsDataSet.getString("betamonthly120down"));
			}
			if (columnName.contains("betamonthly250down")) {
				bmd3list.put(i, rsDataSet.getString("betamonthly250down"));
			}

			++i;
		}
		
		rsDataSet.beforeFirst();

		while (rsDataSet.next())
		{
			security12.add(rsDataSet.getString(1));
			lcp.add(Double.parseDouble(rsDataSet.getString(2)));
		}
		
		TradeAppFormVars.setSecurity(security);
		TradeAppFormVars.setLastClosePrice(lastClosePrice);
		TradeAppFormVars.setMc(mc);
		TradeAppFormVars.setHv1list(hv1list);
		TradeAppFormVars.setHv2list(hv2list);
		TradeAppFormVars.setHv3list(hv3list);
		//TradeAppFormVars.setHv4list(hv4list);
		TradeAppFormVars.setHv5list(hv5list);
		TradeAppFormVars.setBd1list(bd1list);
		TradeAppFormVars.setBd2list(bd2list);
		TradeAppFormVars.setBd3list(bd3list);
		TradeAppFormVars.setBd4list(bd4list);
		TradeAppFormVars.setBdu1list(bdu1list);
		TradeAppFormVars.setBdu2list(bdu2list);
		TradeAppFormVars.setBdu3list(bdu3list);
		TradeAppFormVars.setBdd1list(bdd1list);
		TradeAppFormVars.setBdd2list(bdd2list);
		TradeAppFormVars.setBdd3list(bdd3list);
		TradeAppFormVars.setCorr1list(corr1list);
		TradeAppFormVars.setCorr2list(corr2list);
		TradeAppFormVars.setCorr3list(corr3list);
		TradeAppFormVars.setCorr4list(corr4list);
		TradeAppFormVars.setCorr5list(corr5list);
		TradeAppFormVars.setCorr6list(corr6list);
		TradeAppFormVars.setWb1list(wb1list);
		TradeAppFormVars.setWb2list(wb2list);
		TradeAppFormVars.setWb3list(wb3list);
		TradeAppFormVars.setWb4list(wb4list);
		TradeAppFormVars.setBwu1list(bwu1list);
		TradeAppFormVars.setBwu2list(bwu2list);
		TradeAppFormVars.setBwu3list(bwu3list);
		TradeAppFormVars.setBwd1list(bwd1list);
		TradeAppFormVars.setBwd2list(bwd2list);
		TradeAppFormVars.setBwd3list(bwd3list);
		TradeAppFormVars.setBm1list(bm1list);
		TradeAppFormVars.setBm2list(bm2list);
		TradeAppFormVars.setBm3list(bm3list);
		TradeAppFormVars.setBmu1list(bmu1list);
		TradeAppFormVars.setBmu2list(bmu2list);
		TradeAppFormVars.setBmu3list(bmu3list);
		TradeAppFormVars.setBmd1list(bmd1list);
		TradeAppFormVars.setBmd2list(bmd2list);
		TradeAppFormVars.setBmd3list(bmd3list);
		appFormVars.setSecurity12(security12);
		appFormVars.setLcp(lcp);

		System.out.println("list size: " + appFormVars.getSecurity12().size());
		// securityValues.addAll(security.values());
		session.put("sec", securityValues);
		session.put("security12", security12);
		session.put("securityInSession", TradeAppFormVars.getSecurity());
*/

		return SUCCESS;
	}

}
