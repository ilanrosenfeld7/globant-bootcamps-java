package topic_0;
import java.util.Scanner;

import connection.*;


public class Main {
	static Scanner scanner = new Scanner(System.in);
	   public static void main(String[] args) {
		  int num = 0;
	     //singleton of Person working
	      Singleton object = Singleton.getInstance();
	      ConnectionFactory ConnFactory = null;
	      FactoryProducer Producer = new FactoryProducer();
	      object.showMessage();
	      
	      //object Person greeting and giving Gender
	      System.out.println("pick a person to Greet (0 to 4) ");
	      num = scanner.nextInt();
	      System.out.println(object.Greet(num));
	      System.out.println("pick a person to see his/her Gender (0 to 4) ");
	      num= scanner.nextInt();
	      Person p =object.getPerson(num);
	      System.out.println("gender " + p.getGender());
	      
	      // swiching different connection types
	      System.out.println("write your connection type (SQL/ NOSQL)");
	      String ConType = scanner.nextLine();
	      ConnFactory = Producer.getFactory("Connection");
	      Connection newCon= ConnFactory.getConnType(ConType);
	      newCon.connect();
	      
	   }
	}