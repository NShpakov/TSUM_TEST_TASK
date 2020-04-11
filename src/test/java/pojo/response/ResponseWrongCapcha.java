package pojo.response;

public class ResponseWrongCapcha {

	private String title;
	private String message;
	private int code;
	private String data = null;


	// Getter Methods 

	public String getTitle() {
		return title;
	}

	public ResponseWrongCapcha(String title, String message, int code, String data) {
		this.title = title;
		this.message = message;
		this.code = code;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getData() {
		return data;
	}

	// Setter Methods

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setData(String data) {
		this.data = data;
	}
}