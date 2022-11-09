import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.common.RestfulClient
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.assertj.core.api.Assertions
import org.eclipse.persistence.sessions.serializers.JSONSerializer
import org.json.JSONObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.common.RestfulClient
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper



public class WSToken {

	@Keyword
	def String generateToken() {
		// REST requests builder
		def builder = new RestRequestObjectBuilder()

		def requestObject = builder
				.withRestRequestMethod("GET")

				.withRestUrl(GlobalVariable.PORTAL_URL+GlobalVariable.ENDPOINT_TOKEN+"/"+GlobalVariable.PORTAL_MAIL_ADMIN)
				.withHttpHeaders([
					new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json"),
					new TestObjectProperty("Authorization", ConditionType.EQUALS, GlobalVariable.WS_AUTHKEY),
				])
				.build()

		// Process the request object to append the query parameters to the URL
		RestfulClient.processRequestParams(requestObject)

		// Run the request
		def responseObject = WS.sendRequest(requestObject)

		// Check the response
		assert responseObject.getStatusCode() == 200

		// Parsing the response text
		def respon = new JsonSlurper().parseText(responseObject.responseText)

		//Return the token for using ws api
		return respon.token;
	}
}