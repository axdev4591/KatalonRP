import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


def applicationName = "GCO"

WebUI.callTestCase(findTestCase('Common/LoginScript'), [('password') : 'srai2018', ('loginName') : 'admin'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/PortalSettingPNG'))

WebUI.click(findTestObject('Object Repository/HomePage/ThirdPartyAPITab'))

WebUI.click(findTestObject('Screens/ThirdPartyAPI/ThirdPartyAPITab - SettingsTab'))

WebUI.click(findTestObject('Screens/ThirdPartyAPI/ThirdPartyAPITab - SettingsTab - AddEndpoint'))

WebUI.setText(findTestObject('Object Repository/Screens/ThirdPartyAPI/inputThirdPartyLabel'),
	applicationName+' Automation')

WebUI.click(findTestObject('Screens/ThirdPartyAPI/selectThirdPartyApplication'))

WebUI.setText(findTestObject('Screens/ThirdPartyAPI/inputThirdPartyApplication'),
	applicationName)

WebUI.sendKeys(findTestObject('Screens/ThirdPartyAPI/inputThirdPartyApplication'),Keys.chord(Keys.TAB))

WebUI.setText(findTestObject('Screens/ThirdPartyAPI/inputThirdPartyURL'),
	GlobalVariable.GCO_URL)

WebUI.setText(findTestObject('Screens/ThirdPartyAPI/inputThirdPartyGoldDomain'),
	GlobalVariable.GOLD_DOMAIN)

WebUI.click(findTestObject('Screens/ThirdPartyAPI/buttonThirdPartySave'))

WebUI.click(findTestObject('Object Repository/HomePage/ThirdPartyAPITab'))

CustomKeywords.'WebTable.selectValue'('//*[@id="edit-third-party-api"]/tbody', applicationName,
	 1)
TestObject myNewObject = new TestObject('ObjectID')

	myNewObject.setSelectorMethod(SelectorMethod.BASIC)

	myNewObject.addProperty('xpath', ConditionType.EQUALS, '//*[@id="edit_third_party_api_gold_sdkthird_party_apigco_endpoint_chosen"]/div/div/input')
	
	
	WebUI.setText(myNewObject,
		applicationName+' Automation')
	
	WebUI.sendKeys(myNewObject,Keys.chord(Keys.TAB))

	
	//Remove the compliance if displayed
	TestObject AgreeOK = new TestObject('ObjectID')
	
	AgreeOK.setSelectorMethod(SelectorMethod.BASIC)
	
	AgreeOK.addProperty('xpath', ConditionType.EQUALS, '//*[@id="popup-buttons"]/button[1]')
	
	if (WebUI.verifyElementClickable(AgreeOK)) {
		 WebUI.click(AgreeOK)
	}
			

	
	TestObject saveButton = new TestObject('ObjectID')
	
		saveButton.setSelectorMethod(SelectorMethod.BASIC)
	
		saveButton.addProperty('type', ConditionType.EQUALS, 'submit')
	
		saveButton.addProperty('id', ConditionType.EQUALS, 'edit-submit')
	
WebUI.click(saveButton)

WebUI.callTestCase(findTestCase('Common/LogoutScript'), [:], FailureHandling.STOP_ON_FAILURE)
