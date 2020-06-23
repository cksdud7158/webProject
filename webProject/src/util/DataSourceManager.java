package util;

import org.apache.catalina.Context;
import org.apache.tomcat.jdbc.pool.DataSource;

public class DataSourceManager {
	private DataSource ds;

	//singletone
	private static DataSourceManager dsm = new DataSourceManager();
	private DataSourceManager() { //
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup Success");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Failure");
		}
	}
	public static DataSourceManager getInstance() {
		return dsm;
	}
	
	public DataSource getDataSource() {
		return ds;
	}
}
