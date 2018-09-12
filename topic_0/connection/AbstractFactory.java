package connection;

public abstract class AbstractFactory {
	abstract Connection getConnType(String dbType);

}
