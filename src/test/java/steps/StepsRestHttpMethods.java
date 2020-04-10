package steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import static net.serenitybdd.rest.SerenityRest.*;

public class StepsRestHttpMethods {

	private String host;
	private String path;

	public static final String DELIMETR_SLASH = "/";

	@Step
	public String gettingAPIHost(String host) {
		return this.host = host;
	}

	@Step
	public String gettingAPIPath(String path) {
		return this.path = path;
	}

	@Step
	public void doPostRequest() {
		when().post(host + DELIMETR_SLASH + path);
	}

	@Step
	public void preparingRequestBody(String contebtType, String cookie, String body) {
		given().contentType(contebtType)
				.cookie(cookie)
				.body(body);
	}

	@Step
	public void preparingRequestBody(String contebtType, String body) {
		given().contentType(contebtType)
				.body(body);
	}

	@Step
	public void checkHttpResponse(int statusCode, String responseBody) {
		then().assertThat().statusCode(statusCode).body(Matchers.is(responseBody));
	}

	@Step
	public void checkHttpResponse(int statusCode) {
		then().assertThat().statusCode(statusCode);
	}
}