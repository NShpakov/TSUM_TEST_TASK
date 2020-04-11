package pojo.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LoginInfoMain {

	LoginInfo loginInfoObject;

	public LoginInfoMain(LoginInfo loginInfoObject) {
		this.loginInfoObject = loginInfoObject;
	}

	@JsonGetter("login-info")
	public LoginInfo getLoginInfo() {
		return loginInfoObject;
	}

	@JsonSetter("login-info")
	public void setLoginInfo(LoginInfo loginInfoObject) {
		this.loginInfoObject = loginInfoObject;
	}
}