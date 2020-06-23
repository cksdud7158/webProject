package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
