package util;
/*
 * JNDI API를 이용해서 dataSource를 리턴받아 온다. 
 * 싱글톤으로
 */
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		//initialContext 객체의 lookup()을 이용해서 ds하나 받아 오는 로직...
		try {
			// Naming Service(JNDI API)...javax.naming.Context
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		} catch (NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getConnection() {
		return ds;
	}
}
