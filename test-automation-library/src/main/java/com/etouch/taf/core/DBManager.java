/*
 * 
 */
package com.etouch.taf.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.config.DBConfig;
import com.etouch.taf.tools.defect.DefectManagerFactory;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * This Class helps to get connection for Databases
 * Right now, it is using JDBC for Database connection.
 */
public class DBManager {
	
	/** The log. */
	static Log log = LogUtil.getLog(DBManager.class);

	/** The db config. */
	DBConfig dbConfig;

	/**
	 * Setter for DBConfig.
	 *
	 * @param dbConfig the new db config
	 */
	public void setDbConfig(DBConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	/**
	 * Create a new database connection and 
	 * acts as a getter for the same.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(dbConfig.getDbClass());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(dbConfig.getDbUrl(),
					dbConfig.getUserName(), dbConfig.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * Execute query based on the given sql.
	 *
	 * @param sql the sql
	 * @return the int
	 */
	public int executeQuery(String sql) {

		int resultCount = 0;

		Connection con = getConnection();
		
		// if the connection or sql is null then resultCount will be null
		if ((con != null) && (sql != null)) {
			Statement stmt;
			try {
				stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					resultCount = rs.getInt(1);
					CommonUtil.sop("Result Count from DB: " + resultCount);
				} // end while

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
			finally
			{
				try{
					con.close();
				}catch(Exception ex)
				{
					log.error(ex.getMessage());
				}				
			}
		} // end try

		return resultCount;
	}
}
