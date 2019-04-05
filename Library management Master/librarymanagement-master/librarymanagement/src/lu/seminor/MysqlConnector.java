package lu.seminor;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlConnector {

	public MysqlDataSource  getDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("Root@123");
		dataSource.setURL("jdbc:mysql://localhost:3306/library");
		return dataSource;
	}
}
