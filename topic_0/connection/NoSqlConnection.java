package connection;

public class NoSqlConnection implements Connection {

	@Override
	public void connect() {
		System.out.println("Connecting to NO-SQL...");
	}

}
