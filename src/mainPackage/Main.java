package mainPackage;
import java.util.Scanner;

import connection.*;
import proxy.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	   public static void main(String[] args) {
		  int num1 = 0;
		  int num2 = 0;
		  FactoryProducer Producer = new FactoryProducer();
		  ConnectionFactory ConnFactory = null;
	     //singleton of Person working
	      Singleton object = Singleton.getInstance();
	      object.showMessage();
	      
	      //object Person greeting and giving Gender 
	      System.out.println("pick a person to Greet (0 to 4) ");
	      num1 = scanner.nextInt();
	      System.out.println(object.Greet(num1));
	      System.out.println("pick a person to see his/her Gender (0 to 4) ");
	      num2= scanner.nextInt();
	      Person p = object.getPerson(num2);
	      System.out.println("gender " + p.getGender());
	      
	      // swiching different connection types (comment previous code to test)
	      System.out.println("write your connection type (SQL/ NOSQL)");
	      String ConType = scanner.nextLine();
	      ConnFactory = Producer.getFactory("Connection");
	      Connection newCon= ConnFactory.getConnType(ConType);
	      newCon.connect();
	      // proxy for SlowThing Class
	      
	      
	      Proxy proxy = new Proxy();

			FastThing fastThing = new FastThing();
			fastThing.sayHello();

			proxy.sayHello();
	   }
	}