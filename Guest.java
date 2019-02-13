
public class Guest {

	private String name;
	private String age;
	private String status;

	public Guest(String name, String age, String status) {
		this.name = name;
		this.age = age;
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	public String getAge() {
		return age;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}
