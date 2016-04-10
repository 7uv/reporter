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
    static String m_DBDriver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/reports";
    static String username = "adminJHD5464";
    static String password = "A564SFDa654dsf";

    // Form input
    private static String latestEntry;
    private static Date fromDate = new Date();
    private static Date toDate = new Date();
    private static String dept = "";
    private static String llob = "";
    private static ArrayList<String> deptList = new ArrayList<>();
    private static ArrayList<String> llobList = new ArrayList<>();
    private static String sn;
    private int priceHistoryField;

    //create result lists
    private static HashMap<Integer, Integer> idMap = new HashMap<>();
    private static HashMap<Integer, Date> fromDateMap = new HashMap<>();
    private static HashMap<Integer, Date> toDateMap = new HashMap<>();
    private static HashMap<Integer, String> deptMap = new HashMap<>();
    private static HashMap<Integer, String> llobMap = new HashMap<>();
    private static HashMap<Integer, String> itemTypeMap = new HashMap<>();
    private static HashMap<Integer, String> itemFormMap = new HashMap<>();
    private static HashMap<Integer, String> isbnMap = new HashMap<>();
    private static HashMap<Integer, Double> priceMap = new HashMap<>();
    private static HashMap<Integer, String> currMap = new HashMap<>();
    private static HashMap<Integer, Integer> qntyMap = new HashMap<>();
    private HashMap<Integer, Double> total = new HashMap<>();
    private ArrayList<Double> lcp = new ArrayList<Double>();
    private ArrayList<String> secLink = new ArrayList<>();

    // Getters and Setters
    public static String getDoneRFile() {
        return doneRFile;
    }

    public static void setDoneRFile(String doneRFile) {
        Gui2FormVars.doneRFile = doneRFile;
    }

    public int getIterate() {
        return iterate;
    }

    public void setIterate(int iterate) {
        this.iterate = iterate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ArrayList<Double> getLcp() {
        return lcp;
    }

    public void setLcp(ArrayList<Double> lcp) {
        this.lcp = lcp;
    }

    public ArrayList<String> getSecLink() {
        return secLink;
    }

    public void setSecLink(ArrayList<String> secLink) {
        this.secLink = secLink;
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

    public static void setUsername(String username) {
        Gui2FormVars.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Gui2FormVars.password = password;
    }

    public static String getLatestEntry() {
        return latestEntry;
    }

    public static void setLatestEntry(String latestEntry) {
        Gui2FormVars.latestEntry = latestEntry;
    }

    public static Date getFromDate() {
        return fromDate;
    }

    public static void setFromDate(Date fromDate) {
        Gui2FormVars.fromDate = fromDate;
    }

    public static Date getToDate() {
        return toDate;
    }

    public static void setToDate(Date toDate) {
        Gui2FormVars.toDate = toDate;
    }

    public static String getDept() {
        return dept;
    }

    public static void setDept(String dept) {
        Gui2FormVars.dept = dept;
    }

    public static String getLlob() {
        return llob;
    }

    public static void setLlob(String llob) {
        Gui2FormVars.llob = llob;
    }

    public static ArrayList<String> getDeptList() {
        return deptList;
    }

    public static void setDeptList(ArrayList<String> deptList) {
        Gui2FormVars.deptList = deptList;
    }

    public static ArrayList<String> getLlobList() {
        return llobList;
    }

    public static void setLlobList(ArrayList<String> llobList) {
        Gui2FormVars.llobList = llobList;
    }

    public static String getSn() {
        return sn;
    }

    public static void setSn(String sn) {
        Gui2FormVars.sn = sn;
    }

    public int getPriceHistoryField() {
        return priceHistoryField;
    }

    public void setPriceHistoryField(int priceHistoryField) {
        this.priceHistoryField = priceHistoryField;
    }

    public static HashMap<Integer, Integer> getIdMap() {
        return idMap;
    }

    public static void setIdMap(HashMap<Integer, Integer> idMap) {
        Gui2FormVars.idMap = idMap;
    }

    public static HashMap<Integer, Date> getFromDateMap() {
        return fromDateMap;
    }

    public static void setFromDateMap(HashMap<Integer, Date> fromDateMap) {
        Gui2FormVars.fromDateMap = fromDateMap;
    }

    public static HashMap<Integer, Date> getToDateMap() {
        return toDateMap;
    }

    public static void setToDateMap(HashMap<Integer, Date> toDateMap) {
        Gui2FormVars.toDateMap = toDateMap;
    }

    public static HashMap<Integer, String> getDeptMap() {
        return deptMap;
    }

    public static void setDeptMap(HashMap<Integer, String> deptMap) {
        Gui2FormVars.deptMap = deptMap;
    }

    public static HashMap<Integer, String> getLlobMap() {
        return llobMap;
    }

    public static void setLlobMap(HashMap<Integer, String> llobMap) {
        Gui2FormVars.llobMap = llobMap;
    }

    public static HashMap<Integer, String> getItemTypeMap() {
        return itemTypeMap;
    }

    public static void setItemTypeMap(HashMap<Integer, String> itemTypeMap) {
        Gui2FormVars.itemTypeMap = itemTypeMap;
    }

    public static HashMap<Integer, String> getItemFormMap() {
        return itemFormMap;
    }

    public static void setItemFormMap(HashMap<Integer, String> itemFormMap) {
        Gui2FormVars.itemFormMap = itemFormMap;
    }

    public static HashMap<Integer, String> getIsbnMap() {
        return isbnMap;
    }

    public static void setIsbnMap(HashMap<Integer, String> isbnMap) {
        Gui2FormVars.isbnMap = isbnMap;
    }

    public static HashMap<Integer, Double> getPriceMap() {
        return priceMap;
    }

    public static void setPriceMap(HashMap<Integer, Double> priceMap) {
        Gui2FormVars.priceMap = priceMap;
    }

    public static HashMap<Integer, String> getCurrMap() {
        return currMap;
    }

    public static void setCurrMap(HashMap<Integer, String> currMap) {
        Gui2FormVars.currMap = currMap;
    }

    public static HashMap<Integer, Integer> getQntyMap() {
        return qntyMap;
    }

    public static void setQntyMap(HashMap<Integer, Integer> qntyMap) {
        Gui2FormVars.qntyMap = qntyMap;
    }

    public HashMap<Integer, Double> getTotal() {
        return total;
    }

    public void setTotal(HashMap<Integer, Double> total) {
        this.total = total;
    }
}
