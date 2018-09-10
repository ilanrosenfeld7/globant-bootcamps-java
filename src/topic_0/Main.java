package topic_0;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	   public static void main(String[] args) {
		  int num = 0;
	     
	      Singleton object = Singleton.getInstance();

	     
	      object.showMessage();
	      System.out.println("pick a person (0 to 4) ");
	      num = scanner.nextInt();
	      System.out.println(object.Greet(num));
	      System.out.println("pick a person (0 to 4) ");
	      num= scanner.nextInt();
	      Person p =object.getPerson(num);
	      System.out.println("gender " + p.getGender());
	   }
	}