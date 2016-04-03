package com.sayantan.ActionForm;

import java.util.ArrayList;
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
    private static String fromDate = "";
    private static String toDate = "";
    private static String dept = "";
    private static ArrayList<String> deptList = new ArrayList<>();
    private int priceHistoryField;

    //create result lists
    private static HashMap<Integer, String> itemType = new HashMap<>();
    private static HashMap<Integer, String> itemForm = new HashMap<>();
    private static HashMap<Integer, String> isbn = new HashMap<>();
    private static HashMap<Integer, Double> price = new HashMap<>();
    private static HashMap<Integer, Integer> qnty = new HashMap<>();
    private HashMap<Integer, Double> total = new HashMap<>();

    // Getters and Setters

    public static String getLatestEntry() {
        return latestEntry;
    }

    public static void setLatestEntry(String latestEntry) {
        Gui2FormVars.latestEntry = latestEntry;
    }

    public int getPriceHistoryField() {
        return priceHistoryField;
    }

    public void setPriceHistoryField(int priceHistoryField) {
        this.priceHistoryField = priceHistoryField;
    }

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

    public static String getFromDate() {
        return fromDate;
    }

    public static void setFromDate(String fromDate) {
        Gui2FormVars.fromDate = fromDate;
    }

    public static String getToDate() {
        return toDate;
    }

    public static void setToDate(String toDate) {
        Gui2FormVars.toDate = toDate;
    }

    public static String getDept() {
        return dept;
    }

    public static void setDept(String dept) {
        Gui2FormVars.dept = dept;
    }

    public static ArrayList<String> getDeptList() {
        return deptList;
    }

    public static void setDeptList(ArrayList<String> deptList) {
        Gui2FormVars.deptList = deptList;
    }

    public static HashMap<Integer, String> getItemType() {
        return itemType;
    }

    public static void setItemType(HashMap<Integer, String> itemType) {
        Gui2FormVars.itemType = itemType;
    }

    public static HashMap<Integer, String> getItemForm() {
        return itemForm;
    }

    public static void setItemForm(HashMap<Integer, String> itemForm) {
        Gui2FormVars.itemForm = itemForm;
    }

    public static HashMap<Integer, String> getIsbn() {
        return isbn;
    }

    public static void setIsbn(HashMap<Integer, String> isbn) {
        Gui2FormVars.isbn = isbn;
    }

    public static HashMap<Integer, Double> getPrice() {
        return price;
    }

    public static void setPrice(HashMap<Integer, Double> price) {
        Gui2FormVars.price = price;
    }

    public static HashMap<Integer, Integer> getQnty() {
        return qnty;
    }

    public static void setQnty(HashMap<Integer, Integer> qnty) {
        Gui2FormVars.qnty = qnty;
    }

    public HashMap<Integer, Double> getTotal() {
        return total;
    }

    public void setTotal(HashMap<Integer, Double> total) {
        this.total = total;
    }
}
