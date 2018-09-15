package connection;

public class FactoryProducer {
	   public ConnectionFactory getFactory(String choice){
	   
	      if(choice.equalsIgnoreCase("CONNECTION")){
	    	  
	         return new ConnectionFactory();
	         
	      
	   }
	      return null;
	}
}