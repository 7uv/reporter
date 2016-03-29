package com.sayantan.ActionForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Gui2FormVars 
{
	// Global variables
	private static String doneRFile = " ";
	private int iterate = 0;
	private int flag = 0;
	
	// Database connectivity
	static String m_DBDriver = "org.postgresql.Driver";  
	static String url = "jdbc:postgresql://192.168.83.43:5432/MarketData";  
	static String username = "postgres";
	//static String password = "AQFTrading"; //sayantan
	static String password = "aqf@123"; //dev
	
	// Form input
	private static ArrayList<String> securityList = new ArrayList<String>(); 	
	private static String latestEntry;
	private static String security1;
	private String sec1;
	private String sec2;
	private static String security2;
	private String hvBetaPeriod;
	private static Double hvBetaCorrAverage;
	private int priceHistoryField;
	//private int priceHistory1; //may b try out for display tag but take care of calculations also
		
	//create result lists
	private HashMap<Integer, Date> dateHistory = new HashMap<Integer, Date>();
	private static HashMap<Integer, Double> hvBetaCorr = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> priceHistory = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> priceHistory1 = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> priceHistory2 = new HashMap<Integer, Double>();
	private static HashMap<Integer, String> priceRatio = new HashMap<Integer, String>();
	private static HashMap<Integer, Double> priceRatios = new HashMap<Integer, Double>();
	private static HashMap<Integer, String> priceCompare = new HashMap<Integer, String>();
	private Double latestPrice;
	private Double latestPrice1;
	private Double latestPrice2;
	private Double latestPriceRatio;
	private Double meanPriceRatio;
	private Double hv1;
	private Double hv2;
	private Double hvNifty;
	private Double beta1;
	private Double beta2; 
	private Double betaNifty;
	private Double corr1;
	private Double corr2;
	private Double corrNifty;
	private Double hv1Average;
	private Double hv2Average;
	private Double hvMeanRatio;
	private Double correlation;
	private Double corrIndex;
	private HashMap<Integer, Double> covariance = new HashMap<Integer, Double>();
	
	private ArrayList<Double> lcp = new ArrayList<Double>();

	// Getters and Setters
	public static ArrayList<String> getSecurityList() {
		return securityList;
	}
	public static void setSecurityList(ArrayList<String> securityList) {
		Gui2FormVars.securityList = securityList;
	}
	public static String getDoneRFile() {
		return doneRFile;
	}
	public static void setDoneRFile(String doneRFile) {
		Gui2FormVars.doneRFile = doneRFile;
	}
	public HashMap<Integer, Date> getDateHistory() {
		return dateHistory;
	}
	public void setDateHistory(HashMap<Integer, Date> dateHistory) {
		this.dateHistory = dateHistory;
	}
	public Double getLatestPrice() {
		return latestPrice;
	}
	public Double getHv1Average() {
		return hv1Average;
	}
	public void setHv1Average(Double hv1Average) {
		this.hv1Average = hv1Average;
	}
	public Double getHv2Average() {
		return hv2Average;
	}
	public void setHv2Average(Double hv2Average) {
		this.hv2Average = hv2Average;
	}
	public Double getHvMeanRatio() {
		return hvMeanRatio;
	}
	public void setHvMeanRatio(Double hvMeanRatio) {
		this.hvMeanRatio = hvMeanRatio;
	}
	public HashMap<Integer, Double> getCovariance() {
		return covariance;
	}
	public void setCovariance(HashMap<Integer, Double> covariance) {
		this.covariance = covariance;
	}
	public static HashMap<Integer, Double> getPriceRatios() {
		return priceRatios;
	}
	public Double getCorrIndex() {
		return corrIndex;
	}
	public void setCorrIndex(Double corrIndex) {
		this.corrIndex = corrIndex;
	}
	public static void setPriceRatios(HashMap<Integer, Double> priceRatios) {
		Gui2FormVars.priceRatios = priceRatios;
	}
	public static String getLatestEntry() {
		return latestEntry;
	}
	public static void setLatestEntry(String latestEntry) {
		Gui2FormVars.latestEntry = latestEntry;
	}
	public void setLatestPrice(Double latestPrice) {
		this.latestPrice = latestPrice;
	}
	public Double getLatestPrice1() {
		return latestPrice1;
	}
	public void setLatestPrice1(Double latestPrice1) {
		this.latestPrice1 = latestPrice1;
	}
	public Double getLatestPrice2() {
		return latestPrice2;
	}
	public void setLatestPrice2(Double latestPrice2) {
		this.latestPrice2 = latestPrice2;
	} 
	public Double getHvNifty() {
		return hvNifty;
	}
	public void setHvNifty(Double hvNifty) {
		this.hvNifty = hvNifty;
	}
	public Double getBetaNifty() {
		return betaNifty;
	}
	public void setBetaNifty(Double betaNifty) {
		this.betaNifty = betaNifty;
	}
	public Double getCorrNifty() {
		return corrNifty;
	}
	public void setCorrNifty(Double corrNifty) {
		this.corrNifty = corrNifty;
	}
	public Double getLatestPriceRatio() {
		return latestPriceRatio;
	}
	public void setLatestPriceRatio(Double latestPriceRatio) {
		this.latestPriceRatio = latestPriceRatio;
	}
	public Double getMeanPriceRatio() {
		return meanPriceRatio;
	}
	public void setMeanPriceRatio(Double meanPriceRatio) {
		this.meanPriceRatio = meanPriceRatio;
	}
	public int getIterate() {
		return iterate;
	}
	public void setIterate(int iterate) {
		this.iterate = iterate;
	}
	public static String getM_DBDriver() {
		return m_DBDriver;
	}
	public static void setM_DBDriver(String m_DBDriver) {
		Gui2FormVars.m_DBDriver = m_DBDriver;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Gui2FormVars.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public int getPriceHistoryField() {
		return priceHistoryField;
	}
	public void setPriceHistoryField(int priceHistoryField) {
		this.priceHistoryField = priceHistoryField;
	}
	public static void setUsername(String username) {
		Gui2FormVars.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Gui2FormVars.password = password;
	}
	public String getSec1() {
		return sec1;
	}
	public void setSec1(String sec1) {
		this.sec1 = sec1;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public static HashMap<Integer, String> getPriceRatio() {
		return priceRatio;
	}
	public static void setPriceRatio(HashMap<Integer, String> priceRatio) {
		Gui2FormVars.priceRatio = priceRatio;
	}
	public String getSec2() {
		return sec2;
	}
	public void setSec2(String sec2) {
		this.sec2 = sec2;
	}
	public static String getSecurity1() {
		return security1;
	}
	public static void setSecurity1(String security1) {
		Gui2FormVars.security1 = security1;
	}
	public static String getSecurity2() {
		return security2;
	}
	public static void setSecurity2(String security2) {
		Gui2FormVars.security2 = security2;
	}
	public String getHvBetaPeriod() {
		return hvBetaPeriod;
	}
	public void setHvBetaPeriod(String hvBetaPeriod) {
		this.hvBetaPeriod = hvBetaPeriod;
	}
	public static HashMap<Integer, String> getPriceCompare() {
		return priceCompare;
	}
	public static void setPriceCompare(HashMap<Integer, String> priceCompare) {
		Gui2FormVars.priceCompare = priceCompare;
	}
	public static Double getHvBetaCorrAverage() {
		return hvBetaCorrAverage;
	}
	public static void setHvBetaCorrAverage(Double hvBetaCorrAverage) {
		Gui2FormVars.hvBetaCorrAverage = hvBetaCorrAverage;
	}
	public static HashMap<Integer, Double> getHvBetaCorr() {
		return hvBetaCorr;
	}
	public static void setHvBetaCorr(HashMap<Integer, Double> hvBetaCorr) {
		Gui2FormVars.hvBetaCorr = hvBetaCorr;
	}
	public ArrayList<Double> getLcp() {
		return lcp;
	}
	public HashMap<Integer, Double> getPriceHistory() {
		return priceHistory;
	}
	public void setPriceHistory(HashMap<Integer, Double> priceHistory) {
		this.priceHistory = priceHistory;
	}
	public void setLcp(ArrayList<Double> lcp) {
		this.lcp = lcp;
	}
	public HashMap<Integer, Double> getPriceHistory1() {
		return priceHistory1;
	}
	public void setPriceHistory1(HashMap<Integer, Double> priceHistory1) {
		this.priceHistory1 = priceHistory1;
	}
	public HashMap<Integer, Double> getPriceHistory2() {
		return priceHistory2;
	}
	public void setPriceHistory2(HashMap<Integer, Double> priceHistory2) {
		this.priceHistory2 = priceHistory2;
	}
	public Double getHv1() {
		return hv1;
	}
	public void setHv1(Double hv1) {
		this.hv1 = hv1;
	}
	public Double getHv2() {
		return hv2;
	}
	public void setHv2(Double hv2) {
		this.hv2 = hv2;
	}
	public Double getBeta1() {
		return beta1;
	}
	public void setBeta1(Double beta1) {
		this.beta1 = beta1;
	}
	public Double getBeta2() {
		return beta2;
	}
	public void setBeta2(Double beta2) {
		this.beta2 = beta2;
	}
	public Double getCorr1() {
		return corr1;
	}
	public void setCorr1(Double corr1) {
		this.corr1 = corr1;
	}
	public Double getCorr2() {
		return corr2;
	}
	public void setCorr2(Double corr2) {
		this.corr2 = corr2;
	}
	public Double getCorrelation() {
		return correlation;
	}
	public void setCorrelation(Double correlation) {
		this.correlation = correlation;
	}
}
