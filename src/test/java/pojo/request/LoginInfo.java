package pojo.request;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("login-info")
public class LoginInfo {

	private String id;
	private String password;
	private String captcha;
	private int captchaVersion;

	public LoginInfo(String id, String password, String captcha, int captchaVersion) {
		this.id = id;
		this.password = password;
		this.captcha = captcha;
		this.captchaVersion = captchaVersion;
	}

	public LoginInfo(String id) {
		this.id = id;
	}

	public LoginInfo() {
	}

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public int getCaptchaVersion() {
		return captchaVersion;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public void setCaptchaVersion(int captchaVersion) {
		this.captchaVersion = captchaVersion;
	}

	@Override
	public String toString() {
		return "LoginInfo{" +
				"id='" + id + '\'' +
				", password='" + password + '\'' +
				", captcha='" + captcha + '\'' +
				", captchaVersion=" + captchaVersion +
				'}';
	}
}
