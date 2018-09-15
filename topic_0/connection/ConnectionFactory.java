package connection;

public class ConnectionFactory extends AbstractFactory {

	@Override
	public Connection getConnType(String dbType) {

		if (dbType == null) {
			
			return null;
		}
		if (dbType.equalsIgnoreCase("SQL")) {
			SqlConnection connection= new SqlConnection();
			return connection;
		}
		if (dbType.equalsIgnoreCase("NOSQL")) {
			NoSqlConnection connection= new NoSqlConnection();
			return connection;
		}
		return null;
	}

}
