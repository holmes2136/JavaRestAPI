package holmes.sherlock;

public class HelloBean {

	private String name;
	private String helloWord;
	
	public HelloBean() {
		
	}
	
	public HelloBean(String name,String helloWord) {
		this.name = name;
		this.helloWord = helloWord;
	}
	
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
		
	}
	
	public void setHelloWorld(String helloWorld) {
		this.helloWord = helloWorld;
		
	}
	
	public String getHelloWorld() {
		return helloWord;
		
	}
	
	
	
	
	
}
