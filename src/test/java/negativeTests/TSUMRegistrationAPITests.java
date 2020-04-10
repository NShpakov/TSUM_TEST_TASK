package negativeTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.StepsRestHttpMethods;

@RunWith(SerenityRunner.class)
public class TSUMRegistrationAPITests {

	private static final String BASE_HOST = "https://api.tsum.ru";
	public static final int HTTP_CODE_400 = 400;
	private static String PATH_SIGN_UP = "sign-up";
	public static String COOKIE = "_dy_csc_ses=t; _dy_c_exps=; _dycnst=dg; _dyid=-5724074106894283611; _dyfs=1586367653926; _dyjsession=03b7fa8fe16d13b0f9a13d8217cd764a; _dy_geo=RU.EU.RU_MOW.RU_MOW_Moscow; _dy_df_geo=Russia..Moscow; gtmc_release=75e348b3bd3c0f7fb9450d8a008b39403a0f2243; gtmc_city=null; gtmc_region=null; gtmc_country=%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F; gtmc_cart=%7B%22cnt%22%3A%5B%5D%2C%22id%22%3A%5B%5D%2C%22cd6%22%3A%5B%5D%7D; BITRIX_SM_userAuth=0; _dy_c_att_exps=; gtmc_userid=1000075524; gtmc_email=tsumtest%40ya.ru; gtmc_gender=F; gtmc_dateOfBirth=null; gtmc_loayaltycard=null; gtmc_lctype=null; exp_catalog-dy-v2=0; V20=fg0htvpicqaabqke5a7u0lqql0; BITRIX_SM_user_first_visited=1586458741; bitrix_sessid=fb566dfd51660f7e27c7d57dad5b23f6; user_location_showed=Y; BITRIX_SM_subscribe_confirmed=0; catalogGender=men; siteVer=1.0.0; _dycst=dk.l.c.ms.; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1; BITRIX_SM_user_last_visited=1586501504; _dy_ses_load_seq=73677%3A1586501525264; _dy_soct=1011710.1020015.1586496168*1013071.1022437.1586496168*1001919.1002442.1586501525*1002271.1002962.1586501525*1000863.1000949.1586501525; _dy_toffset=-5356; advanced-frontend=c99d8mk7jdpqs6sh9ia4f45gmr; _vbmd=ZRBpbNcvP_EbYJFW2GwlNqNRA5qCjiEN; gtmc_userAuth=0; uuid=69468344-2100-487b-8673-26ec27e259d4; vbmd=rZGwHf4i-wzAS0RmnCUV36EAsIG9CZayUXi40kGmq0P3w_JtnGyYepAUAQTFb1OIk0fH7fN42OAQTcmRK8_uDQ%3D%3D";
	public static String CONTENT_TYPE = "application/json";
	public static String REQUEST_BODY = "{\"login-info\":{\"id\":\"tsumtest@ya.ru\",\"password\":\"123456789\",\"captcha\":\"03AHaCkAaWbimJ3V3OQfD-rmZBxSHaPcf5z5wPaQ2dRCdev2mxwNPZ65C6kWZF9lRygjz4KdyoawnwYVKZ48xyq2a22DEawgK9EotwFwz8Hbx1Nbd83X2LxATLzE0UzAPbmX2txBzpFESYWwcv7kwNGHyX9Z1o-VYCtjxBXrHoEoYqCEA6iVmV2HodNP_v88qIrd9Abc8kS_CA2jg2QqxAt9IF7sJn6vBshUmF0yqSxcYhZEOM5i7I5-VdkHhnu6iCWMB3ck15gk-jAWH4oSIm4DK9z-l6sFeJN7-6OD4LfAI5HbtMx85jkza9cumNgP1wuqp8PJ5nCkqzpYOz0UQaLHmkPrkwCUIVsJZuBvEShVJmTPFhU8ORnqe8fPfZqeJl6pHJolnVJgxa\",\"captchaVersion\":3}}";
	public static String RESPONSE = "{\"title\":\"\",\"message\":\"Invalid captcha\",\"code\":0,\"data\":null,\"errors\":{\"captcha\":[\"Invalid captcha\"]}}";
	public static String REQUEST_BODY_WITHOUT_ID = "";

	@Steps
	StepsRestHttpMethods stepsRestHttpMethods;

	@Before
	public void createAPISoureces() {
		stepsRestHttpMethods.gettingAPIHost(BASE_HOST);
		stepsRestHttpMethods.gettingAPIPath(PATH_SIGN_UP);
	}

	@Test
	@Title("Запрос с невалидной capcha")
	public void verifyThatWeCanFindRussiaUsingTheCodeRU() {
		stepsRestHttpMethods.preparingRequestBody(CONTENT_TYPE, COOKIE, REQUEST_BODY);
		stepsRestHttpMethods.doPostRequest();
		stepsRestHttpMethods.checkHttpResponse(HTTP_CODE_400, RESPONSE);
	}

	@Test
	@Title("Запрос без параметров")
	public void requestWithoutCookie() {
		stepsRestHttpMethods.preparingRequestBody(CONTENT_TYPE, COOKIE, REQUEST_BODY_WITHOUT_ID);
		stepsRestHttpMethods.doPostRequest();
		stepsRestHttpMethods.checkHttpResponse(HTTP_CODE_400, RESPONSE);
	}
}
