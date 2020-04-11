package steps;

import conf.UserCookie;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import pojo.request.LoginInfo;
import pojo.request.LoginInfoMain;
import pojo.response.ResponseWrongCapcha;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class StepsRestHttpMethods {

	private String path;

	RequestSpecification requestSpecAPITSUM = new RequestSpecBuilder()
			.setBaseUri("https://api.tsum.ru")
			.setAccept(ContentType.JSON)
			.setContentType(ContentType.JSON)
			.log(LogDetail.ALL)
			.build();

	ResponseSpecification response_400 = new ResponseSpecBuilder()
			.expectStatusCode(400)
			.build();

	ResponseSpecification response_403 = new ResponseSpecBuilder()
			.expectStatusCode(403)
			.build();

	ResponseWrongCapcha responseWrongCapcha;

	@Step
	public String gettingAPIPath(String path) {
		return this.path = path;
	}

	@Step
	public void doPostRequest() {
		when().post(path);
	}

	@Step
	public void preparingRequestBodyWithCookie(Object obj) {
		given().spec(requestSpecAPITSUM)
				.cookies(UserCookie.createCookie())
				.body(new LoginInfoMain((LoginInfo) obj));
	}

	@Step
	public void preparingRequestBody(Object obj) {
		given().spec(requestSpecAPITSUM)
				.body(new LoginInfoMain((LoginInfo) obj));
	}

	@Step
	public void preparingRequestBodyWithoutParams() {
		given().spec(requestSpecAPITSUM);
	}

	@Step
	public void checkResponseBodyWrongCapcha(Object respObj) {
		then().assertThat().body("title", equalTo(((ResponseWrongCapcha) respObj).getTitle()));
		then().assertThat().body("message", equalTo(((ResponseWrongCapcha) respObj).getMessage()));
		then().assertThat().body("code", equalTo(((ResponseWrongCapcha) respObj).getCode()));
		then().assertThat().body("data", equalTo(((ResponseWrongCapcha) respObj).getData()));
	}

	@Step
	public void checkHttpResponseBadRequest() {
		then().spec(response_400);
	}

	@Step
	public void checkHttpResponseForbiden() {
		then().spec(response_403);
	}
}