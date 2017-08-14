package springwelcome;

public class WelcomeBean {
	
	private String messge;
	
	public void setMessage(String message) {
		this.messge = message;
		
	}
	
	public void show() {
		System.out.println(this.messge);
		
	}
}
