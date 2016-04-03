package com.sayantan.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sayantan.ActionForm.Gui2FormVars;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;

public class StockCorrelation extends ActionSupport implements
		ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = -7012445214546281834L;
	Map<String, Object> session = ActionContext.getContext().getSession();

	private Gui2FormVars appFormVars;
	private static final Logger logger = Logger
			.getLogger(StockCorrelation.class);
	ArrayList<String> securityValuesq = new ArrayList<String>();

	public void prepare() throws Exception {
		appFormVars = new Gui2FormVars();
	}

	public Object getModel() {
		return appFormVars;
	}

	@Override
	public String execute() throws Exception {
		logger.info("RUNNING AccessDataDetails");
 
/*
		// user filters
		// price time duration
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		long now = System.currentTimeMillis();
		int g = -1 * (Integer) appFormVars.getPriceHistoryField();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		// String todayDate = formatter.format(calendar.getTime());
		String todayDate = Gui2FormVars.getLatestEntry();
		logger.info(Gui2FormVars.getLatestEntry());
		logger.info(todayDate);
		calendar.setTime(formatter.parse(todayDate));
		calendar.add(Calendar.DATE, g);
		String orderDate = formatter.format(calendar.getTime());
		logger.info(g + " = " + todayDate + " = " + orderDate);

		// testing
		// todayDate = "2012-07-17";
		// orderDate = "2012-01-03";

		// Create the query
		String stock1query = "select distinct sp.date, sp.close, hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ " from stock_prices sp, historical_volatility hv "
				+ "where "
				+ "hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ " is not null and "
				+ "sp.date between '"
				+ orderDate
				+ "' and '"
				+ todayDate
				+ "' "
				+ "and sp.security='"
				+ Gui2FormVars.getSecurity1()
				+ "' and sp.security = hv.security and sp.date = hv.date order by sp.date ";
		logger.info(stock1query);

		String stock2query = "select distinct sp.date, sp.close, hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ " from stock_prices sp, historical_volatility hv "
				+ "where "
				+ "hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ " is not null and "
				+ "sp.date between '"
				+ orderDate
				+ "' and '"
				+ todayDate
				+ "' "
				+ "and sp.security='"
				+ Gui2FormVars.getSecurity2()
				+ "' and sp.security = hv.security and sp.date = hv.date order by sp.date ";
		logger.info(stock2query);

		String niftyquery = "select distinct sp.date, sp.close, hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ " from stock_prices sp, historical_volatility hv "
				+ "where "
				+ "sp.date between '"
				+ orderDate
				+ "' and '"
				+ todayDate
				+ "' "
				+ "and sp.security='NIFTY' "
				+ "and sp.security = hv.security and sp.date = hv.date order by sp.date ";
		String hv1Query = "select hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.betadaily"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.corr"
				+ appFormVars.getHvBetaPeriod()
				+ "  from historical_volatility hv, daily_beta db where hv.date = '"
				+ todayDate
				+ "' and hv.security='"
				+ Gui2FormVars.getSecurity1()
				+ "' and db.date=hv.date and db.security=hv.security";
		String hv2Query = "select hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.betadaily"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.corr"
				+ appFormVars.getHvBetaPeriod()
				+ "  from historical_volatility hv, daily_beta db where hv.date = '"
				+ todayDate
				+ "' and hv.security='"
				+ Gui2FormVars.getSecurity2()
				+ "' and db.date=hv.date and db.security=hv.security";

		String hvNiftyQuery = "select hv.hv"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.betadaily"
				+ appFormVars.getHvBetaPeriod()
				+ ", db.corr"
				+ appFormVars.getHvBetaPeriod()
				+ "  from historical_volatility hv, daily_beta db where hv.date = '"
				+ todayDate
				+ "' and hv.security='NIFTY' and db.date=hv.date and db.security=hv.security";

		logger.info(hv1Query);
		appFormVars.setSec1(Gui2FormVars.getSecurity1());
		appFormVars.setSec2(Gui2FormVars.getSecurity2());

		// logger.info("data Access Query: " + stock1query);

		// test query
		String testQuery = "select distinct sm.security, sp.close, sm.market_cap from security_master sm, stock_prices sp, historical_volatility hv WHERE sm.security=sp.security and sm.security=hv.security   and sm.sector='Metals' and sm.sub_sector='Mining & Minerals' and sm.market_cap between '10' and '110' and sp.date = '2012-01-03' limit 100";

		// Retrieve the result set
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsDataSet = null;
		Connection conn1 = null;
		Statement stmt1 = null;
		ResultSet rsDataSet1 = null;
		Connection conn2 = null;
		Statement stmt2 = null;
		ResultSet rsDataSet2 = null;
		Connection connHv1 = null;
		Statement stmtHv1 = null;
		ResultSet rsDataSetHv1 = null;
		Connection connHv2 = null;
		Statement stmtHv2 = null;
		ResultSet rsDataSetHv2 = null;
		Connection connHvNifty = null;
		Statement stmtHvNifty = null;
		ResultSet rsDataSetHvNifty = null;

		conn = ConnectionManager.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		conn1 = ConnectionManager.getConnection();
		stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		conn2 = ConnectionManager.getConnection();
		stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		connHv1 = ConnectionManager.getConnection();
		stmtHv1 = connHv1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		connHv2 = ConnectionManager.getConnection();
		stmtHv2 = connHv2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		connHvNifty = ConnectionManager.getConnection();
		stmtHvNifty = connHvNifty.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// rsDataSet = stmt.executeQuery(dataDetailsQuery);
		rsDataSet = stmt.executeQuery(niftyquery);
		rsDataSet1 = stmt1.executeQuery(stock1query);
		rsDataSet2 = stmt2.executeQuery(stock2query);

		rsDataSetHv1 = stmtHv1.executeQuery(hv1Query);
		rsDataSetHv2 = stmtHv2.executeQuery(hv2Query);
		rsDataSetHvNifty = stmtHvNifty.executeQuery(hvNiftyQuery);

		// create result lists
		int i = 0;
		HashMap<Integer, Date> dateHistory = new HashMap<Integer, Date>();
		HashMap<Integer, Double> priceHistory = new HashMap<Integer, Double>();
		HashMap<Integer, Double> priceHistory1 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> priceHistory2 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> priceHistoryRatio = new HashMap<Integer, Double>();
		
		HashMap<Integer, Double> returnHistory = new HashMap<Integer, Double>();
		HashMap<Integer, Double> returnHistory1 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> returnHistory2 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> returnHistoryRatio = new HashMap<Integer, Double>();
		
		HashMap<Integer, String> priceRatio = new HashMap<Integer, String>();
		HashMap<Integer, String> priceCompare = new HashMap<Integer, String>();
		HashMap<Integer, Double> hv1 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> hv2 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> covariance = new HashMap<Integer, Double>();
		HashMap<Integer, Double> covIndex = new HashMap<Integer, Double>();
		Double sumCovariance = 0D;
		Double correlation = 0D;
		Double sumPrice = 0D;
		Double sumPrice1 = 0D;
		Double sumPrice2 = 0D;
		Double sumPrice12 = 0D;
		Double sumReturn = 0D;
		Double sumReturn1 = 0D;
		Double sumReturn2 = 0D;
		Double sumReturn12 = 0D;
		Double sumHv1 = 0D;
		Double sumHv2 = 0D;
		Double hv1avg = 0D;
		Double hv2avg = 0D;
		Double hvMeanRatio = 0D;
		Double sumHvRatio = 0D;
		Double stock1ReturnSum = 0D;
		Double stock2ReturnSum = 0D;
		Double stockReturnSum = 0D;
		// Double meanPrice = 0D;
		
		ResultSetMetaData rsmd = rsDataSet.getMetaData();
		int numColumns = rsmd.getColumnCount();

		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<Double> lcp = new ArrayList<Double>();
		ArrayList<StockCorrelation> securityValues = new ArrayList<StockCorrelation>();

		// Get the column names; column indices start from 1
		for (int ia = 0; ia < numColumns; ia++)
			columnName.add(rsmd.getColumnName(ia + 1));

		while (rsDataSet.next()) {
			dateHistory.put(i, (Date) (rsDataSet.getDate(1)));
			priceHistory.put(i, Double.parseDouble(rsDataSet.getString(2)));
			++i;
		}
		//return conv
		for(int k = 0; k< priceHistory.size()-1; k++)
		{
			Double r = 0.0;
			//if(priceHistory1.get(k) != priceHistory1.get(priceHistory1.size()-1)){
				r = (priceHistory.get(k)/priceHistory.get(k+1))-1.0;
			//}
			returnHistory.put(k, r);
		}
		//priceHistory.remove(priceHistory.size()-1);
		
		// logger.info("dat" + dateHistory.values());
		String prS = null;
		i = 0;
		while (rsDataSet1.next()) {
			priceHistory1.put(i, Double.parseDouble(rsDataSet1.getString(2)));
			Double t = Double.parseDouble(rsDataSet1.getString(3));
			BigDecimal d = new BigDecimal(t);
			d = d.setScale(4, RoundingMode.HALF_UP);
			prS = d.toString();
			hv1.put(i, Double.parseDouble(prS));
			++i;
		}
		//return conv
		for(int k = 0; k< priceHistory1.size()-1; k++)
		{
			Double r = 0.0;
			//if(priceHistory1.get(k) != priceHistory1.get(priceHistory1.size()-1)){
				r = (priceHistory1.get(k)/priceHistory1.get(k+1))-1.0;
			//}
			returnHistory1.put(k, r);
		}
		//priceHistory1.remove(priceHistory1.size()-1);
		
		i = 0;
		while (rsDataSet2.next()) {
			priceHistory2.put(i, Double.parseDouble(rsDataSet2.getString(2)));
			Double t = Double.parseDouble(rsDataSet2.getString(3));
			BigDecimal d = new BigDecimal(t);
			d = d.setScale(4, RoundingMode.HALF_UP);
			prS = d.toString();
			hv2.put(i, Double.parseDouble(prS));
			++i;
		}
		//return conv
		for(int k = 0; k< priceHistory2.size()-1; k++)
		{
			Double r = 0.0;
			//if(priceHistory2.get(k) != priceHistory2.get(priceHistory2.size()-1)){
				r = (priceHistory2.get(k)/priceHistory2.get(k+1))-1.0;
			//}
			returnHistory2.put(k, r);
		}
		//priceHistory2.remove(priceHistory2.size()-1);
		
		i = 0;
		rsDataSet.beforeFirst();
		while (rsDataSet.next()) {
			lcp.add(Double.parseDouble(rsDataSet.getString(2)));
		}
		while (rsDataSetHv1.next()) {
			Double t1 = Double.parseDouble(rsDataSetHv1.getString(1));
			Double t2 = Double.parseDouble(rsDataSetHv1.getString(2));
			Double t3 = Double.parseDouble(rsDataSetHv1.getString(3));
			BigDecimal h = new BigDecimal(t1);
			BigDecimal b = new BigDecimal(t2);
			BigDecimal c = new BigDecimal(t3);
			h = h.setScale(4, RoundingMode.HALF_UP);
			b = b.setScale(4, RoundingMode.HALF_UP);
			c = c.setScale(4, RoundingMode.HALF_UP);
			String hvS = h.toString();
			String betS = b.toString();
			String corS = c.toString();
			
			appFormVars.setHv1(Double.parseDouble(hvS)*100);
			appFormVars.setBeta1(Double.parseDouble(betS));
			appFormVars.setCorr1(Double.parseDouble(corS));
		}
		while (rsDataSetHv2.next()) {
			
			Double t1 = Double.parseDouble(rsDataSetHv2.getString(1));
			Double t2 = Double.parseDouble(rsDataSetHv2.getString(2));
			Double t3 = Double.parseDouble(rsDataSetHv2.getString(3));
			BigDecimal h = new BigDecimal(t1);
			BigDecimal b = new BigDecimal(t2);
			BigDecimal c = new BigDecimal(t3);
			h = h.setScale(4, RoundingMode.HALF_UP);
			b = b.setScale(4, RoundingMode.HALF_UP);
			c = c.setScale(4, RoundingMode.HALF_UP);
			String hvS = h.toString();
			String betS = b.toString();
			String corS = c.toString();
			
			appFormVars.setHv2(Double.parseDouble(hvS)*100);
			appFormVars.setBeta2(Double.parseDouble(betS));
			appFormVars.setCorr2(Double.parseDouble(corS));
		}
		while (rsDataSetHvNifty.next()) {
			Double t1 = Double.parseDouble(rsDataSetHvNifty.getString(1));
			Double t2 = Double.parseDouble(rsDataSetHvNifty.getString(2));
			Double t3 = Double.parseDouble(rsDataSetHvNifty.getString(3));
			BigDecimal h = new BigDecimal(t1);
			BigDecimal b = new BigDecimal(t2);
			BigDecimal c = new BigDecimal(t3);
			h = h.setScale(4, RoundingMode.HALF_UP);
			b = b.setScale(4, RoundingMode.HALF_UP);
			c = c.setScale(4, RoundingMode.HALF_UP);
			String hvS = h.toString();
			String betS = b.toString();
			String corS = c.toString();
			
			appFormVars.setHvNifty(Double.parseDouble(hvS));
			appFormVars.setBetaNifty(Double.parseDouble(betS));
			appFormVars.setCorrNifty(Double.parseDouble(corS));
		}

		// calcs
		int k = 0;
		if ((priceHistory.size() <= priceHistory1.size())
				&& (priceHistory.size() <= priceHistory2.size()))
			k = priceHistory.size();
		if ((priceHistory1.size() <= priceHistory.size())
				&& (priceHistory1.size() <= priceHistory2.size()))
			k = priceHistory1.size();
		if ((priceHistory2.size() <= priceHistory.size())
				&& (priceHistory2.size() <= priceHistory1.size()))
			k = priceHistory2.size();

		// logger.info(priceHistory.size() + " " + priceHistory1.size()
		// + " " + priceHistory2.size() + " " + k);

		for (int z = 0; z < k; z++){
			if(priceHistory1.get(z) != 0.0)
			priceHistoryRatio.put(z,
					priceHistory2.get(z) / priceHistory1.get(z));
		}

		for (int a = 0; a < priceHistoryRatio.size(); a++)
		{
			//while(priceHistoryRatio.get(a) != null){
				logger.info("sump: "+ sumPrice + " " + priceHistoryRatio.get(a));
				sumPrice = sumPrice + priceHistoryRatio.get(a);
			//}
		}
		for (int a = 0; a < priceHistory1.size(); a++)
			sumPrice1 = sumPrice1 + priceHistory1.get(a);
		for (int a = 0; a < priceHistory2.size(); a++)
			sumPrice2 = sumPrice2 + priceHistory2.get(a);
		for (int a = 0; a < priceHistory2.size(); a++)
			sumPrice12 = sumPrice12 + priceHistory2.get(a)
					* priceHistory2.get(a);
		for (int a = 0; a < hv1.size(); a++)
			sumHv1 = sumHv1 + hv1.get(a);
		for (int a = 0; a < hv2.size(); a++)
			sumHv2 = sumHv2 + hv2.get(a);
		// logger.info("pkpkp " + sumPrice);
		hv1avg = sumHv1 / (hv1.size() - 1);
		hv2avg = sumHv2 / (hv2.size() - 1);

		// logger.info("asdf: " + hv1avg + " " + hv2avg);

		if (priceHistory1.get(0) == null)
			priceHistory1.put(0, 0.0);
		if (priceHistory2.get(0) == null)
			priceHistory2.put(0, 0.0);
		if (hv1.get(0) == null)
			hv1.put(0, 0.0);
		if (hv2.get(0) == null)
			hv2.put(0, 0.0);

		for (int a = 0; a < priceHistoryRatio.size(); a++)
			priceRatio.put(a,
					dateHistory.get(a) + "," + priceHistoryRatio.get(a));
		for (int a = 0; a < priceHistoryRatio.size(); a++)
			priceCompare.put(a, dateHistory.get(a) + "," + priceHistory1.get(a)
					+ "," + priceHistory2.get(a));

		// return calcs
		// calcs
		k = 0;
		if ((returnHistory.size() <= returnHistory1.size())
				&& (returnHistory.size() <= returnHistory2.size()))
			k = returnHistory.size();
		if ((returnHistory1.size() <= returnHistory.size())
				&& (returnHistory1.size() <= returnHistory2.size()))
			k = returnHistory1.size();
		if ((returnHistory2.size() <= returnHistory.size())
				&& (returnHistory2.size() <= returnHistory1.size()))
			k = returnHistory2.size();

		// logger.info(priceHistory.size() + " " + priceHistory1.size()
		// + " " + priceHistory2.size() + " " + k);

		for (int z = 0; z < k; z++){
			if(returnHistory1.get(z) != 0.0)
			returnHistoryRatio.put(z,
					returnHistory2.get(z) / returnHistory1.get(z));
		}

		for (int a = 0; a < returnHistoryRatio.size(); a++)
		{
			if(returnHistoryRatio.get(a) != null){
				logger.info("sump: "+ sumPrice + " " + returnHistoryRatio.get(a));
				sumReturn = sumReturn + returnHistoryRatio.get(a);
			}
		}
		for (int a = 0; a < returnHistory1.size(); a++)
			sumReturn1 = sumReturn1 + returnHistory1.get(a);
		for (int a = 0; a < returnHistory2.size(); a++)
			sumReturn2 = sumReturn2 + returnHistory2.get(a);
		for (int a = 0; a < returnHistory2.size(); a++)
			sumReturn12 = sumReturn12 + returnHistory2.get(a)
					* returnHistory2.get(a);
		*/
/*for (int a = 0; a < hv1.size(); a++)
			sumHv1 = sumHv1 + hv1.get(a);
		for (int a = 0; a < hv2.size(); a++)
			sumHv2 = sumHv2 + hv2.get(a);
		// logger.info("pkpkp " + sumPrice);
		hv1avg = sumHv1 / (hv1.size() - 1);
		hv2avg = sumHv2 / (hv2.size() - 1);
		*//*

		// logger.info("asdf: " + hv1avg + " " + hv2avg);

		if (returnHistory1.get(0) == null)
			returnHistory1.put(0, 0.0);
		if (returnHistory2.get(0) == null)
			returnHistory2.put(0, 0.0);
//		if (hv1.get(0) == null)
//			hv1.put(0, 0.0);
//		if (hv2.get(0) == null)
//			hv2.put(0, 0.0);

//		for (int a = 0; a < returnHistoryRatio.size(); a++)
//			priceRatio.put(a,
//					dateHistory.get(a) + "," + returnHistoryRatio.get(a));
//		for (int a = 0; a < returnHistoryRatio.size(); a++)
//			priceCompare.put(a, dateHistory.get(a) + "," + returnHistory1.get(a)
//					+ "," + returnHistory2.get(a));

		// calculation of hv ratio
		*/
/*
		 * for (int a = 0; a < priceHistoryRatio.size(); a++) sumHvRatio =
		 * sumHvRatio + (priceHistoryRatio.get(a) - (sumPrice /
		 * (priceHistoryRatio .size() - 1))) (priceHistoryRatio.get(a) -
		 * (sumPrice / (priceHistoryRatio .size() - 1)));
		 *//*

		for (int a = 0; a < returnHistoryRatio.size(); a++)
			if(returnHistoryRatio.get(a) != null)
				sumHvRatio = sumHvRatio
						+ (returnHistoryRatio.get(a))
						* (returnHistoryRatio.get(a));
		//hvMeanRatio = Math.sqrt(Double.parseDouble(appFormVars.getHvBetaPeriod()) * sumHvRatio / (returnHistoryRatio.size()-1));
		// avg hv -- direct approach
		hvMeanRatio = hv2avg/hv1avg;
		// calculation of correlation
		for (int m = 0; m < returnHistory1.size(); m++) {
			if(returnHistory1.get(m) != null && returnHistory2.get(m) != null)
				covariance
						.put(m,
								((((returnHistory1.get(m)) - (sumPrice1 / (returnHistory1
										.size() - 1))) * ((returnHistory2.get(m)) - (sumPrice2 / (returnHistory2
										.size() - 1))))));
		}
		logger.info("covar: " + covariance.values());
		for (int a = 0; a < covariance.size(); a++)
			sumCovariance = sumCovariance + covariance.get(a);

		// logger.info(covariance);
		// logger.info(sumCovariance + " " + covariance.size() + " "
		// + hv1avg + " " + hv2avg + "jsdfh");

		// correlation = sumCovariance/ ((covariance.size() - 1) * hv1avg *
		// hv2avg);

		for (int a = 0; a < returnHistory1.size(); a++)
			stock1ReturnSum = stock1ReturnSum + returnHistory1.get(a)
					* returnHistory1.get(a);
		for (int a = 0; a < returnHistory2.size(); a++)
			stock2ReturnSum = stock2ReturnSum + returnHistory2.get(a)
					* returnHistory2.get(a);
		for (int a = 0; a < returnHistory1.size(); a++)
			stockReturnSum = stockReturnSum + returnHistory1.get(a)
					* returnHistory2.get(a);
		correlation = stockReturnSum
				/ Math.sqrt(stock1ReturnSum * stock2ReturnSum);
		appFormVars.setFlag(1);
		// logger.info(returnRatio.size()+ " " +
		// returnRatio.get(returnRatio.size()-1));
		// returnRatio.put(returnRatio.size(),returnRatio.get(returnRatio.size() -
		// 1).substring(0,(returnRatio.get(returnRatio.size() - 1).length() -
		// 1)));
		logger.info("gr" + priceRatio);

		*/
/*
		// calculation of index correlation
				for (int m = 0; m < returnHistory1.size(); m++) {
					covariance
							.put(m,
									((((returnHistory1.get(m)) - (sumPrice1 / (returnHistory1
											.size() - 1))) * ((returnHistory2.get(m)) - (sumPrice2 / (returnHistory2
											.size() - 1))))));
				}
				logger.info("covar: " + covariance.values());
				for (int a = 0; a < covariance.size(); a++)
					sumCovariance = sumCovariance + covariance.get(a);

				// logger.info(covariance);
				// logger.info(sumCovariance + " " + covariance.size() + " "
				// + hv1avg + " " + hv2avg + "jsdfh");

				// correlation = sumCovariance/ ((covariance.size() - 1) * hv1avg *
				// hv2avg);

				for (int a = 0; a < returnHistory1.size(); a++)
					stock1ReturnSum = stock1ReturnSum + returnHistory1.get(a)
							* returnHistory1.get(a);
				for (int a = 0; a < returnHistory2.size(); a++)
					stock2ReturnSum = stock2ReturnSum + returnHistory2.get(a)
							* returnHistory2.get(a);
				for (int a = 0; a < returnHistory1.size(); a++)
					stockReturnSum = stockReturnSum + returnHistory1.get(a)
							* returnHistory2.get(a);
				correlation = stockReturnSum
						/ Math.sqrt(stock1ReturnSum * stock2ReturnSum);
				appFormVars.setFlag(1);
				// logger.info(returnRatio.size()+ " " +
				// returnRatio.get(returnRatio.size()-1));
				// returnRatio.put(returnRatio.size(),returnRatio.get(returnRatio.size() -
				// 1).substring(0,(returnRatio.get(returnRatio.size() - 1).length() -
				// 1)));
				logger.info("gr" + priceRatio);
		*//*


		
		appFormVars.setDateHistory(dateHistory);
		if(returnHistory1.get(returnHistory1.size() - 1) != 0.0){
		BigDecimal pr = new BigDecimal(priceHistory2.get(priceHistory2.size() - 1)
						/ priceHistory1.get(priceHistory1.size() - 1));
		pr = pr.setScale(4, RoundingMode.HALF_UP);
		prS = pr.toString();}
		BigDecimal lp = new BigDecimal(priceHistory.get(priceHistory.size() - 1));
		lp = lp.setScale(2, RoundingMode.HALF_UP);
		String lpS = lp.toString();
		BigDecimal lp1 = new BigDecimal(priceHistory1.get(priceHistory1.size() - 1));
		lp1 = lp1.setScale(2, RoundingMode.HALF_UP);
		String lp1S = lp1.toString();
		BigDecimal lp2 = new BigDecimal(priceHistory2.get(priceHistory2.size() - 1));
		lp2 = lp2.setScale(2, RoundingMode.HALF_UP);
		String lp2S = lp2.toString();
		logger.info("sum "+sumPrice + " "+ priceHistoryRatio.size());
		BigDecimal mpr = new BigDecimal(sumPrice / (priceHistoryRatio.size() - 1));
		mpr = mpr.setScale(4, RoundingMode.HALF_UP);
		String mprS = mpr.toString();
		BigDecimal hvr = new BigDecimal(hvMeanRatio);
		hvr = hvr.setScale(4, RoundingMode.HALF_UP);
		String hvrS = hvr.toString();
		BigDecimal cor = new BigDecimal(correlation);
		cor = cor.setScale(4, RoundingMode.HALF_UP);
		String corS = cor.toString();
		appFormVars
				.setLatestPriceRatio(Double.parseDouble(prS));
		appFormVars.setLatestPrice(Double.parseDouble(lpS));
		appFormVars
				.setLatestPrice1(Double.parseDouble(lp1S));
		appFormVars
				.setLatestPrice2(Double.parseDouble(lp2S));
		appFormVars.setPriceHistory(priceHistory);
		appFormVars.setPriceHistory1(priceHistory1);
		appFormVars.setPriceHistory2(priceHistory2);
		Gui2FormVars.setPriceRatio(priceRatio);
		Gui2FormVars.setPriceCompare(priceCompare);
		appFormVars.setMeanPriceRatio(Double.parseDouble(mprS));
		appFormVars.setHvMeanRatio(Double.parseDouble(hvrS));
		appFormVars.setCorrelation(Double.parseDouble(corS));

		session.put("sec", securityValues);
		logger.info("Stock Correlation Done!" + dateHistory.values());
*/

		return SUCCESS;
	}
}
