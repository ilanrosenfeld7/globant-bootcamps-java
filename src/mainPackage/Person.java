package mainPackage;

public class Person {
	private String name;
	private String job;
	private int age;
	private int height;
	private int weight;
	private String eyeColor;
	private String gender;
	private int phone_number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Person(String name, int age, int height, int weight, String eyeColor, String gender) {
		this.name = name;
		this.age= age;
		this.height= height;
		this.weight= weight;
		this.eyeColor= eyeColor;
		this.gender= gender;
	}
	public String Greeting() {
		String sayHi = String.format("Hi, my name is %s, I'm %s years old.", this.getName(), this.getAge() ) ;
		
		return sayHi;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	};
}
