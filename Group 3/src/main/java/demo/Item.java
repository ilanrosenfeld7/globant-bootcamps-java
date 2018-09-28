package demo;

public class Item {
    private  long id;
    private  String name;
    private  int price;

    public Item() {

		// TODO Auto-generated constructor stub
	}

	public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


	public long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
    


}
