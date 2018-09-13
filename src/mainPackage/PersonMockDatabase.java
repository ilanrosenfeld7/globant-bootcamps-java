package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonMockDatabase{

	List<Person> PersonDB = new ArrayList<Person>();
	
	Person a = new Person("Joe Cole", 42, 173, 82, "Brown", "MALE");
	Person b = new Person("James Harden", 28, 193, 95, "Black", "MALE");
	Person c = new Person("Selena Williams", 30, 180, 72, "Brown", "FEMALE");
	Person d = new Person("Usain Bolt", 36, 173, 82, "Brown", "MALE");
	Person e = new Person("Juan Martin Del Potro", 30, 193, 85, "Brown", "FEMALE");
	Logger l = Logger.getLogger(Person.class.getName());
	void go(){
	this.PersonDB.add(a);
	this.PersonDB.add(b);
	this.PersonDB.add(c);
	this.PersonDB.add(d);
	this.PersonDB.add(e);
	l.info("database initialized");
	
	}
	public String Greet(int ind) {
		String aux = PersonDB.get(ind).Greeting();
		
		return aux;}
	public Person getOnePerson(int ind) {
		Person onePerson = PersonDB.get(ind);
		return onePerson;
	}
}
// hacer base de datos !