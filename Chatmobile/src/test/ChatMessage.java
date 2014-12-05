package test;

public class ChatMessage {

	String A;
	String B;
	String message;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}

	public ChatMessage(String a, String b, String message) {
		super();
		A = a;
		B = b;
		this.message = message;
	}

	
}
