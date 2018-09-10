package topic_0;

public class Singleton {
	  
      
      
	private static Singleton instance = new Singleton();
	static PersonMockDatabase pdb= new PersonMockDatabase();
	
	private Singleton() {}
	
	public static Singleton getInstance(){
		pdb.go();
		return instance;
	}
	
	public void showMessage(){
		
		System.out.println("Hello World, im a Singleton!");
	}
	
	public String Greet (int num){
		return pdb.Greet(num);
	}

	public Person getPerson (int num) {
		return pdb.getOnePerson(num);
	}
}
