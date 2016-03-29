package com.sayantan.DAO;

import com.sayantan.ActionForm.Gui2FormVars;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final Logger logger = Logger.getLogger(ConnectionManager.class);

	public  static Connection getConnection(){
		logger.info("TESTING ConnectionManager");

		 try
		    {
		        Class.forName(m_DBDriver);
		    }
		    catch(ClassNotFoundException classnotfoundexception)
		    {
		    	System.out.println("ERROR - Exception occured while loading MYSql driver: "
		   			 + classnotfoundexception.toString());
				logger.info("ERROR - Exception occured while loading MYSql driver: "
			   			 + classnotfoundexception.toString());
		    }

		    try
		    {
		        SYB_con = DriverManager.getConnection(url, username, password);
		        System.out.println("Connection Successful!");
		        logger.info("Connection Successful!");
		    }
		    catch(SQLException exception)
		    {
		    	System.out.println("ERROR - Exception occured while getting connection: "
			 				+ exception.toString());
		    	logger.info("ERROR - Exception occured while getting connection: "
			 				+ exception.toString());
		    }
		    return SYB_con;
	}
	static Connection SYB_con;

	static String m_DBDriver= Gui2FormVars.getM_DBDriver();
	static String url = Gui2FormVars.getUrl();
	static String username = Gui2FormVars.getUsername();
	static String password = Gui2FormVars.getPassword();
}
