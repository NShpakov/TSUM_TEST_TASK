package negativeTests;

import conf.Endpoints;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pojo.request.LoginInfo;
import pojo.response.ResponseWrongCapcha;
import steps.StepsRestHttpMethods;

@RunWith(SerenityRunner.class)
public class TSUMRegistrationAPITests {

	@Steps
	StepsRestHttpMethods stepsRestHttpMethods;

	@Before
	public void createAPISoureces() {
		stepsRestHttpMethods.gettingAPIPath(Endpoints.sign_up);
	}

	@Test
	@Title("Запрос с невалидной capcha")
	public void verifyThatWeCanFindRussiaUsingTheCodeRU() {
		stepsRestHttpMethods.preparingRequestBody(new LoginInfo("tsumtest@ya.ru", "123456789", "03AHaCkAaWbimJ3V3OQfD-rmZBxSHaPcf5z5wPaQ2dRCdev2mxwNPZ65C6kWZF9lRygjz4KdyoawnwYVKZ48xyq2a22DEawgK9EotwFwz8Hbx1Nbd83X2LxATLzE0UzAPbmX2txBzpFESYWwcv7kwNGHyX9Z1o-VYCtjxBXrHoEoYqCEA6iVmV2HodNP_v88qIrd9Abc8kS_CA2jg2QqxAt9IF7sJn6vBshUmF0yqSxcYhZEOM5i7I5-VdkHhnu6iCWMB3ck15gk-jAWH4oSIm4DK9z-l6sFeJN7-6OD4LfAI5HbtMx85jkza9cumNgP1wuqp8PJ5nCkqzpYOz0UQaLHmkPrkwCUIVsJZuBvEShVJmTPFhU8ORnqe8fPfZqeJl6pHJolnVJgxa", 3));
		stepsRestHttpMethods.doPostRequest();
		stepsRestHttpMethods.checkHttpResponseBadRequest();
		stepsRestHttpMethods.checkResponseBodyWrongCapcha(new ResponseWrongCapcha("","Invalid captcha",0,null));
	}

	@Test
	@Title("Запрос без параметров")
	public void requestWithoutCookie() {
		stepsRestHttpMethods.preparingRequestBodyWithoutParams();
		stepsRestHttpMethods.doPostRequest();
		//Валидация тут не имеет смысла так как капча невалидна. Тут я отправляю запрос без body
		stepsRestHttpMethods.checkHttpResponseBadRequest();
		stepsRestHttpMethods.checkResponseBodyWrongCapcha(new ResponseWrongCapcha("","Invalid captcha",0,null));
	}
}
